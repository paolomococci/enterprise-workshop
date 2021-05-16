<?php

/*
|--------------------------------------------------------------------------
| Application Routes
|--------------------------------------------------------------------------
|
| Here is where you can register all of the routes for an application.
| It is a breeze. Simply tell Lumen the URIs it should respond to
| and give it the Closure to call when that URI is requested.
|
*/

$router->get('/', function () use ($router) {
    return $router->app->version();
});

$router->get('/api/items', 'ItemController@readAllItems');
$router->get('/api/item/{id}', 'ItemController@readItem');
$router->post('/api/item', 'ItemController@createItem');
$router->put('/api/item/{id}', 'ItemController@updateItem');
$router->delete('/api/item/{id}', 'ItemController@deleteItem');

$router->get('/api/customers', 'CustomerController@readAllCustomers');
$router->get('/api/customer/{id}', 'CustomerController@readCustomer');
$router->post('/api/customer', 'CustomerController@createCustomer');
$router->put('/api/customer/{id}', 'CustomerController@updateCustomer');
$router->delete('/api/customer/{id}', 'CustomerController@deleteCustomer');

$router->get('/api/suppliers', 'SupplierController@readAllSuppliers');
$router->get('/api/supplier/{id}', 'SupplierController@readSupplier');
$router->post('/api/supplier', 'SupplierController@createSupplier');
$router->put('/api/supplier/{id}', 'SupplierController@updateSupplier');
$router->delete('/api/supplier/{id}', 'SupplierController@deleteSupplier');
