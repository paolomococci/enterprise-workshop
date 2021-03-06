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
        $key = array('president', $presidents);
        return view('presidents.index')->with($key[0], $key[1]);
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
     * @param  int  $id
     * @return \Illuminate\Http\Response
     */
    public function show($id)
    {
        // TODO
    }
    
    /**
     * Display all resources in JSON format.
     *
     * @param  \App\Models\President  $president
     * @return \Illuminate\Http\Response
     */
    public function restShowAll()
    {
        return response()->json(President::all()->jsonSerialize());
    }

    /**
     * Show the form for editing the specified resource.
     *
     * @param  int  $id
     * @return \Illuminate\Http\Response
     */
    public function edit($id)
    {
        $president = President::findOrFail($id);
        return view('presidents.edit')->with('president', $president);
    }

    /**
     * Update the specified resource in storage.
     *
     * @param  \Illuminate\Http\Request  $request
     * @param  int  $id
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
     * @param  int  $id
     * @return \Illuminate\Http\Response
     */
    public function destroy($id)
    {
        $president = President::findOrFail($id);
        $president->delete();
        return redirect('/presidents')->with('completed', 'president has been deleted');
    }
}
