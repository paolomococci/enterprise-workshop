# ateneo demo web application

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
## I check the path of the resources
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
## I resize the application by adding five more entities
```
$ php artisan make:model -a Models/Tutor
$ php artisan make:model -a Models/Teacher
$ php artisan make:model -a Models/Employee
$ php artisan make:model -a Models/Chancellor
$ php artisan make:model -a Models/President
```
## again, I check the path of the resources
```
$ php artisan route:list
+--------+-----------+-------------------------------+---------------------+---------------------------------------------------+------------+
| Domain | Method    | URI                           | Name                | Action                                            | Middleware |
+--------+-----------+-------------------------------+---------------------+---------------------------------------------------+------------+
|        | GET|HEAD  | /                             |                     | Closure                                           | web        |
|        | GET|HEAD  | api/user                      |                     | Closure                                           | api        |
|        |           |                               |                     |                                                   | auth:api   |
|        | GET|HEAD  | chancellors                   | chancellors.index   | App\Http\Controllers\ChancellorController@index   | web        |
|        | POST      | chancellors                   | chancellors.store   | App\Http\Controllers\ChancellorController@store   | web        |
|        | GET|HEAD  | chancellors/create            | chancellors.create  | App\Http\Controllers\ChancellorController@create  | web        |
|        | PUT|PATCH | chancellors/{chancellor}      | chancellors.update  | App\Http\Controllers\ChancellorController@update  | web        |
|        | GET|HEAD  | chancellors/{chancellor}      | chancellors.show    | App\Http\Controllers\ChancellorController@show    | web        |
|        | DELETE    | chancellors/{chancellor}      | chancellors.destroy | App\Http\Controllers\ChancellorController@destroy | web        |
|        | GET|HEAD  | chancellors/{chancellor}/edit | chancellors.edit    | App\Http\Controllers\ChancellorController@edit    | web        |
|        | POST      | employees                     | employees.store     | App\Http\Controllers\EmployeeController@store     | web        |
|        | GET|HEAD  | employees                     | employees.index     | App\Http\Controllers\EmployeeController@index     | web        |
|        | GET|HEAD  | employees/create              | employees.create    | App\Http\Controllers\EmployeeController@create    | web        |
|        | DELETE    | employees/{employee}          | employees.destroy   | App\Http\Controllers\EmployeeController@destroy   | web        |
|        | PUT|PATCH | employees/{employee}          | employees.update    | App\Http\Controllers\EmployeeController@update    | web        |
|        | GET|HEAD  | employees/{employee}          | employees.show      | App\Http\Controllers\EmployeeController@show      | web        |
|        | GET|HEAD  | employees/{employee}/edit     | employees.edit      | App\Http\Controllers\EmployeeController@edit      | web        |
|        | GET|HEAD  | presidents                    | presidents.index    | App\Http\Controllers\PresidentController@index    | web        |
|        | POST      | presidents                    | presidents.store    | App\Http\Controllers\PresidentController@store    | web        |
|        | GET|HEAD  | presidents/create             | presidents.create   | App\Http\Controllers\PresidentController@create   | web        |
|        | GET|HEAD  | presidents/{president}        | presidents.show     | App\Http\Controllers\PresidentController@show     | web        |
|        | PUT|PATCH | presidents/{president}        | presidents.update   | App\Http\Controllers\PresidentController@update   | web        |
|        | DELETE    | presidents/{president}        | presidents.destroy  | App\Http\Controllers\PresidentController@destroy  | web        |
|        | GET|HEAD  | presidents/{president}/edit   | presidents.edit     | App\Http\Controllers\PresidentController@edit     | web        |
|        | GET|HEAD  | students                      | students.index      | App\Http\Controllers\StudentController@index      | web        |
|        | POST      | students                      | students.store      | App\Http\Controllers\StudentController@store      | web        |
|        | GET|HEAD  | students/create               | students.create     | App\Http\Controllers\StudentController@create     | web        |
|        | DELETE    | students/{student}            | students.destroy    | App\Http\Controllers\StudentController@destroy    | web        |
|        | GET|HEAD  | students/{student}            | students.show       | App\Http\Controllers\StudentController@show       | web        |
|        | PUT|PATCH | students/{student}            | students.update     | App\Http\Controllers\StudentController@update     | web        |
|        | GET|HEAD  | students/{student}/edit       | students.edit       | App\Http\Controllers\StudentController@edit       | web        |
|        | POST      | teachers                      | teachers.store      | App\Http\Controllers\TeacherController@store      | web        |
|        | GET|HEAD  | teachers                      | teachers.index      | App\Http\Controllers\TeacherController@index      | web        |
|        | GET|HEAD  | teachers/create               | teachers.create     | App\Http\Controllers\TeacherController@create     | web        |
|        | PUT|PATCH | teachers/{teacher}            | teachers.update     | App\Http\Controllers\TeacherController@update     | web        |
|        | DELETE    | teachers/{teacher}            | teachers.destroy    | App\Http\Controllers\TeacherController@destroy    | web        |
|        | GET|HEAD  | teachers/{teacher}            | teachers.show       | App\Http\Controllers\TeacherController@show       | web        |
|        | GET|HEAD  | teachers/{teacher}/edit       | teachers.edit       | App\Http\Controllers\TeacherController@edit       | web        |
|        | GET|HEAD  | tutors                        | tutors.index        | App\Http\Controllers\TutorController@index        | web        |
|        | POST      | tutors                        | tutors.store        | App\Http\Controllers\TutorController@store        | web        |
|        | GET|HEAD  | tutors/create                 | tutors.create       | App\Http\Controllers\TutorController@create       | web        |
|        | GET|HEAD  | tutors/{tutor}                | tutors.show         | App\Http\Controllers\TutorController@show         | web        |
|        | PUT|PATCH | tutors/{tutor}                | tutors.update       | App\Http\Controllers\TutorController@update       | web        |
|        | DELETE    | tutors/{tutor}                | tutors.destroy      | App\Http\Controllers\TutorController@destroy      | web        |
|        | GET|HEAD  | tutors/{tutor}/edit           | tutors.edit         | App\Http\Controllers\TutorController@edit         | web        |
+--------+-----------+-------------------------------+---------------------+---------------------------------------------------+------------+
```
## migrating
```
$ php artisan migrate
Migrating: 2021_04_05_014745_create_tutors_table
Migrated:  2021_04_05_014745_create_tutors_table (0.02 seconds)
Migrating: 2021_04_05_014837_create_teachers_table
Migrated:  2021_04_05_014837_create_teachers_table (0.02 seconds)
Migrating: 2021_04_05_014853_create_employees_table
Migrated:  2021_04_05_014853_create_employees_table (0.02 seconds)
Migrating: 2021_04_05_014948_create_chancellors_table
Migrated:  2021_04_05_014948_create_chancellors_table (0.02 seconds)
Migrating: 2021_04_05_015019_create_presidents_table
Migrated:  2021_04_05_015019_create_presidents_table (0.02 seconds)
```
## if corrections need to be made
```
$ php artisan migrate:refresh
...
```
## I maked the Faculty entity
```
$ php artisan make:model -a Models/Faculty
$ php artisan migrate:refresh
$ php artisan route:list
+--------+-----------+-------------------------------+---------------------+-------------------------------------------------------+------------+
| Domain | Method    | URI                           | Name                | Action                                                | Middleware |
+--------+-----------+-------------------------------+---------------------+-------------------------------------------------------+------------+
|        | GET|HEAD  | /                             |                     | Closure                                               | web        |
|        | GET|HEAD  | api/chancellors               |                     | App\Http\Controllers\ChancellorController@restShowAll | api        |
|        | GET|HEAD  | api/employees                 |                     | App\Http\Controllers\EmployeeController@restShowAll   | api        |
|        | GET|HEAD  | api/faculties                 |                     | App\Http\Controllers\FacultyController@restShowAll    | api        |
|        | GET|HEAD  | api/presidents                |                     | App\Http\Controllers\PresidentController@restShowAll  | api        |
|        | GET|HEAD  | api/students                  |                     | App\Http\Controllers\StudentController@restShowAll    | api        |
|        | GET|HEAD  | api/teachers                  |                     | App\Http\Controllers\TeacherController@restShowAll    | api        |
|        | GET|HEAD  | api/tutors                    |                     | App\Http\Controllers\TutorController@restShowAll      | api        |
|        | GET|HEAD  | api/user                      |                     | Closure                                               | api        |
|        |           |                               |                     |                                                       | auth:api   |
|        | GET|HEAD  | chancellors                   | chancellors.index   | App\Http\Controllers\ChancellorController@index       | web        |
|        | POST      | chancellors                   | chancellors.store   | App\Http\Controllers\ChancellorController@store       | web        |
|        | GET|HEAD  | chancellors/create            | chancellors.create  | App\Http\Controllers\ChancellorController@create      | web        |
|        | PUT|PATCH | chancellors/{chancellor}      | chancellors.update  | App\Http\Controllers\ChancellorController@update      | web        |
|        | GET|HEAD  | chancellors/{chancellor}      | chancellors.show    | App\Http\Controllers\ChancellorController@show        | web        |
|        | DELETE    | chancellors/{chancellor}      | chancellors.destroy | App\Http\Controllers\ChancellorController@destroy     | web        |
|        | GET|HEAD  | chancellors/{chancellor}/edit | chancellors.edit    | App\Http\Controllers\ChancellorController@edit        | web        |
|        | GET|HEAD  | employees                     | employees.index     | App\Http\Controllers\EmployeeController@index         | web        |
|        | POST      | employees                     | employees.store     | App\Http\Controllers\EmployeeController@store         | web        |
|        | GET|HEAD  | employees/create              | employees.create    | App\Http\Controllers\EmployeeController@create        | web        |
|        | DELETE    | employees/{employee}          | employees.destroy   | App\Http\Controllers\EmployeeController@destroy       | web        |
|        | PUT|PATCH | employees/{employee}          | employees.update    | App\Http\Controllers\EmployeeController@update        | web        |
|        | GET|HEAD  | employees/{employee}          | employees.show      | App\Http\Controllers\EmployeeController@show          | web        |
|        | GET|HEAD  | employees/{employee}/edit     | employees.edit      | App\Http\Controllers\EmployeeController@edit          | web        |
|        | GET|HEAD  | presidents                    | presidents.index    | App\Http\Controllers\PresidentController@index        | web        |
|        | POST      | presidents                    | presidents.store    | App\Http\Controllers\PresidentController@store        | web        |
|        | GET|HEAD  | presidents/create             | presidents.create   | App\Http\Controllers\PresidentController@create       | web        |
|        | GET|HEAD  | presidents/{president}        | presidents.show     | App\Http\Controllers\PresidentController@show         | web        |
|        | PUT|PATCH | presidents/{president}        | presidents.update   | App\Http\Controllers\PresidentController@update       | web        |
|        | DELETE    | presidents/{president}        | presidents.destroy  | App\Http\Controllers\PresidentController@destroy      | web        |
|        | GET|HEAD  | presidents/{president}/edit   | presidents.edit     | App\Http\Controllers\PresidentController@edit         | web        |
|        | GET|HEAD  | students                      | students.index      | App\Http\Controllers\StudentController@index          | web        |
|        | POST      | students                      | students.store      | App\Http\Controllers\StudentController@store          | web        |
|        | GET|HEAD  | students/create               | students.create     | App\Http\Controllers\StudentController@create         | web        |
|        | DELETE    | students/{student}            | students.destroy    | App\Http\Controllers\StudentController@destroy        | web        |
|        | GET|HEAD  | students/{student}            | students.show       | App\Http\Controllers\StudentController@show           | web        |
|        | PUT|PATCH | students/{student}            | students.update     | App\Http\Controllers\StudentController@update         | web        |
|        | GET|HEAD  | students/{student}/edit       | students.edit       | App\Http\Controllers\StudentController@edit           | web        |
|        | POST      | teachers                      | teachers.store      | App\Http\Controllers\TeacherController@store          | web        |
|        | GET|HEAD  | teachers                      | teachers.index      | App\Http\Controllers\TeacherController@index          | web        |
|        | GET|HEAD  | teachers/create               | teachers.create     | App\Http\Controllers\TeacherController@create         | web        |
|        | DELETE    | teachers/{teacher}            | teachers.destroy    | App\Http\Controllers\TeacherController@destroy        | web        |
|        | PUT|PATCH | teachers/{teacher}            | teachers.update     | App\Http\Controllers\TeacherController@update         | web        |
|        | GET|HEAD  | teachers/{teacher}            | teachers.show       | App\Http\Controllers\TeacherController@show           | web        |
|        | GET|HEAD  | teachers/{teacher}/edit       | teachers.edit       | App\Http\Controllers\TeacherController@edit           | web        |
|        | GET|HEAD  | tutors                        | tutors.index        | App\Http\Controllers\TutorController@index            | web        |
|        | POST      | tutors                        | tutors.store        | App\Http\Controllers\TutorController@store            | web        |
|        | GET|HEAD  | tutors/create                 | tutors.create       | App\Http\Controllers\TutorController@create           | web        |
|        | GET|HEAD  | tutors/{tutor}                | tutors.show         | App\Http\Controllers\TutorController@show             | web        |
|        | PUT|PATCH | tutors/{tutor}                | tutors.update       | App\Http\Controllers\TutorController@update           | web        |
|        | DELETE    | tutors/{tutor}                | tutors.destroy      | App\Http\Controllers\TutorController@destroy          | web        |
|        | GET|HEAD  | tutors/{tutor}/edit           | tutors.edit         | App\Http\Controllers\TutorController@edit             | web        |
+--------+-----------+-------------------------------+---------------------+-------------------------------------------------------+------------+
```
## I added the following relationships between entities
```
$ php artisan make:migration create_students_faculties_relation_table
Created Migration: 2021_04_14_091407_create_students_faculties_relation_table
$ php artisan make:migration create_tutors_faculties_relation_table
Created Migration: 2021_04_14_091436_create_tutors_faculties_relation_table
$ php artisan make:migration create_teachers_faculties_relation_table
Created Migration: 2021_04_14_091507_create_teachers_faculties_relation_table
$ php artisan migrate
Migrating: 2021_04_14_091407_create_students_faculties_relation_table
Migrated:  2021_04_14_091407_create_students_faculties_relation_table (0.02 seconds)
Migrating: 2021_04_14_091436_create_tutors_faculties_relation_table
Migrated:  2021_04_14_091436_create_tutors_faculties_relation_table (0.01 seconds)
Migrating: 2021_04_14_091507_create_teachers_faculties_relation_table
Migrated:  2021_04_14_091507_create_teachers_faculties_relation_table (0.01 seconds)
```
