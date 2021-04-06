<?php

namespace App\Http\Controllers;

use App\Models\President;
use Illuminate\Http\Request;

class PresidentController extends Controller
{
    /**
     * Display a listing of the resource.
     *
     * @return \Illuminate\Http\Response
     */
    public function index()
    {
        $presidents = President::all();
        return view('presidents.index')->with('president', $presidents);
    }

    /**
     * Show the form for creating a new resource.
     *
     * @return \Illuminate\Http\Response
     */
    public function create()
    {
        return view('presidents.create');
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
            'surname' => 'required|max:255',
            'email' => 'required|max:255',
            'phone' => 'required|numeric',
        ]);
        President::create($data);
        return redirect('/presidents')->with('completed', 'president has been saved!');
    }

    /**
     * Display the specified resource.
     *
     * @param  \App\Models\President  $president
     * @return \Illuminate\Http\Response
     */
    public function show(President $president)
    {
        //
    }

    /**
     * Show the form for editing the specified resource.
     *
     * @param  \App\Models\President  $president
     * @return \Illuminate\Http\Response
     */
    public function edit(President $id)
    {
        $president = President::findOrFail($id);
        return view('presidents.edit')->with('president', $president);
    }

    /**
     * Update the specified resource in storage.
     *
     * @param  \Illuminate\Http\Request  $request
     * @param  \App\Models\President  $president
     * @return \Illuminate\Http\Response
     */
    public function update(Request $request, $id)
    {
        $updated = $request->validate([
            'name' => 'required|max:255',
            'surname' => 'required|max:255',
            'email' => 'required|max:255',
            'phone' => 'required|numeric',
        ]);
        President::whereId($id)->update($updated);
        return redirect('/presidents')->with('completed', 'president has been updated');
    }

    /**
     * Remove the specified resource from storage.
     *
     * @param  \App\Models\President  $president
     * @return \Illuminate\Http\Response
     */
    public function destroy($id)
    {
        //
    }
}
