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
        return view('chancellors.index')->with('chancellor', $chancellors);
    }

    /**
     * Show the form for creating a new resource.
     *
     * @return \Illuminate\Http\Response
     */
    public function create()
    {
        //
    }

    /**
     * Store a newly created resource in storage.
     *
     * @param  \Illuminate\Http\Request  $request
     * @return \Illuminate\Http\Response
     */
    public function store(Request $request)
    {
        //
    }

    /**
     * Display the specified resource.
     *
     * @param  \App\Models\Chancellor  $chancellor
     * @return \Illuminate\Http\Response
     */
    public function show(Chancellor $chancellor)
    {
        //
    }

    /**
     * Show the form for editing the specified resource.
     *
     * @param  \App\Models\Chancellor  $chancellor
     * @return \Illuminate\Http\Response
     */
    public function edit(Chancellor $chancellor)
    {
        //
    }

    /**
     * Update the specified resource in storage.
     *
     * @param  \Illuminate\Http\Request  $request
     * @param  \App\Models\Chancellor  $chancellor
     * @return \Illuminate\Http\Response
     */
    public function update(Request $request, Chancellor $chancellor)
    {
        //
    }

    /**
     * Remove the specified resource from storage.
     *
     * @param  \App\Models\Chancellor  $chancellor
     * @return \Illuminate\Http\Response
     */
    public function destroy(Chancellor $chancellor)
    {
        //
    }
}
