# e_teams_simple

## I make a new Symfony project with website-skeleton
```
$ composer create-project symfony/website-skeleton e_teams_simple
```
## and I edit .env
```
...
DATABASE_URL="mysql://username:password@127.0.0.1:3306/e_teams_simple_db"
...
```
## now I add the web server component
```
$ composer require symfony/web-server-bundle 4.4
```
## I integrate an bug fixing component
```
composer require friendsofphp/php-cs-fixer
```
## Integrate the Symfony security-bundle component
```
$ composer require symfony/security-bundle
```
# I add User class
```
$ php bin/console make:user 
```
## I create the user entity and perform the migration
```
$ php bin/console make:entity
$ php bin/console make:migration
$ php bin/console doctrine:migrations:migrate
$ php bin/console make:auth
```
## Debug of routes
```
$ bin/console debug:router                                                                                                                               
 -------------------------- -------- -------- ------ -----------------------------------                                                                                         
  Name                       Method   Scheme   Host   Path                                                                                                                       
 -------------------------- -------- -------- ------ -----------------------------------                                                                                         
  _preview_error             ANY      ANY      ANY    /_error/{code}.{_format}                                                                                                   
  _wdt                       ANY      ANY      ANY    /_wdt/{token}                                                                                                              
  _profiler_home             ANY      ANY      ANY    /_profiler/                                                                                                                
  _profiler_search           ANY      ANY      ANY    /_profiler/search                                                                                                          
  _profiler_search_bar       ANY      ANY      ANY    /_profiler/search_bar                                                                                                      
  _profiler_phpinfo          ANY      ANY      ANY    /_profiler/phpinfo                                                                                                         
  _profiler_search_results   ANY      ANY      ANY    /_profiler/{token}/search/results                                                                                          
  _profiler_open_file        ANY      ANY      ANY    /_profiler/open                                                                                                            
  _profiler                  ANY      ANY      ANY    /_profiler/{token}                                                                                                         
  _profiler_router           ANY      ANY      ANY    /_profiler/{token}/router                                                                                                  
  _profiler_exception        ANY      ANY      ANY    /_profiler/{token}/exception       
  _profiler_exception_css    ANY      ANY      ANY    /_profiler/{token}/exception.css   
  app_login                  ANY      ANY      ANY    /login                             
  app_logout                 ANY      ANY      ANY    /logout                            
 -------------------------- -------- -------- ------ -----------------------------------
```
## I make index controller and test this path
```
$ php bin/console make:controller                                                                                                                        

 Choose a name for your controller class (e.g. VictoriousPuppyController):
 > IndexController

 created: src/Controller/IndexController.php
 created: templates/index/index.html.twig

           
  Success! 
           

 Next: Open your new controller class and add some pages!
$ php bin/console router:match /index                                                                                                                    


                                                                                                                        
 [OK] Route "index" matches                                                                                             
                                                                                                                        

+--------------+---------------------------------------------------------+
| Property     | Value                                                   |
+--------------+---------------------------------------------------------+
| Route Name   | index                                                   |
| Path         | /index                                                  |
| Path Regex   | {^/index$}sDu                                           |
| Host         | ANY                                                     |
| Host Regex   |                                                         |
| Scheme       | ANY                                                     |
| Method       | ANY                                                     |
| Requirements | NO CUSTOM                                               |
| Class        | Symfony\Component\Routing\Route                         |
| Defaults     | _controller: App\Controller\IndexController::index()    |
| Options      | compiler_class: Symfony\Component\Routing\RouteCompiler |
|              | utf8: true                                              |
+--------------+---------------------------------------------------------+
```
## I check the path index again
```
$ php bin/console router:match /index                                                                                                                    
                                                                                                                                                                                                                                       
                                                                                                                                                                                                                                       
                                                                                                                                                                                                                                       
 [OK] Route "index" matches                                                                                                                                                                                                            
                                                                                                                                                                                                                                       
                                                                                                                                                                                                                                       
+--------------+---------------------------------------------------------+                                                                                                                                                             
| Property     | Value                                                   |                                                                                                                                                             
+--------------+---------------------------------------------------------+                                                                                                                                                             
| Route Name   | index                                                   |                                                                                                                                                             
| Path         | /index                                                  |                                                                                                                                                             
| Path Regex   | {^/index$}sDu                                           |                                                                                                                                                             
| Host         | ANY                                                     |                                                                                                                                                             
| Host Regex   |                                                         |
| Scheme       | ANY                                                     |
| Method       | GET|HEAD                                                |
| Requirements | NO CUSTOM                                               |
| Class        | Symfony\Component\Routing\Route                         |
| Defaults     | _controller: App\Controller\IndexController::index()    |
| Options      | compiler_class: Symfony\Component\Routing\RouteCompiler |
|              | utf8: true                                              |
+--------------+---------------------------------------------------------+
```
