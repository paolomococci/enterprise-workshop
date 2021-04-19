<?php

namespace App\Http\Controllers;

use App\Models\Chancellor;
use Illuminate\Http\Request;

class ChancellorController extends Controller
{
    /**
     * Display a listing of the resource.
     *
     * @return \Illuminate\Http\Response
     */
    public function index()
    {
        $chancellors = Chancellor::all();
        $key = array('chancellor', $chancellors);
        return view('chancellors.index')->with($key[0], $key[1]);
    }

    /**
     * Show the form for creating a new resource.
     *
     * @return \Illuminate\Http\Response
     */
    public function create()
    {
        return view('chancellors.create');
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
        Chancellor::create($data);
        return redirect('/chancellors')->with('completed', 'chancellor has been saved!');
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
     * @return \Illuminate\Http\Response
     */
    public function restShowAll()
    {
        return response()->json(Chancellor::all()->jsonSerialize());
    }

    /**
     * Show the form for editing the specified resource.
     *
     * @param  int  $id
     * @return \Illuminate\Http\Response
     */
    public function edit($id)
    {
        $chancellor = Chancellor::findOrFail($id);
        return view('chancellors.edit')->with('chancellor', $chancellor);
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
        Chancellor::whereId($id)->update($updated);
        return redirect('/chancellors')->with('completed', 'chancellor has been updated');
    }

    /**
     * Remove the specified resource from storage.
     *
     * @param  int  $id
     * @return \Illuminate\Http\Response
     */
    public function destroy($id)
    {
        $chancellor = Chancellor::findOrFail($id);
        $chancellor->delete();
        return redirect('/chancellors')->with('completed', 'chancellor has been deleted');
    }
}
