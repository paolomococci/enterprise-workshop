# E-store demo developed thanks Laravel framework
```
$ composer create-project laravel/laravel platano
$ composer update
$ php artisan make:model Models/Customer -m
$ php artisan make:model Models/Order -m
$ php artisan make:model Models/Invoice -m
$ php artisan make:model Models/Item -m
$ php artisan make:model Models/Category -m
$ php artisan make:model Models/Subcategory -m
$ php artisan make:model Models/Transaction -m
$ php artisan make:controller CustomerController --resource
$ php artisan make:controller OrderController --resource
$ php artisan make:controller InvoiceController --resource
$ php artisan make:controller ItemController --resource
$ php artisan make:controller CategoryController --resource
$ php artisan make:controller SubcategoryController --resource
$ php artisan make:controller TransactionController --resource
$ composer2 require laravel/ui
$ php artisan ui bootstrap
$ npm install
$ npm audit fix --force
$ npm run dev
$ php artisan make:seeder CategorySeeder
$ php artisan make:seeder CustomerSeeder
$ php artisan make:seeder InvoiceSeeder
$ php artisan make:seeder ItemSeeder
$ php artisan make:seeder OrderSeeder
$ php artisan make:seeder SubcategorySeeder
$ php artisan make:seeder TransactionSeeder
```

![platano_db scheme](https://github.com/paolomococci/enterprise-workshop/blob/main/screenshots/platano_db.png)
