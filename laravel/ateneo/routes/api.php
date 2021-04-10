<?php


use Illuminate\Http\Request;
use Illuminate\Support\Facades\Route;

use App\Http\Controllers\ChancellorController;
use App\Http\Controllers\EmployeeController;
use App\Http\Controllers\FacultyController;
use App\Http\Controllers\PresidentController;
use App\Http\Controllers\StudentController;
use App\Http\Controllers\TeacherController;
use App\Http\Controllers\TutorController;

Route::middleware('auth:api')->get('/user', function (Request $request) {
    return $request->user();
});

Route::get('/students', [StudentController::class, 'restShowAll']);
Route::get('/tutors', [TutorController::class, 'restShowAll']);
Route::get('/teachers', [TeacherController::class, 'restShowAll']);
Route::get('/employees', [EmployeeController::class, 'restShowAll']);
Route::get('/chancellors', [ChancellorController::class, 'restShowAll']);
Route::get('/presidents', [PresidentController::class, 'restShowAll']);

Route::get('/faculties', [FacultyController::class, 'restShowAll']);
