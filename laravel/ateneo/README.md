# ateneo

## I started with creating the project
```
$ composer create-project laravel/laravel ateneo
$ cd ateneo
$ composer update
```
## I checked the version of the framework
```
$ php artisan --version
Laravel Framework 7.30.4
```
## I created the model of interest
```
$ php artisan make:model Models/Student -m
$ php artisan migrate
```
## I created the controller
```
$ php artisan make:controller StudentController --resource
```
## I added user iinterface support
```
$ composer require laravel/ui
$ php artisan ui bootstrap
$ npm install
```
## possibly, if necessary
```
$ npm audit fix --force
```
# finally
```
$ npm run dev
```
## I check the paths list
```
$ php artisan route:list
+--------+-----------+-------------------------+------------------+------------------------------------------------+------------+
| Domain | Method    | URI                     | Name             | Action                                         | Middleware |
+--------+-----------+-------------------------+------------------+------------------------------------------------+------------+
|        | GET|HEAD  | /                       |                  | Closure                                        | web        |
|        | GET|HEAD  | api/user                |                  | Closure                                        | api        |
|        |           |                         |                  |                                                | auth:api   |
|        | GET|HEAD  | students                | students.index   | App\Http\Controllers\StudentController@index   | web        |
|        | POST      | students                | students.store   | App\Http\Controllers\StudentController@store   | web        |
|        | GET|HEAD  | students/create         | students.create  | App\Http\Controllers\StudentController@create  | web        |
|        | GET|HEAD  | students/{student}      | students.show    | App\Http\Controllers\StudentController@show    | web        |
|        | PUT|PATCH | students/{student}      | students.update  | App\Http\Controllers\StudentController@update  | web        |
|        | DELETE    | students/{student}      | students.destroy | App\Http\Controllers\StudentController@destroy | web        |
|        | GET|HEAD  | students/{student}/edit | students.edit    | App\Http\Controllers\StudentController@edit    | web        |
+--------+-----------+-------------------------+------------------+------------------------------------------------+------------+
```
## I start the server for the usage test
```
$ php artisan serve
```

