const fs = require('fs');

const versionsFile = require('path').resolve(__dirname, 'target/frontend/versions.json');

if (!fs.existsSync(versionsFile)) {
  return;
}
const versions = JSON.parse(fs.readFileSync(versionsFile, 'utf-8'));

module.exports = {
  hooks: {
    readPackage
  }
};

function readPackage(pkg) {
  const {dependencies} = pkg;
  
  if (dependencies) {
    for (let k in versions) {
      if (dependencies[k] && dependencies[k] !== versions[k]) {
        pkg.dependencies[k] = versions[k];
      }
    }
  }

  if (pkg.dependencies.chokidar) {
    pkg.dependencies.chokidar = '^3.4.0';
  }

  return pkg;
}
