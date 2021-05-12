# e_tryst
![e_tryst](https://github.com/paolomococci/enterprise-workshop/blob/main/screenshots/screenshot_e-tryst_guest.png)

## I make a new Symfony project with website-skeleton
```
$ composer create-project symfony/website-skeleton e_tryst
$ cd e_tryst
$ composer update
$ composer require friendsofphp/php-cs-fixer
$ composer require symfony/web-server-bundle 4.4
$ composer require easycorp/easyadmin-bundle
$ php bin/console make:admin:dashboard
$ php bin/console make:entity

 Class name of the entity to create or update (e.g. VictoriousChef):
 > Guest
...
$ nano .env
```
## I changed the following line
```
DATABASE_URL="mysql://username:password@127.0.0.1:3306/e_tryst_db"
```
## and I continued with the following commands
```
$ php bin/console make:migration
$ php bin/console doctrine:migrations:migrate
$ php bin/console make:crud Guest
$ php bin/console make:admin:crud

 Which Doctrine entity are you going to manage with this CRUD controller?:
  [0] App\Entity\Guest
 > 0
...
$ php bin/console make:controller

 Choose a name for your controller class (e.g. AgreeableChefController):
 > IndexController
...
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
  admin                      ANY        ANY      ANY    /admin                                                                                                                                                                         
  guest_crud_index           GET        ANY      ANY    /guest/crud/                                                                                                                                                                   
  guest_crud_new             GET|POST   ANY      ANY    /guest/crud/new                                                                                                                                                                
  guest_crud_show            GET        ANY      ANY    /guest/crud/{id}                                                                                                                                                               
  guest_crud_edit            GET|POST   ANY      ANY    /guest/crud/{id}/edit                                                                                                                                                          
  guest_crud_delete          POST       ANY      ANY    /guest/crud/{id}                                                                                                                                                               
  index                      GET|HEAD   ANY      ANY    /                                                                                                                                                                              
 -------------------------- ---------- -------- ------ ----------------------------------- 

$ php bin/console server:run

                                                                                                                        
 [OK] Server listening on http://127.0.0.1:8000                                                                         
                                                                                                                        

 // Quit the server with CONTROL-C.                                                                                     
...
```
## I add webpack support
```
$ composer require symfony/webpack-encore-bundle
$ yarn install
$ yarn add bootstrap --dev
$ yarn add jquery popper.js --dev
$ yarn encore dev
```
## I update Guest and add two new entities
```
$ php bin/console make:entity Guest
$ php bin/console make:entity Post
$ php bin/console make:entity Tryst
```
## and then continue with the following commands
```
$ php bin/console make:crud Post
$ php bin/console make:crud Tryst
$ php bin/console make:admin:crud
$ php bin/console make:admin:crud
```
once for Post and once for Tryst
