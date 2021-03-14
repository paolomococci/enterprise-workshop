<?php

use Illuminate\Support\Facades\Route;

Route::get('/', [ 'as' => 'home', function () {
    return view('welcome');
}]);

Route::get('/home', function () {
    return redirect(route('home'));
});
 
Route::get('/hello', function () {
    return 'Hello World, from GET method.';
});

Route::post('/hello', function () {
    return 'Hello World, from POST method.';
});

Route::match(['get', 'post'], '/match', function () {
    return 'Hello World, from some specific methods.';
});

Route::any('/any', function () {
    return 'Hello World, from any method';
});

Route::get('/parametric/path/{id?}', function ($id=1) {
    return 'Your request has an identifying numeric parameter: ' . $id;
})->where(['id' => '[0-9]+']);

Route::get('/item/{id}', [ 'as' => 'itemDetail', 'uses' => 'ItemController@getItemDetail']);

Route::get('/info', function () {
    phpinfo();
});
