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
