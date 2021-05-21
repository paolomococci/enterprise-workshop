<?php

use Illuminate\Support\Facades\Route;

/*
|--------------------------------------------------------------------------
| Web Routes
|--------------------------------------------------------------------------
|
| Here is where you can register web routes for your application. These
| routes are loaded by the RouteServiceProvider within a group which
| contains the "web" middleware group. Now create something great!
|
*/

Route::get('/', function () {
    return view('welcome');
});

//Route::resource('customers', 'CustomerController');
//Route::resource('categories', 'CategoryController');
//Route::resource('subcategories', 'SubcategoryController');
//Route::resource('items', 'ItemController');
//Route::resource('orders', 'OrderController');
//Route::resource('invoices', 'InvoiceController');
//Route::resource('transactions', 'TransactionController');
