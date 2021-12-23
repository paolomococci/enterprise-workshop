# sample_std, developed thanks to Symfony version 3.4.47

## I creare a new project

```shell
$ composer2 create-project symfony/framework-standard-edition sample_std
...
> Incenteev\ParameterHandler\ScriptHandler::buildParameters
Creating the "app/config/parameters.yml" file
Some parameters are missing. Please provide them.
database_host (127.0.0.1): 127.0.0.1
database_port (null): 3306
database_name (symfony): sample_std_db
database_user (root): user
database_password (null): password
...
```

## list of available commands

```shell
$ php bin/console list
Symfony 3.4.47 (kernel: app, env: dev, debug: true)

Usage:
  command [options] [arguments]

Options:
  -h, --help            Display this help message
  -q, --quiet           Do not output any message
  -V, --version         Display this application version
      --ansi            Force ANSI output
      --no-ansi         Disable ANSI output
  -n, --no-interaction  Do not ask any interactive question
  -e, --env=ENV         The Environment name. [default: "dev"]
      --no-debug        Switches off debug mode.
  -v|vv|vvv, --verbose  Increase the verbosity of messages: 1 for normal output, 2 for more verbose output and 3 for debug

Available commands:
  about                                   Displays information about the current project
  help                                    Displays help for a command
  list                                    Lists commands
 assets
  assets:install                          Installs bundles web assets under a public directory
 cache
  cache:clear                             Clears the cache
  cache:pool:clear                        Clears cache pools
  cache:pool:prune                        Prunes cache pools
  cache:warmup                            Warms up an empty cache
 config
  config:dump-reference                   Dumps the default configuration for an extension
 debug
  debug:autowiring                        Lists classes/interfaces you can use for autowiring
  debug:config                            Dumps the current configuration for an extension
  debug:container                         Displays current services for an application
  debug:event-dispatcher                  Displays configured listeners for an application
  debug:form                              Displays form type information
  debug:router                            Displays current routes for an application
  debug:swiftmailer                       [swiftmailer:debug] Displays current mailers for an application
  debug:twig                              Shows a list of twig functions, filters, globals and tests
 doctrine
  doctrine:cache:clear-collection-region  Clear a second-level cache collection region.
  doctrine:cache:clear-entity-region      Clear a second-level cache entity region.
  doctrine:cache:clear-metadata           Clears all metadata cache for an entity manager
  doctrine:cache:clear-query              Clears all query cache for an entity manager
  doctrine:cache:clear-query-region       Clear a second-level cache query region.
  doctrine:cache:clear-result             Clears result cache for an entity manager
  doctrine:cache:contains                 Check if a cache entry exists
  doctrine:cache:delete                   Delete a cache entry
  doctrine:cache:flush                    [doctrine:cache:clear] Flush a given cache
  doctrine:cache:stats                    Get stats on a given cache provider
  doctrine:database:create                Creates the configured database
  doctrine:database:drop                  Drops the configured database
  doctrine:database:import                Import SQL file(s) directly to Database.
  doctrine:ensure-production-settings     Verify that Doctrine is properly configured for a production environment.
  doctrine:generate:crud                  [generate:doctrine:crud] Generates a CRUD based on a Doctrine entity
  doctrine:generate:entities              [generate:doctrine:entities] Generates entity classes and method stubs from your mapping information
  doctrine:generate:entity                [generate:doctrine:entity] Generates a new Doctrine entity inside a bundle
  doctrine:generate:form                  [generate:doctrine:form] Generates a form type class based on a Doctrine entity
  doctrine:mapping:convert                [orm:convert:mapping] Convert mapping information between supported formats.
  doctrine:mapping:import                 Imports mapping information from an existing database
  doctrine:mapping:info                   
  doctrine:query:dql                      Executes arbitrary DQL directly from the command line.
  doctrine:query:sql                      Executes arbitrary SQL directly from the command line.
  doctrine:schema:create                  Executes (or dumps) the SQL needed to generate the database schema
  doctrine:schema:drop                    Executes (or dumps) the SQL needed to drop the current database schema
  doctrine:schema:update                  Executes (or dumps) the SQL needed to update the database schema to match the current mapping metadata.
  doctrine:schema:validate                Validate the mapping files.
 generate
  generate:bundle                         Generates a bundle
  generate:command                        Generates a console command
  generate:controller                     Generates a controller
 lint
  lint:twig                               Lints a template and outputs encountered errors
  lint:xliff                              Lints a XLIFF file and outputs encountered errors
  lint:yaml                               Lints a file and outputs encountered errors
 router
  router:match                            Helps debug routes by simulating a path info match
 security
  security:check                          Checks security issues in your project dependencies
  security:encode-password                Encodes a password.
 server
  server:log                              Starts a log server that displays logs in real time
  server:run                              Runs a local web server
  server:start                            Starts a local web server in the background
  server:status                           Outputs the status of the local web server
  server:stop                             Stops the local web server that was started with the server:start command
 swiftmailer
  swiftmailer:email:send                  Send simple email message
  swiftmailer:spool:send                  Sends emails from the spool
```
