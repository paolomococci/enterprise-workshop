# demo web application developed thanks to Symfony

## I make a new Symfony project with website-skeleton
```
$ composer create-project symfony/website-skeleton sample_web
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
## I start the server, really useful in this development phase
```
$ php bin/console server:run

                                                                                                                        
 [OK] Server listening on http://127.0.0.1:8000                                                                         
                                                                                                                        

 // Quit the server with CONTROL-C.                                                                                     

PHP 7.2.24-0ubuntu0.18.04.7 Development Server started at Sun Apr 25 09:04:04 2021
Listening on http://127.0.0.1:8000
Document root is /home/paolo/Workbench/workspace/enterprise-workshop/symfony/sample_web/public
Press Ctrl-C to quit.
```
## after stopping the server, I integrate an bug fixing component
```
$ composer require friendsofphp/php-cs-fixer
Using version ^2.18 for friendsofphp/php-cs-fixer
./composer.json has been updated
Running composer update friendsofphp/php-cs-fixer
Loading composer repositories with package information
Updating dependencies
Lock file operations: 5 installs, 0 updates, 0 removals
  - Locking composer/semver (3.2.4)
  - Locking composer/xdebug-handler (2.0.0)
  - Locking friendsofphp/php-cs-fixer (v2.18.6)
  - Locking php-cs-fixer/diff (v1.3.1)
  - Locking symfony/polyfill-php70 (v1.20.0)
Writing lock file
Installing dependencies from lock file (including require-dev)
Nothing to install, update or remove
Generating optimized autoload files
composer/package-versions-deprecated: Generating version class...
composer/package-versions-deprecated: ...done generating version class
87 packages you are using are looking for funding.
Use the `composer fund` command to find out more!

Run composer recipes at any time to see the status of your Symfony recipes.

Executing script cache:clear [OK]
Executing script assets:install public [OK]

Nothing to unpack
```
## list of available commands
```
$ php bin/console list
Symfony 5.2.6 (env: dev, debug: true)

Usage:
  command [options] [arguments]

Options:
  -h, --help            Display help for the given command. When no command is given display help for the list command
  -q, --quiet           Do not output any message
  -V, --version         Display this application version
      --ansi            Force ANSI output
      --no-ansi         Disable ANSI output
  -n, --no-interaction  Do not ask any interactive question
  -e, --env=ENV         The Environment name. [default: "dev"]
      --no-debug        Switch off debug mode.
  -v|vv|vvv, --verbose  Increase the verbosity of messages: 1 for normal output, 2 for more verbose output and 3 for debug

Available commands:
  about                                      Display information about the current project
  help                                       Display help for a command
  list                                       List commands
 assets
  assets:install                             Install bundle's web assets under a public directory
 cache
  cache:clear                                Clear the cache
  cache:pool:clear                           Clear cache pools
  cache:pool:delete                          Delete an item from a cache pool
  cache:pool:list                            List available cache pools
  cache:pool:prune                           Prune cache pools
  cache:warmup                               Warm up an empty cache
 config
  config:dump-reference                      Dump the default configuration for an extension
 dbal
  dbal:run-sql                               Executes arbitrary SQL directly from the command line.
 debug
  debug:autowiring                           List classes/interfaces you can use for autowiring
  debug:config                               Dump the current configuration for an extension
  debug:container                            Display current services for an application
  debug:event-dispatcher                     Display configured listeners for an application
  debug:form                                 Display form type information
  debug:router                               Display current routes for an application
  debug:translation                          Display translation messages information
  debug:twig                                 Show a list of twig functions, filters, globals and tests
  debug:validator                            Display validation constraints for classes
 doctrine
  doctrine:cache:clear-collection-region     Clear a second-level cache collection region
  doctrine:cache:clear-entity-region         Clear a second-level cache entity region
  doctrine:cache:clear-metadata              Clears all metadata cache for an entity manager
  doctrine:cache:clear-query                 Clears all query cache for an entity manager
  doctrine:cache:clear-query-region          Clear a second-level cache query region
  doctrine:cache:clear-result                Clears result cache for an entity manager
  doctrine:database:create                   Creates the configured database
  doctrine:database:drop                     Drops the configured database
  doctrine:database:import                   Import SQL file(s) directly to Database.
  doctrine:ensure-production-settings        Verify that Doctrine is properly configured for a production environment
  doctrine:mapping:convert                   [orm:convert:mapping] Convert mapping information between supported formats
  doctrine:mapping:import                    Imports mapping information from an existing database
  doctrine:mapping:info                      
  doctrine:migrations:current                [current] Outputs the current version
  doctrine:migrations:diff                   [diff] Generate a migration by comparing your current database to your mapping information.
  doctrine:migrations:dump-schema            [dump-schema] Dump the schema for your database to a migration.
  doctrine:migrations:execute                [execute] Execute one or more migration versions up or down manually.
  doctrine:migrations:generate               [generate] Generate a blank migration class.
  doctrine:migrations:latest                 [latest] Outputs the latest version
  doctrine:migrations:list                   [list-migrations] Display a list of all available migrations and their status.
  doctrine:migrations:migrate                [migrate] Execute a migration to a specified version or the latest available version.
  doctrine:migrations:rollup                 [rollup] Rollup migrations by deleting all tracked versions and insert the one version that exists.
  doctrine:migrations:status                 [status] View the status of a set of migrations.
  doctrine:migrations:sync-metadata-storage  [sync-metadata-storage] Ensures that the metadata storage is at the latest version.
  doctrine:migrations:up-to-date             [up-to-date] Tells you if your schema is up-to-date.
  doctrine:migrations:version                [version] Manually add and delete migration versions from the version table.
  doctrine:query:dql                         Executes arbitrary DQL directly from the command line
  doctrine:query:sql                         Executes arbitrary SQL directly from the command line.
  doctrine:schema:create                     Executes (or dumps) the SQL needed to generate the database schema
  doctrine:schema:drop                       Executes (or dumps) the SQL needed to drop the current database schema
  doctrine:schema:update                     Executes (or dumps) the SQL needed to update the database schema to match the current mapping metadata
  doctrine:schema:validate                   Validate the mapping files
 lint
  lint:container                             Ensure that arguments injected into services match type declarations
  lint:twig                                  Lint a template and outputs encountered errors
  lint:xliff                                 Lint an XLIFF file and outputs encountered errors
  lint:yaml                                  Lint a file and outputs encountered errors
 make
  make:auth                                  Creates a Guard authenticator of different flavors
  make:command                               Creates a new console command class
  make:controller                            Creates a new controller class
  make:crud                                  Creates CRUD for Doctrine entity class
  make:docker:database                       Adds a database container to your docker-compose.yaml file
  make:entity                                Creates or updates a Doctrine entity class, and optionally an API Platform resource
  make:fixtures                              Creates a new class to load Doctrine fixtures
  make:form                                  Creates a new form class
  make:message                               Creates a new message and handler
  make:messenger-middleware                  Creates a new messenger middleware
  make:migration                             Creates a new migration based on database changes
  make:registration-form                     Creates a new registration form system
  make:reset-password                        Create controller, entity, and repositories for use with symfonycasts/reset-password-bundle
  make:serializer:encoder                    Creates a new serializer encoder class
  make:serializer:normalizer                 Creates a new serializer normalizer class
  make:subscriber                            Creates a new event subscriber class
  make:test                                  [make:unit-test|make:functional-test] Creates a new test class
  make:twig-extension                        Creates a new Twig extension class
  make:user                                  Creates a new security user class
  make:validator                             Creates a new validator and constraint class
  make:voter                                 Creates a new security voter class
 router
  router:match                               Help debug routes by simulating a path info match
 secrets
  secrets:decrypt-to-local                   Decrypt all secrets and stores them in the local vault
  secrets:encrypt-from-local                 Encrypt all local secrets to the vault
  secrets:generate-keys                      Generate new encryption keys
  secrets:list                               List all secrets
  secrets:remove                             Remove a secret from the vault
  secrets:set                                Set a secret in the vault
 security
  security:encode-password                   Encode a password
 server
  server:dump                                Start a dump server that collects and displays dumps in a single place
  server:log                                 Starts a log server that displays logs in real time
  server:run                                 Runs a local web server
  server:start                               Starts a local web server in the background
  server:status                              Outputs the status of the local web server
  server:stop                                Stops the local web server that was started with the server:start command
 translation
  translation:update                         Update the translation file
```
## now I check the route /sample
```
$ php bin/console router:match /sample


                                                                                                                        
 [OK] Route "sample" matches                                                                                            
                                                                                                                        

+--------------+---------------------------------------------------------+
| Property     | Value                                                   |
+--------------+---------------------------------------------------------+
| Route Name   | sample                                                  |
| Path         | /sample                                                 |
| Path Regex   | {^/sample$}sDu                                          |
| Host         | ANY                                                     |
| Host Regex   |                                                         |
| Scheme       | ANY                                                     |
| Method       | GET|HEAD                                                |
| Requirements | NO CUSTOM                                               |
| Class        | Symfony\Component\Routing\Route                         |
| Defaults     | _controller: App\Controller\SampleController::index()   |
| Options      | compiler_class: Symfony\Component\Routing\RouteCompiler |
|              | utf8: true                                              |
+--------------+---------------------------------------------------------+
```
## after having additional controllers, I check all routes
```
$ php bin/console debug:router
 -------------------------- ---------- -------- ------ ----------------------------------- 
  Name                       Method     Scheme   Host   Path                               
 -------------------------- ---------- -------- ------ ----------------------------------- 
  _preview_error             ANY        ANY      ANY    /_error/{code}.{_format}           
  _wdt                       ANY        ANY      ANY    /_wdt/{token}                      
  _profiler_home             ANY        ANY      ANY    /_profiler/                        
  _profiler_search           ANY        ANY      ANY    /_profiler/search                  
  _profiler_search_bar       ANY        ANY      ANY    /_profiler/search_bar              
  _profiler_phpinfo          ANY        ANY      ANY    /_profiler/phpinfo                 
  _profiler_search_results   ANY        ANY      ANY    /_profiler/{token}/search/results  
  _profiler_open_file        ANY        ANY      ANY    /_profiler/open                    
  _profiler                  ANY        ANY      ANY    /_profiler/{token}                 
  _profiler_router           ANY        ANY      ANY    /_profiler/{token}/router          
  _profiler_exception        ANY        ANY      ANY    /_profiler/{token}/exception       
  _profiler_exception_css    ANY        ANY      ANY    /_profiler/{token}/exception.css   
  hello                      GET|HEAD   ANY      ANY    /hello                             
  home                       GET|HEAD   ANY      ANY    /home                              
  sample                     GET|HEAD   ANY      ANY    /sample                            
 -------------------------- ---------- -------- ------ ----------------------------------- 
```
## finally I create an entity giving it the name Item
```
$ php bin/console make:entity

 Class name of the entity to create or update (e.g. GentlePuppy):
 > Item

 created: src/Entity/Item.php
 created: src/Repository/ItemRepository.php
 
 Entity generated! Now let's add some fields!
 You can always add more fields later manually or by re-running this command.

 New property name (press <return> to stop adding fields):
 > name

 Field type (enter ? to see all types) [string]:
 > string

 Field length [255]:
 > 255

 Can this field be null in the database (nullable) (yes/no) [no]:
 > no

 updated: src/Entity/Item.php

 Add another property? Enter the property name (or press <return> to stop adding fields):
 > description

 Field type (enter ? to see all types) [string]:
 > string

 Field length [255]:
 > 512

 Can this field be null in the database (nullable) (yes/no) [no]:
 > yes

 updated: src/Entity/Item.php

 Add another property? Enter the property name (or press <return> to stop adding fields):
 > price

 Field type (enter ? to see all types) [string]:
 > integer

 Can this field be null in the database (nullable) (yes/no) [no]:
 > yes

 updated: src/Entity/Item.php

 Add another property? Enter the property name (or press <return> to stop adding fields):
 > 


           
  Success! 
           

 Next: When you're ready, create a migration with php bin/console make:migration
```
## now I create the file necessary for the so-called "migration"
```
$ php bin/console make:migration


           
  Success! 
           

 Next: Review the new migration "migrations/Version20210425163729.php"
 Then: Run the migration with php bin/console doctrine:migrations:migrate
 ...
```
## and I carry out the actual "migration"
```
$ php bin/console doctrine:migrations:migrate

 WARNING! You are about to execute a migration in database "sample_web_db" that could result in schema changes and data loss. Are you sure you wish to continue? (yes/no) [yes]:
 > yes

[notice] Migrating up to DoctrineMigrations\Version20210425163729
[notice] finished in 31.5ms, used 20M memory, 1 migrations executed, 1 sql queries
```
## and now I make the CRUD interface
```
$ php bin/console make:crud Item

 Choose a name for your controller class (e.g. ItemController) [ItemController]:
 > ItemController

 created: src/Controller/ItemController.php
 created: src/Form/ItemType.php
 created: templates/item/_delete_form.html.twig
 created: templates/item/_form.html.twig
 created: templates/item/edit.html.twig
 created: templates/item/index.html.twig
 created: templates/item/new.html.twig
 created: templates/item/show.html.twig

           
  Success! 
           

 Next: Check your new CRUD by going to /item/
```
