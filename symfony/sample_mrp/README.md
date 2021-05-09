# Material Requirements Planning demo web application

## I make a new Symfony project with website-skeleton
```
$ composer create-project symfony/website-skeleton sample_mrp
$ cd sample_mrp
$ composer update
$ composer require friendsofphp/php-cs-fixer
$ composer require symfony/web-server-bundle 4.4
$ composer require easycorp/easyadmin-bundle
$ php bin/console make:admin:dashboard
$ nano .env
```
## I changed the following line
```
DATABASE_URL="mysql://username:password@127.0.0.1:3306/sample_mrp_db"
```
## and I continued with the following commands
```
$ php bin/console make:entity Commodity
$ php bin/console make:entity Component
$ php bin/console make:entity Supplier
$ php bin/console make:entity Customer
$ php bin/console make:migration
$ php bin/console doctrine:migrations:migrate
$ php bin/console make:crud Commodity
$ php bin/console make:crud Component
$ php bin/console make:admin:crud
$ php bin/console make:controller
```
## finally
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
  admin                      ANY        ANY      ANY    /admin                             
  commodity_index            GET        ANY      ANY    /commodity/                        
  commodity_new              GET|POST   ANY      ANY    /commodity/new                     
  commodity_show             GET        ANY      ANY    /commodity/{id}                    
  commodity_edit             GET|POST   ANY      ANY    /commodity/{id}/edit               
  commodity_delete           POST       ANY      ANY    /commodity/{id}                    
  component_index            GET        ANY      ANY    /component/                        
  component_new              GET|POST   ANY      ANY    /component/new                     
  component_show             GET        ANY      ANY    /component/{id}                    
  component_edit             GET|POST   ANY      ANY    /component/{id}/edit               
  component_delete           POST       ANY      ANY    /component/{id}                    
  customer_index             GET        ANY      ANY    /customer/                         
  customer_new               GET|POST   ANY      ANY    /customer/new                      
  customer_show              GET        ANY      ANY    /customer/{id}                     
  customer_edit              GET|POST   ANY      ANY    /customer/{id}/edit                
  customer_delete            POST       ANY      ANY    /customer/{id}                     
  home                       GET|HEAD   ANY      ANY    /                                  
  supplier_index             GET        ANY      ANY    /supplier/                         
  supplier_new               GET|POST   ANY      ANY    /supplier/new                      
  supplier_show              GET        ANY      ANY    /supplier/{id}                     
  supplier_edit              GET|POST   ANY      ANY    /supplier/{id}/edit                
  supplier_delete            POST       ANY      ANY    /supplier/{id}                     
 -------------------------- ---------- -------- ------ -----------------------------------
 $ php bin/console server:run
 ...
```
## I add webpack support
```
$ composer require symfony/webpack-encore-bundle
```
