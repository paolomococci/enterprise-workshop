const fs = require('fs');
const HtmlWebpackPlugin = require('html-webpack-plugin');
const CompressionPlugin = require('compression-webpack-plugin');
const { InjectManifest } = require('workbox-webpack-plugin');
const { DefinePlugin } = require('webpack');
const { WebpackManifestPlugin } = require('webpack-manifest-plugin');
const ExtraWatchWebpackPlugin = require('extra-watch-webpack-plugin');
const ForkTsCheckerWebpackPlugin = require('fork-ts-checker-webpack-plugin');

const StatsPlugin = require('@vaadin/stats-plugin');
const ThemeLiveReloadPlugin = require('@vaadin/theme-live-reload-plugin');
const { ApplicationThemePlugin, processThemeResources, extractThemeName, findParentThemes } = require('@vaadin/application-theme-plugin');

const path = require('path');

const themePartRegex = /(\\|\/)themes\1[\s\S]*?\1/;

const frontendFolder = path.resolve(__dirname, 'frontend');
const frontendGeneratedFolder = path.resolve(__dirname, 'frontend/generated');
const fileNameOfTheFlowGeneratedMainEntryPoint = path.resolve(__dirname, 'target/frontend/generated-flow-imports.js');
const mavenOutputFolderForFlowBundledFiles = path.resolve(__dirname, 'target/META-INF/VAADIN/webapp');
const mavenOutputFolderForResourceFiles = path.resolve(__dirname, 'target/META-INF/VAADIN');
const useClientSideIndexFileForBootstrapping = true;
const clientSideIndexHTML = path.resolve(__dirname, 'target/index.html');
const clientSideIndexEntryPoint = path.resolve(__dirname, 'frontend', 'generated/', 'vaadin.ts');;
const devmodeGizmoJS = path.resolve(__dirname, 'target/flow-frontend/VaadinDevmodeGizmo.js');
const pwaEnabled = false;
const offlinePathEnabled = true;
const offlinePath = 'offline.html';
const clientServiceWorkerEntryPoint = path.resolve(__dirname, 'target/sw');
const VAADIN = 'VAADIN';
const build = 'build';
const config = 'config';
const outputFolder = mavenOutputFolderForFlowBundledFiles;
const indexHtmlPath = 'index.html';
const buildFolder = path.resolve(outputFolder, VAADIN, build);
const confFolder = path.resolve(mavenOutputFolderForResourceFiles, config);
const serviceWorkerPath = 'sw.js';
const statsFile = `${confFolder}/stats.json`;

const projectStaticAssetsFolders = [
  path.resolve(__dirname, 'src', 'main', 'resources', 'META-INF', 'resources'),
  path.resolve(__dirname, 'src', 'main', 'resources', 'static'),
  frontendFolder
];

const projectStaticAssetsOutputFolder = path.resolve(__dirname, 'target/META-INF/VAADIN/webapp/VAADIN/static');

const themeProjectFolders = projectStaticAssetsFolders.map((folder) =>
  path.resolve(folder, 'themes')
);

const tsconfigJsonFile = path.resolve(__dirname, 'tsconfig.json');
const enableTypeScript = fs.existsSync(tsconfigJsonFile);

const flowFrontendFolder = path.resolve(__dirname, 'target/flow-frontend');

const devMode = process.argv.find(v => v.indexOf('webpack-dev-server') >= 0);
if (!devMode) {
  const mkdirp = require('mkdirp');
  mkdirp(buildFolder);
  mkdirp(confFolder);
}

let stats;

const watchDogPort = devMode && process.env.watchDogPort;
if (watchDogPort) {
  const runWatchDog = () => {
    const client = new require('net').Socket();
    client.setEncoding('utf8');
    client.on('error', function () {
      console.log("Watchdog connection error. Terminating webpack process...");
      client.destroy();
      process.exit(0);
    });
    client.on('close', function () {
      client.destroy();
      runWatchDog();
    });

    client.connect(watchDogPort, 'localhost');
  }
  runWatchDog();
}

const webPackEntries = {};
if (useClientSideIndexFileForBootstrapping) {
  webPackEntries.bundle = clientSideIndexEntryPoint;
  const dirName = path.dirname(fileNameOfTheFlowGeneratedMainEntryPoint);
  const baseName = path.basename(fileNameOfTheFlowGeneratedMainEntryPoint, '.js');
  if (fs.readdirSync(dirName).filter(fileName => !fileName.startsWith(baseName) && fileName.endsWith(".js") && fileName.includes("-")).length) {
    webPackEntries.export = fileNameOfTheFlowGeneratedMainEntryPoint;
  }
} else {
  webPackEntries.bundle = fileNameOfTheFlowGeneratedMainEntryPoint;
}

const appShellUrl = '.';
let appShellManifestEntry = undefined;

const swManifestTransform = (manifestEntries) => {
  const warnings = [];
  const manifest = manifestEntries;
  if (useClientSideIndexFileForBootstrapping) {
    const indexEntryIdx = manifest.findIndex(entry => entry.url === 'index.html');
    if (indexEntryIdx !== -1) {
      manifest[indexEntryIdx].url = appShellUrl;
      appShellManifestEntry = manifest[indexEntryIdx];
    } else {
      manifest.push(appShellManifestEntry);
    }
  }
  return { manifest, warnings };
};

const createServiceWorkerPlugin = function() {
  return new InjectManifest({
    swSrc: clientServiceWorkerEntryPoint,
    swDest: serviceWorkerPath,
    manifestTransforms: [swManifestTransform],
    maximumFileSizeToCacheInBytes: 100 * 1024 * 1024,
    dontCacheBustURLsMatching: /.*-[a-z0-9]{20}\.cache\.js/,
    include: [
      (chunk) => {
        return true;
      },
    ],
    webpackCompilationPlugins: [
      new DefinePlugin({
        OFFLINE_PATH_ENABLED: offlinePathEnabled,
        OFFLINE_PATH: JSON.stringify(offlinePath)
      }),
    ],
  });
}

if (devMode) {
  webPackEntries.devmodeGizmo = devmodeGizmoJS;
}

const flowFrontendThemesFolder = path.resolve(flowFrontendFolder, 'themes');
const themeOptions = {
  devMode: devMode,
  themeResourceFolder: flowFrontendThemesFolder,
  themeProjectFolders: themeProjectFolders,
  projectStaticAssetsOutputFolder: projectStaticAssetsOutputFolder,
  frontendGeneratedFolder: frontendGeneratedFolder
};
let themeName = undefined;
let themeWatchFolders = undefined;
if (devMode) {
  themeName = extractThemeName(frontendGeneratedFolder);
  const parentThemePaths = findParentThemes(themeName, themeOptions);
  const currentThemeFolders = [...projectStaticAssetsFolders
    .map((folder) => path.resolve(folder, "themes", themeName)),
    path.resolve(flowFrontendThemesFolder, themeName)];
  themeWatchFolders = [...currentThemeFolders, ...parentThemePaths]
    .map((themeFolder) => path.resolve(themeFolder, "components"));
}

const processThemeResourcesCallback = (logger) => processThemeResources(themeOptions, logger);

exports = {
  frontendFolder: `${frontendFolder}`,
  buildFolder: `${buildFolder}`,
  confFolder: `${confFolder}`
};

module.exports = {
  mode: 'production',
  context: frontendFolder,
  entry: webPackEntries,

  output: {
    filename: `${VAADIN}/${build}/vaadin-[name]-[contenthash].cache.js`,
    path: outputFolder
  },

  resolve: {
    modules: [
      'node_modules',
      flowFrontendFolder,
      ...projectStaticAssetsFolders,
    ],
    extensions: [
      enableTypeScript && '.ts',
      '.js'
    ].filter(Boolean),
    alias: {
      Frontend: frontendFolder
    }
  },

  devServer: {
    contentBase: [outputFolder, 'src/main/webapp'],
    after: function(app, server) {
      app.get(`/stats.json`, function(req, res) {
        res.json(stats);
      });
      app.get(`/stats.hash`, function(req, res) {
        res.json(stats.hash.toString());
      });
      app.get(`/assetsByChunkName`, function(req, res) {
        res.json(stats.assetsByChunkName);
      });
      app.get(`/stop`, function(req, res) {
        console.log("Stopped 'webpack-dev-server'");
        process.exit(0);
      });
    }
  },

  module: {
    rules: [
      enableTypeScript && {
        test: /\.ts$/,
        loader: 'ts-loader',
        options: {
          transpileOnly: true,
          experimentalWatchApi: true
        }
      },
      {
        test: /\.css$/i,
        use: [
          {
            loader: "lit-css-loader"
          },
          {
            loader: "extract-loader"
          },
          {
            loader: 'css-loader',
            options: {
              url: (url, resourcePath) => {
                // Only translate files from node_modules
                const resolve = resourcePath.match(/(\\|\/)node_modules\1/);
                const themeResource = resourcePath.match(themePartRegex) && url.match(/^themes\/[\s\S]*?\//);
                return resolve || themeResource;
              },
              importLoaders: 1
            },
          },
          {
            loader: '@vaadin/theme-loader',
            options: {
              devMode: devMode
            }
          }
        ],
      },
      {
        test: /\.(png|gif|jpg|jpeg|svg|eot|woff|woff2|otf|ttf)$/,
        use: [{
          loader: 'file-loader',
          options: {
            outputPath: 'VAADIN/static/',
            name(resourcePath, resourceQuery) {
              if (resourcePath.match(/(\\|\/)node_modules\1/)) {
                return /(\\|\/)node_modules\1(?!.*node_modules)([\S]+)/.exec(resourcePath)[2].replace(/\\/g, "/");
              }
              if (resourcePath.match(/(\\|\/)flow-frontend\1/)) {
                return /(\\|\/)flow-frontend\1(?!.*flow-frontend)([\S]+)/.exec(resourcePath)[2].replace(/\\/g, "/");
              }
              return '[path][name].[ext]';
            }
          }
        }],
      },
    ].filter(Boolean)
  },
  performance: {
    maxEntrypointSize: 2097152,
    maxAssetSize: 2097152
  },
  plugins: [
    new WebpackManifestPlugin(),

    new ApplicationThemePlugin(themeOptions),

    ...(devMode && themeName ? [new ExtraWatchWebpackPlugin({
      files: [],
      dirs: themeWatchFolders
    }), new ThemeLiveReloadPlugin(processThemeResourcesCallback)] : []),

    new StatsPlugin({
      devMode: devMode,
      statsFile: statsFile,
      setResults: function (statsFile) {
        stats = statsFile;
      }
    }),

    useClientSideIndexFileForBootstrapping && new HtmlWebpackPlugin({
      template: clientSideIndexHTML,
      filename: indexHtmlPath,
      inject: 'head',
      scriptLoading: 'defer',
      chunks: ['bundle', ...(devMode ? ['devmodeGizmo'] : [])]
    }),

    pwaEnabled && createServiceWorkerPlugin(),

    !devMode && new CompressionPlugin(),

    enableTypeScript && new ForkTsCheckerWebpackPlugin({
      typescript: {
        configFile: tsconfigJsonFile
      }
    }),
  ].filter(Boolean)
};
