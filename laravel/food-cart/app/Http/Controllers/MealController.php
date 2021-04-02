<?php

namespace App\Http\Controllers;

use App\Models\Meal;
use Illuminate\Http\Request;

class MealController extends Controller
{
    /**
     * Display a listing of the resource.
     *
     * @return \Illuminate\Http\Response
     */
    public function index() {
        $meals['meals'] = Meal::all();
        return view('meals.index', $meals);
    }

    /**
     * Show the form for creating a new resource.
     *
     * @return \Illuminate\Http\Response
     */
    public function create() {
        return view('meals.create');
    }
    
    /**
     * Read a listing of the resource.
     *
     * @return \Illuminate\Http\Response
     */
    public function read() {
        return response()->json(Meal::all()->jsonSerialize());
    }
    
    /**
     * Update the specified resource in storage.
     *
     * @param  \Illuminate\Http\Request  $request
     * @param  \App\Models\Meal  $meal
     * @return \Illuminate\Http\Response
     */
    public function update(Request $request, int $id) {
        $request->validate([
            'name' => 'required|max:255',
            'category' => 'required|max:255',
            'description' => 'required|max:1024',
            'price' => 'required|numeric'
        ]);
        
        $meal = Meal::query()->find($id);
        $meal->name = $request->name;
        $meal->category = $request->category;
        $meal->description = $request->description;
        $meal->price = $request->price;
        $meal->save();
        
        return redirect()->route('meals.index')->with('success', 'meal has been updated');
    }
    
    /**
     * Delete the specified resource from storage.
     *
     * @param  \App\Models\Meal  $meal
     * @return \Illuminate\Http\Response
     */
    public function delete(int $id) {
        $isDeleted = Meal::query()->find($id)->delete();
        if ($isDeleted) {
            // TODO;
        }
    }

    /**
     * Store a newly created resource in storage.
     *
     * @param  \Illuminate\Http\Request  $request
     * @return \Illuminate\Http\Response
     */
    public function store(Request $request) {
        $request->validate([
            'name' => 'required|max:255',
            'category' => 'required|max:255',
            'description' => 'required|max:1024',
            'price' => 'required|numeric'
        ]);
        
        $meal = new Meal;
        $meal->name = $request->name;
        $meal->category = $request->category;
        $meal->description = $request->description;
        $meal->price = $request->price;
        $meal->save();
        
        return redirect()->route('meals.index')->with('success', 'meal has been created');
    }

    /**
     * Display the specified resource.
     *
     * @param  \App\Models\Meal  $meal
     * @return \Illuminate\Http\Response
     */
    public function show(Meal $meal) {
        return view('meals.show', compact('meals'));
    }

    /**
     * Show the form for editing the specified resource.
     *
     * @param  \App\Models\Meal  $meal
     * @return \Illuminate\Http\Response
     */
    public function edit(Meal $meal) {
        return view('meals.edit', compact('meals'));
    }

    /**
     * Remove the specified resource from storage.
     *
     * @param  \App\Models\Meal  $meal
     * @return \Illuminate\Http\Response
     */
    public function destroy(Meal $meal) {
        $meal->delete();
        return redirect()->route('meals.index')->with('success', 'meal has been deleted');
    }
}
