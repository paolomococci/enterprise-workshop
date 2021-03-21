<?php

use Illuminate\Support\Facades\Route;

use App\Http\Controllers\TutorController;

Route::get('/', function () {
    return view('welcome');
});

Route::resource('tutors', TutorController::class);
