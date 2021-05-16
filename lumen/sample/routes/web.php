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
$router->get('/api/item/{id}', 'ItemController@updateItem');
$router->get('/api/item/{id}', 'ItemController@deleteItem');
