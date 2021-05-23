const fs = require('fs');
const CopyWebpackPlugin = require('copy-webpack-plugin');
const CompressionPlugin = require('compression-webpack-plugin');
const {BabelMultiTargetPlugin} = require('webpack-babel-multi-target-plugin');

const path = require('path');
const baseDir = path.resolve(__dirname);
const frontendFolder = require('path').resolve(__dirname, 'frontend');

const fileNameOfTheFlowGeneratedMainEntryPoint = require('path').resolve(__dirname, 'target/frontend/generated-flow-imports.js');
const mavenOutputFolderForFlowBundledFiles = require('path').resolve(__dirname, 'build/resources/main/META-INF/VAADIN');

const build = 'build';
const config = 'config';
const buildFolder = `${mavenOutputFolderForFlowBundledFiles}/${build}`;
const confFolder = `${mavenOutputFolderForFlowBundledFiles}/${config}`;
const statsFile = `${confFolder}/stats.json`;
const mkdirp = require('mkdirp');

const devMode = process.argv.find(v => v.indexOf('webpack-dev-server') >= 0);

!devMode && mkdirp(buildFolder);
mkdirp(confFolder);

let stats;

const watchDogPrefix = '--watchDogPort=';
let watchDogPort = process.argv.find(v => v.indexOf(watchDogPrefix) >= 0);
if (watchDogPort){
    watchDogPort = watchDogPort.substr(watchDogPrefix.length);
}

const transpile = !devMode || process.argv.find(v => v.indexOf('--transpile-es5') >= 0);

const net = require('net');

function setupWatchDog(){
    var client = new net.Socket();
    client.connect(watchDogPort, 'localhost');

    client.on('error', function(){
        console.log("Watchdog connection error. Terminating webpack process...");
        client.destroy();
        process.exit(0);
    });

    client.on('close', function() {
        client.destroy();
        setupWatchDog();
    });  
}

if (watchDogPort){
    setupWatchDog();
}


exports = {
  frontendFolder: `${frontendFolder}`,
  buildFolder: `${buildFolder}`,
  confFolder: `${confFolder}`
};

module.exports = {
  mode: 'production',
  context: frontendFolder,
  entry: {
    bundle: fileNameOfTheFlowGeneratedMainEntryPoint
  },

  output: {
    filename: `${build}/vaadin-[name]-[contenthash].cache.js`,
    path: mavenOutputFolderForFlowBundledFiles,
    publicPath: 'VAADIN/',
  },

  resolve: {
    alias: {
      Frontend: frontendFolder
    }
  },

  devServer: {
    contentBase: [mavenOutputFolderForFlowBundledFiles, 'src/main/webapp'],
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
      ...(transpile ? [{
        test: /\.js$/,
        use: [BabelMultiTargetPlugin.loader()]
      }] : []),
      {
        test: /\.css$/i,
        use: ['raw-loader']
      }
    ]
  },
  performance: {
    maxEntrypointSize: 2097152,
    maxAssetSize: 2097152
  },
  plugins: [
    ...(devMode ? [] : [new CompressionPlugin()]),
    ...(transpile ? [new BabelMultiTargetPlugin({
      babel: {
        plugins: [
          "@babel/plugin-transform-block-scoping",
          "@babel/plugin-proposal-object-rest-spread"
        ],

        presetOptions: {
          useBuiltIns: false
        }
      },
      targets: {
        'es6': {
          browsers: [
            'last 1 Chrome major versions'
          ],
        },
        'es5': { // IE11
          browsers: [
            'ie 11'
          ],
          tagAssetsWithKey: true,
        }
      }
    })] : []),

    function (compiler) {
      compiler.hooks.afterEmit.tapAsync("FlowIdPlugin", (compilation, done) => {
        let statsJson = compilation.getStats().toJson();
        let acceptedKeys = statsJson.assets.filter(asset => asset.chunks.length > 0 && !asset.chunkNames.toString().includes("es5"))
          .map(asset => asset.chunks).reduce((acc, val) => acc.concat(val), []);

        const modules = collectModules(statsJson, acceptedKeys);

        const chunks = collectChunks(statsJson, acceptedKeys);

        let customStats = {
          hash: statsJson.hash,
          assetsByChunkName: statsJson.assetsByChunkName,
          chunks: chunks,
          modules: modules
        };

        if (!devMode) {
          console.log("         Emitted " + statsFile);
          fs.writeFile(statsFile, JSON.stringify(customStats, null, 1), done);
        } else {
          console.log("         Serving the 'stats.json' file dynamically.");

          stats = customStats;
          done();
        }
      });
    },

    new CopyWebpackPlugin([{
      from: `${baseDir}/node_modules/@webcomponents/webcomponentsjs`,
      to: `${build}/webcomponentsjs/`
    }]),
  ]
};

function collectChunks(statsJson, acceptedChunks) {
  const chunks = [];
  if (statsJson.chunks) {
    statsJson.chunks.forEach(function (chunk) {
      if (acceptedChunks.includes(chunk.id)) {
        const modules = [];
        chunk.modules.forEach(function (module) {
          const slimModule = {
            id: module.id,
            name: module.name,
            source: module.source,
          };
          modules.push(slimModule);
        });
        const slimChunk = {
          id: chunk.id,
          names: chunk.names,
          files: chunk.files,
          hash: chunk.hash,
          modules: modules
        }
        chunks.push(slimChunk);
      }
    });
  }
  return chunks;
}

function collectModules(statsJson, acceptedChunks) {
  let modules = [];
  if (statsJson.modules) {
    statsJson.modules.forEach(function (module) {
      if (module.chunks.filter(key => acceptedChunks.includes(key)).length > 0
          && (module.name.includes("generated-flow-imports.js") || module.name.includes("generated-flow-imports-fallback.js"))) {
        let subModules = [];
        if (module.modules) {
          module.modules.filter(module => !module.name.includes("es5")).forEach(function (module) {
            const subModule = {
              name: module.name,
              source: module.source
            };
            subModules.push(subModule);
          });
        }
        const slimModule = {
          id: module.id,
          name: module.name,
          source: module.source,
          modules: subModules
        };
        modules.push(slimModule);
      }
    });
  }
  return modules;
}
