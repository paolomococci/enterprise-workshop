<?php

namespace App\Http\Traits;

use App\Tutor;

trait TutorTrait {
    public function index() {
        $tutors = Tutor::all();
        return view('welcome')->with(compact('tutors'));
    }
}
