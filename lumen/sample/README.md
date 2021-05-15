# sample

## assumption:
On this occasion I consider the possibility of already having an existing database to map.
That is: "laravel_sample_db", having a single table named "user".

## it begins
```
$ composer create-project laravel/lumen sample
```
## I proceed with the following commands
```
$ php artisan make:migration create_item_table                                                                                                                     
Created Migration: 2021_05_15_042759_create_item_table
$ php artisan make:migration create_supplier_table                                                                                                             
Created Migration: 2021_05_15_043353_create_supplier_table
$ php artisan make:migration create_customer_table                                                                                                         
Created Migration: 2021_05_15_043452_create_customer_table
```
