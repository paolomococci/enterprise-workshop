# demo web application developed thanks to Symfony

## I make a new Symfony project with website-skeleton
```
$ composer2 create-project symfony/website-skeleton sample_web
...
```
## and I edit .env
```
...
DATABASE_URL="mysql://username:password@127.0.0.1:3306/sample_web_db"
...
```

## I add a controller
```
$ php bin/console make:controller

 Choose a name for your controller class (e.g. TinyChefController):
 > SampleController

 created: src/Controller/SampleController.php
 created: templates/sample/index.html.twig

           
  Success! 
           

 Next: Open your new controller class and add some pages!
```
## now I add the web server component
```
$ composer require symfony/web-server-bundle 4.4
./composer.json has been updated
Running composer update symfony/web-server-bundle
Loading composer repositories with package information
Updating dependencies
Lock file operations: 1 install, 0 updates, 0 removals
  - Locking symfony/web-server-bundle (v4.4.0)
Writing lock file
Installing dependencies from lock file (including require-dev)
Package operations: 1 install, 0 updates, 0 removals
  - Downloading symfony/web-server-bundle (v4.4.0)
  - Installing symfony/web-server-bundle (v4.4.0): Extracting archive
Generating optimized autoload files
composer/package-versions-deprecated: Generating version class...
composer/package-versions-deprecated: ...done generating version class
83 packages you are using are looking for funding.
Use the `composer fund` command to find out more!
...
```
