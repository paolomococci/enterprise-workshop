<?php

use Illuminate\Support\Facades\Route;

use App\Http\Controllers\RecipeController;
use App\Http\Controllers\CustomerController;
use App\Http\Controllers\IngredientController;
use App\Http\Controllers\MealController;
use App\Http\Controllers\SupplierController;

Route::get('/', function () {
    return view('welcome');
});

Route::resource(
    'customers',
    CustomerController::class
);

Route::resource(
    'ingredients',
    IngredientController::class
);

Route::resource(
    'meals',
    MealController::class
);

Route::resource(
    'recipes',
    RecipeController::class
);

Route::resource(
    'suppliers', 
    SupplierController::class
);
