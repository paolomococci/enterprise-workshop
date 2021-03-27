<?php

use Illuminate\Http\Request;
use Illuminate\Support\Facades\Route;

use App\Http\Controllers\CustomerController;
use App\Http\Controllers\IngredientController;
use App\Http\Controllers\MealController;
use App\Http\Controllers\RecipeController;
use App\Http\Controllers\SupplierController;

Route::middleware('auth:api')->get('/user', function (Request $request) {
    return $request->user();
});

Route::get('/customers', [CustomerController::class, 'index']);
Route::get('/ingredients', [IngredientController::class, 'index']);
Route::get('/meals', [MealController::class, 'index']);
Route::get('/recipes', [RecipeController::class, 'index']);
Route::get('/suppliers', [SupplierController::class, 'index']);

Route::post('/recipes', 'RecipeController@save');
