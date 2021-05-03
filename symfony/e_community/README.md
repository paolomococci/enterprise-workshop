# e_community

## I make a new Symfony project with website-skeleton
```
$ composer create-project symfony/website-skeleton e_community
...
$ cd e_community
$ composer update$ nano .env
...
```
## I changed the following line 
```
...
DATABASE_URL="mysql://username:password@127.0.0.1:3306/e_community_db"
...
```
## and I continued with the following commands
```
$ composer require symfony/web-server-bundle 4.4
...
$ composer require friendsofphp/php-cs-fixer
...
$ composer require easycorp/easyadmin-bundle
...
$ php bin/console make:admin:dashboard
...
$ php bin/console make:entity

 Class name of the entity to create or update (e.g. OrangeElephant):
 > User

 created: src/Entity/User.php
 created: src/Repository/UserRepository.php
 
 Entity generated! Now let's add some fields!
 You can always add more fields later manually or by re-running this command.

 New property name (press <return> to stop adding fields):
 > name

 Field type (enter ? to see all types) [string]:
 > 

 Field length [255]:
 > 

 Can this field be null in the database (nullable) (yes/no) [no]:
 > 

 updated: src/Entity/User.php

 Add another property? Enter the property name (or press <return> to stop adding fields):
 > surname

 Field type (enter ? to see all types) [string]:
 > 

 Field length [255]:
 > 

 Can this field be null in the database (nullable) (yes/no) [no]:
 > 

 updated: src/Entity/User.php

 Add another property? Enter the property name (or press <return> to stop adding fields):
 > email

 Field type (enter ? to see all types) [string]:
 > 

 Field length [255]:
 > 

 Can this field be null in the database (nullable) (yes/no) [no]:
 > 

 updated: src/Entity/User.php

 Add another property? Enter the property name (or press <return> to stop adding fields):
 > password

 Field type (enter ? to see all types) [string]:
 > 

 Field length [255]:
 > 

 Can this field be null in the database (nullable) (yes/no) [no]:
 > 

 updated: src/Entity/User.php

 Add another property? Enter the property name (or press <return> to stop adding fields):
 > roles

 Field type (enter ? to see all types) [string]:
 > 

 Field length [255]:
 > 

 Can this field be null in the database (nullable) (yes/no) [no]:
 > 

 updated: src/Entity/User.php

 Add another property? Enter the property name (or press <return> to stop adding fields):
 > profession

 Field type (enter ? to see all types) [string]:
 > 

 Field length [255]:
 > 

 Can this field be null in the database (nullable) (yes/no) [no]:
 > yes

 updated: src/Entity/User.php

 Add another property? Enter the property name (or press <return> to stop adding fields):
 > birthday

 Field type (enter ? to see all types) [string]:
 > date

 Can this field be null in the database (nullable) (yes/no) [no]:
 > 

 updated: src/Entity/User.php

 Add another property? Enter the property name (or press <return> to stop adding fields):
 > registration

 Field type (enter ? to see all types) [string]:
 > date

 Can this field be null in the database (nullable) (yes/no) [no]:
 > 

 updated: src/Entity/User.php

 Add another property? Enter the property name (or press <return> to stop adding fields):
 > 


           
  Success!
...
$ php bin/console make:migration
...
$ php bin/console doctrine:migrations:migrate
...
$ php bin/console make:crud User

 Choose a name for your controller class (e.g. UserController) [UserController]:
 > UserCrudController

 created: src/Controller/UserCrudController.php
 created: src/Form/UserType.php
 created: templates/user_crud/_delete_form.html.twig
 created: templates/user_crud/_form.html.twig
 created: templates/user_crud/edit.html.twig
 created: templates/user_crud/index.html.twig
 created: templates/user_crud/new.html.twig
 created: templates/user_crud/show.html.twig
...
$ php bin/console make:admin:crud

 Which Doctrine entity are you going to manage with this CRUD controller?:
  [0] App\Entity\User
 > 0

 Which directory do you want to generate the CRUD controller in? [src/Controller/Admin/]:
 > 

 Namespace of the generated CRUD controller [App\Controller\Admin]:
 > 

                                                                                                                        
 [OK] Your CRUD controller class has been successfully generated.
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
  user_crud_index            GET        ANY      ANY    /user/crud/                        
  user_crud_new              GET|POST   ANY      ANY    /user/crud/new                     
  user_crud_show             GET        ANY      ANY    /user/crud/{id}                    
  user_crud_edit             GET|POST   ANY      ANY    /user/crud/{id}/edit               
  user_crud_delete           POST       ANY      ANY    /user/crud/{id}                    
 -------------------------- ---------- -------- ------ -----------------------------------
```
## finally I start the test server
```
$ php bin/console server:run

                                                                                                                        
 [OK] Server listening on http://127.0.0.1:8000                                                                         
                                                                                                                        

 // Quit the server with CONTROL-C.
...
```
