# ateneo

```
$ composer create-project laravel/laravel ateneo
$ cd ateneo
$ composer update
```

```
$ php artisan --version
Laravel Framework 7.30.4
```

```
$ php artisan make:model Models/Student -m
$ php artisan migrate
```

```
$ composer require laravel/ui
$ npm run dev
```

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

```
$ php artisan serve
```

