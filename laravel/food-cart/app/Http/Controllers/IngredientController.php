<?php

namespace App\Http\Controllers;

use App\Models\Ingredient;
use Illuminate\Http\Request;

class IngredientController extends Controller
{
    /**
     * Display a listing of the resource.
     *
     * @return \Illuminate\Http\Response
     */
    public function index() {
        $ingredients['ingredients'] = Ingredient::all();
        return view('ingredients.index', $ingredients);
    }

    /**
     * Show the form for creating a new resource.
     *
     * @return \Illuminate\Http\Response
     */
    public function create() {
        return view('ingredients.create');
    }
    
    /**
     * Read a listing of the resource.
     *
     * @return \Illuminate\Http\Response
     */
    public function read() {
        return response()->json(Ingredient::all()->jsonSerialize());
    }
    
    /**
     * Update the specified resource in storage.
     *
     * @param  \Illuminate\Http\Request  $request
     * @param  \App\Models\Ingredient  $ingredient
     * @return \Illuminate\Http\Response
     */
    public function update(Request $request, int $id) {
        $request->validate([
            'name' => 'required|max:255',
            'category' => 'required|max:255',
            'description' => 'required',
            'price' => 'required'
        ]);
        
        $ingredient = Ingredient::query()->find($id);
        $ingredient->name = $request->name;
        $ingredient->category = $request->category;
        $ingredient->description = $request->description;
        $ingredient->price = $request->price;
        $ingredient->save();
        
        return redirect()->route('ingredients.index')->with('success', 'ingredient has been updated');
    }
    
    /**
     * Delete the specified resource from storage.
     *
     * @param  \App\Models\Ingredient  $ingredient
     * @return \Illuminate\Http\Response
     */
    public function delete(int $id) {
        $isDeleted = Ingredient::query()->find($id)->delete();
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
            'description' => 'required',
            'price' => 'required'
        ]);
        
        $ingredient = new Ingredient;
        $ingredient->name = $request->name;
        $ingredient->category = $request->category;
        $ingredient->description = $request->description;
        $ingredient->price = $request->price;
        $ingredient->save();
        
        return redirect()->route('ingredients.index')->with('success', 'ingredient has been created');
    }

    /**
     * Display the specified resource.
     *
     * @param  \App\Models\Ingredient  $ingredient
     * @return \Illuminate\Http\Response
     */
    public function show(Ingredient $ingredient) {
        return view('ingredients.show', compact('ingredient'));
    }

    /**
     * Show the form for editing the specified resource.
     *
     * @param  \App\Models\Ingredient  $ingredient
     * @return \Illuminate\Http\Response
     */
    public function edit(Ingredient $ingredient) {
        return view('ingredients.edit', compact('ingredient'));
    }

    /**
     * Remove the specified resource from storage.
     *
     * @param  \App\Models\Ingredient  $ingredient
     * @return \Illuminate\Http\Response
     */
    public function destroy(Ingredient $ingredient) {
        $ingredient->delete();
        return redirect()->route('ingredients.index')->with('success', 'ingredient has been deleted');
    }
}
