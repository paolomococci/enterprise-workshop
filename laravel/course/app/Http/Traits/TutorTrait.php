<?php

namespace App\Http\Traits;

use App\Models\Tutor;

trait TutorTrait {
    public function index() {
        $tutors = Tutor::all();
        return view('welcome')->with(compact('tutors'));
    }
}
