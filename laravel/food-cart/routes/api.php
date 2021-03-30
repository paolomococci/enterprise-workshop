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

Route::get('/customers', [CustomerController::class, 'read']);
Route::get('/ingredients', [IngredientController::class, 'read']);
Route::get('/meals', [MealController::class, 'read']);
Route::get('/recipes', [RecipeController::class, 'read']);
Route::get('/suppliers', [SupplierController::class, 'read']);
