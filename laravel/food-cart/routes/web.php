<?php

use Illuminate\Support\Facades\Route;

Route::get('/', function () {
    return view('welcome');
});

Route::resource(
    'customers',
    'CustomerController'
);

Route::resource(
    'ingredients',
    'IngredientController'
);

Route::resource(
    'meals',
    'MealController'
);

Route::resource(
    'recipes',
    'RecipeController'
);

Route::resource(
    'suppliers', 
    'SupplierController'
);
