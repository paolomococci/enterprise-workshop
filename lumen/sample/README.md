# sample

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
$ php artisan migrate                                                                                                                                              
Migration table created successfully.
Migrating: 2021_05_15_042759_create_item_table
Migrated:  2021_05_15_042759_create_item_table (0.02 seconds)
Migrating: 2021_05_15_043353_create_supplier_table
Migrated:  2021_05_15_043353_create_supplier_table (0.01 seconds)
Migrating: 2021_05_15_043452_create_customer_table
Migrated:  2021_05_15_043452_create_customer_table (0.01 seconds)
```
## after I edited the flies in database/migrations
```
$ php artisan migrate:refresh
$ php -S localhost:8000 -t public
```
## now I add the tables to relate the entities
```
$ php artisan make:migration create_customers_items_relation_table
$ php artisan make:migration create_suppliers_items_relation_table
$ php artisan migrate:refresh
...
```
