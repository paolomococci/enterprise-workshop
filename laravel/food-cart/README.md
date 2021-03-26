# food-cart demo web application developed thanks to Laravel
![food-card](https://github.com/paolomococci/enterprise-workshop/blob/main/screenshots/food_cart_screenshot01.png)

## how I proceeded:

### I first created the project
```
$ composer create-project laravel/laravel food-cart
$ cd food-cart
$ composer update
$ php artisan make:model -a Models/Customer
$ php artisan make:model -a Models/Ingredient
$ php artisan make:model -a Models/Meal
$ php artisan make:model -a Models/Recipe
$ php artisan make:model -a Models/Supplier
```
### I generated the tables necessary for the application to work
```
$ php artisan migrate
```
### finally, I started the application
```
$ php artisan serve
```
### to then test its API from another terminal window
```
$ curl -v -i http://localhost:8000/api/customers
*   Trying 127.0.0.1...
* TCP_NODELAY set
* Connected to localhost (127.0.0.1) port 8000 (#0)
> GET /api/customers HTTP/1.1
> Host: localhost:8000
> User-Agent: curl/7.58.0
> Accept: */*
> 
< HTTP/1.1 200 OK
HTTP/1.1 200 OK
< Host: localhost:8000
Host: localhost:8000
< Date: Sun, 21 Mar 2021 09:26:03 GMT
Date: Sun, 21 Mar 2021 09:26:03 GMT
< Connection: close
Connection: close
< X-Powered-By: PHP/7.2.24-0ubuntu0.18.04.7
X-Powered-By: PHP/7.2.24-0ubuntu0.18.04.7
< Cache-Control: no-cache, private
Cache-Control: no-cache, private
< Date: Sun, 21 Mar 2021 09:26:03 GMT
Date: Sun, 21 Mar 2021 09:26:03 GMT
< Content-Type: application/json
Content-Type: application/json
< X-RateLimit-Limit: 60
X-RateLimit-Limit: 60
< X-RateLimit-Remaining: 59
X-RateLimit-Remaining: 59
< Access-Control-Allow-Origin: *
Access-Control-Allow-Origin: *

< 
* Closing connection 0
[]
$ curl -v -i http://localhost:8000/api/ingredients
*   Trying 127.0.0.1...
* TCP_NODELAY set
* Connected to localhost (127.0.0.1) port 8000 (#0)
> GET /api/ingredients HTTP/1.1
> Host: localhost:8000
> User-Agent: curl/7.58.0
> Accept: */*
> 
< HTTP/1.1 200 OK
HTTP/1.1 200 OK
< Host: localhost:8000
Host: localhost:8000
< Date: Sun, 21 Mar 2021 09:27:43 GMT
Date: Sun, 21 Mar 2021 09:27:43 GMT
< Connection: close
Connection: close
< X-Powered-By: PHP/7.2.24-0ubuntu0.18.04.7
X-Powered-By: PHP/7.2.24-0ubuntu0.18.04.7
< Cache-Control: no-cache, private
Cache-Control: no-cache, private
< Date: Sun, 21 Mar 2021 09:27:43 GMT
Date: Sun, 21 Mar 2021 09:27:43 GMT
< Content-Type: application/json
Content-Type: application/json
< X-RateLimit-Limit: 60
X-RateLimit-Limit: 60
< X-RateLimit-Remaining: 59
X-RateLimit-Remaining: 59
< Access-Control-Allow-Origin: *
Access-Control-Allow-Origin: *

< 
* Closing connection 0
[]
$ curl -v -i http://localhost:8000/api/meals
*   Trying 127.0.0.1...
* TCP_NODELAY set
* Connected to localhost (127.0.0.1) port 8000 (#0)
> GET /api/meals HTTP/1.1
> Host: localhost:8000
> User-Agent: curl/7.58.0
> Accept: */*
> 
< HTTP/1.1 200 OK
HTTP/1.1 200 OK
< Host: localhost:8000
Host: localhost:8000
< Date: Sun, 21 Mar 2021 09:28:42 GMT
Date: Sun, 21 Mar 2021 09:28:42 GMT
< Connection: close
Connection: close
< X-Powered-By: PHP/7.2.24-0ubuntu0.18.04.7
X-Powered-By: PHP/7.2.24-0ubuntu0.18.04.7
< Cache-Control: no-cache, private
Cache-Control: no-cache, private
< Date: Sun, 21 Mar 2021 09:28:42 GMT
Date: Sun, 21 Mar 2021 09:28:42 GMT
< Content-Type: application/json
Content-Type: application/json
< X-RateLimit-Limit: 60
X-RateLimit-Limit: 60
< X-RateLimit-Remaining: 58
X-RateLimit-Remaining: 58
< Access-Control-Allow-Origin: *
Access-Control-Allow-Origin: *

< 
* Closing connection 0
[]
$ curl -v -i http://localhost:8000/api/recipes
*   Trying 127.0.0.1...
* TCP_NODELAY set
* Connected to localhost (127.0.0.1) port 8000 (#0)
> GET /api/recipes HTTP/1.1
> Host: localhost:8000
> User-Agent: curl/7.58.0
> Accept: */*
> 
< HTTP/1.1 200 OK
HTTP/1.1 200 OK
< Host: localhost:8000
Host: localhost:8000
< Date: Sun, 21 Mar 2021 09:30:30 GMT
Date: Sun, 21 Mar 2021 09:30:30 GMT
< Connection: close
Connection: close
< X-Powered-By: PHP/7.2.24-0ubuntu0.18.04.7
X-Powered-By: PHP/7.2.24-0ubuntu0.18.04.7
< Cache-Control: no-cache, private
Cache-Control: no-cache, private
< Date: Sun, 21 Mar 2021 09:30:30 GMT
Date: Sun, 21 Mar 2021 09:30:30 GMT
< Content-Type: application/json
Content-Type: application/json
< X-RateLimit-Limit: 60
X-RateLimit-Limit: 60
< X-RateLimit-Remaining: 59
X-RateLimit-Remaining: 59
< Access-Control-Allow-Origin: *
Access-Control-Allow-Origin: *

< 
* Closing connection 0
[]
$ curl -v -i http://localhost:8000/api/suppliers
*   Trying 127.0.0.1...
* TCP_NODELAY set
* Connected to localhost (127.0.0.1) port 8000 (#0)
> GET /api/suppliers HTTP/1.1
> Host: localhost:8000
> User-Agent: curl/7.58.0
> Accept: */*
> 
< HTTP/1.1 200 OK
HTTP/1.1 200 OK
< Host: localhost:8000
Host: localhost:8000
< Date: Sun, 21 Mar 2021 09:34:09 GMT
Date: Sun, 21 Mar 2021 09:34:09 GMT
< Connection: close
Connection: close
< X-Powered-By: PHP/7.2.24-0ubuntu0.18.04.7
X-Powered-By: PHP/7.2.24-0ubuntu0.18.04.7
< Cache-Control: no-cache, private
Cache-Control: no-cache, private
< Date: Sun, 21 Mar 2021 09:34:09 GMT
Date: Sun, 21 Mar 2021 09:34:09 GMT
< Content-Type: application/json
Content-Type: application/json
< X-RateLimit-Limit: 60
X-RateLimit-Limit: 60
< X-RateLimit-Remaining: 59
X-RateLimit-Remaining: 59
< Access-Control-Allow-Origin: *
Access-Control-Allow-Origin: *

< 
* Closing connection 0
[]
```
### I modified composer.json
```
...
    "autoload": {
        "psr-4": {
            "App\\": "app/",
            "Database\\Seeders\\": "database/seeders",
            "Database\\Factories\\": "database/factories",
            "DatabaseSeeder\\": "database/seeders/"
        }
    },
...
```
### after editing the files in the directory database/seeds, I ran the command
```
$ php artisan db:seed --class=CustomerSeeder
```
### it returns me an error
```
...
Target class [CustomerSeeder] does not exist.
...
```
### I proceeded to create the many-to-many relationship tables
```
$ php artisan make:migration create_ingredient_recipe_relation_table
Created Migration: 2021_03_24_140125_create_ingredient_recipe_relation_table

$ php artisan make:migration create_recipe_meal_relation_table
Created Migration: 2021_03_24_140424_create_recipe_meal_relation_table

$ php artisan make:migration create_meal_customer_relation_table
Created Migration: 2021_03_24_140535_create_meal_customer_relation_table

$ php artisan make:migration create_ingredient_supplier_relation_table
Created Migration: 2021_03_24_140608_create_ingredient_supplier_relation_table

$ php artisan migrate:refresh --seed
Rolling back: 2021_03_21_082737_create_meals_table
Rolled back:  2021_03_21_082737_create_meals_table (0.01 seconds)
Rolling back: 2021_03_21_082128_create_recipes_table
Rolled back:  2021_03_21_082128_create_recipes_table (0 seconds)
Rolling back: 2021_03_21_070930_create_ingredients_table
Rolled back:  2021_03_21_070930_create_ingredients_table (0.01 seconds)
Rolling back: 2021_03_21_070514_create_suppliers_table
Rolled back:  2021_03_21_070514_create_suppliers_table (0 seconds)
Rolling back: 2021_03_21_065811_create_customers_table
Rolled back:  2021_03_21_065811_create_customers_table (0 seconds)
Rolling back: 2019_08_19_000000_create_failed_jobs_table
Rolled back:  2019_08_19_000000_create_failed_jobs_table (0.01 seconds)
Rolling back: 2014_10_12_100000_create_password_resets_table
Rolled back:  2014_10_12_100000_create_password_resets_table (0 seconds)
Rolling back: 2014_10_12_000000_create_users_table
Rolled back:  2014_10_12_000000_create_users_table (0 seconds)
Migrating: 2014_10_12_000000_create_users_table
Migrated:  2014_10_12_000000_create_users_table (0.02 seconds)
Migrating: 2014_10_12_100000_create_password_resets_table
Migrated:  2014_10_12_100000_create_password_resets_table (0.02 seconds)
Migrating: 2019_08_19_000000_create_failed_jobs_table
Migrated:  2019_08_19_000000_create_failed_jobs_table (0.01 seconds)
Migrating: 2021_03_21_065811_create_customers_table
Migrated:  2021_03_21_065811_create_customers_table (0.01 seconds)
Migrating: 2021_03_21_070514_create_suppliers_table
Migrated:  2021_03_21_070514_create_suppliers_table (0.01 seconds)
Migrating: 2021_03_21_070930_create_ingredients_table
Migrated:  2021_03_21_070930_create_ingredients_table (0.01 seconds)
Migrating: 2021_03_21_082128_create_recipes_table
Migrated:  2021_03_21_082128_create_recipes_table (0.02 seconds)
Migrating: 2021_03_21_082737_create_meals_table
Migrated:  2021_03_21_082737_create_meals_table (0.01 seconds)
Migrating: 2021_03_24_140125_create_ingredient_recipe_relation_table
Migrated:  2021_03_24_140125_create_ingredient_recipe_relation_table (0.01 seconds)
Migrating: 2021_03_24_140424_create_recipe_meal_relation_table
Migrated:  2021_03_24_140424_create_recipe_meal_relation_table (0.01 seconds)
Migrating: 2021_03_24_140535_create_meal_customer_relation_table
Migrated:  2021_03_24_140535_create_meal_customer_relation_table (0.01 seconds)
Migrating: 2021_03_24_140608_create_ingredient_supplier_relation_table
Migrated:  2021_03_24_140608_create_ingredient_supplier_relation_table (0.01 seconds)

   Illuminate\Contracts\Container\BindingResolutionException 

  Target class [DatabaseSeeder] does not exist.
...
```

### after I have edited the files dedicated to database modification
```
$ php artisan make:model Models/IngredientRecipe
$ php artisan migrate:refresh
...
```
