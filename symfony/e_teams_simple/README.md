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
