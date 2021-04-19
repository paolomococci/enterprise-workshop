<?php

namespace App\Http\Controllers;

use App\Models\Chancellor;
use App\Models\Faculty;
use Illuminate\Http\Request;

class FacultyController extends Controller
{
    /**
     * Display a listing of the resource.
     *
     * @return \Illuminate\Http\Response
     */
    public function index()
    {
        $faculties = Faculty::all();
        $key = array('faculty', $faculties);
        return view('faculties.index')->with($key[0], $key[1]);
    }

    /**
     * Show the form for creating a new resource.
     *
     * @return \Illuminate\Http\Response
     */
    public function create()
    {
        return view('faculties.create');
    }

    /**
     * Store a newly created resource in storage.
     *
     * @param  \Illuminate\Http\Request  $request
     * @return \Illuminate\Http\Response
     */
    public function store(Request $request)
    {
        $data = $request->validate([
            'name' => 'required|max:255',
        ]);
        Faculty::create($data);
        return redirect('/faculties')->with('completed', 'faculty has been saved!');
    }

    /**
     * Display a listing of faculties which have a chancellor.
     *
     * @return \Illuminate\Http\Response
     */
    public function show()
    {
        $faculties = Faculty::all();
        $facultyKey = array('faculty', $faculties);
        $chancellors = Chancellor::all();
        $chancellorKey = array('chancellor', $chancellors);
        return view('faculties.assigned')
            ->with($facultyKey[0], $facultyKey[1])
            ->with($chancellorKey[0], $chancellorKey[1]);
    }
    
    /**
     * Display all resources in JSON format.
     *
     * @return \Illuminate\Http\Response
     */
    public function restShowAll()
    {
        return response()->json(Faculty::all()->jsonSerialize());
    }

    /**
     * Show the form for editing the specified resource.
     *
     * @param  int $id
     * @return \Illuminate\Http\Response
     */
    public function edit($id)
    {
        $faculty = Faculty::findOrFail($id);
        return view('faculties.edit')->with('faculty', $faculty);
    }

    /**
     * Update the specified resource in storage.
     *
     * @param  \Illuminate\Http\Request  $request
     * @param  int $id
     * @return \Illuminate\Http\Response
     */
    public function update(Request $request, $id)
    {
        $updated = $request->validate([
            'name' => 'required|max:255',
        ]);
        Faculty::whereId($id)->update($updated);
        return redirect('/faculties')->with('completed', 'faculty has been updated');
    }

    /**
     * Remove the specified resource from storage.
     *
     * @param  int $id
     * @return \Illuminate\Http\Response
     */
    public function destroy($id)
    {
        $faculty = Faculty::findOrFail($id);
        $faculty->delete();
        return redirect('/faculties')->with('completed', 'faculty has been deleted');
    }
}
