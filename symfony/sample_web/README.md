# demo web application developed thanks to Symfony

## I make a new Symfony project with website-skeleton
```
$ composer2 create-project symfony/website-skeleton sample_web
...
```
## and I edit .env
```
...
DATABASE_URL="mysql://username:password@127.0.0.1:3306/sample_web_db"
...
```

## add a controller
```
$ php bin/console make:controller

 Choose a name for your controller class (e.g. TinyChefController):
 > SampleController

 created: src/Controller/SampleController.php
 created: templates/sample/index.html.twig

           
  Success! 
           

 Next: Open your new controller class and add some pages!
```
