<?php

use Illuminate\Support\Facades\Route;

Route::get('/', function () {
    return view('welcome');
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
