<?php

use Illuminate\Support\Facades\Route;

Route::get('/', function () {
    return view('welcome');
});

Route::resource('students', 'StudentController');
Route::resource('tutors', 'TutorController');
Route::resource('teachers', 'TeacherController');
Route::resource('employees', 'EmployeeController');
Route::resource('chancellors', 'ChancellorController');
Route::resource('presidents', 'PresidentController');
