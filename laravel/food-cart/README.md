# food-cart demo web application developed thanks to Laravel

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
