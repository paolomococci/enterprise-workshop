<?php

namespace App\Http\Controllers;

use App\Models\Recipe;
use Illuminate\Http\Request;

class RecipeController extends Controller
{
    /**
     * Display a listing of the resource.
     *
     * @return \Illuminate\Http\Response
     */
    public function index() {
        $repipes['recipes'] = Recipe::all()->sortBy([
            fn ($a, $b) => $a['id'] <=> $b['id'],
            fn ($a, $b) => $a['name'] <=> $b['name'], 
        ]);
        return view('recipes.index', $repipes);
    }

    /**
     * Show the form for creating a new resource.
     *
     * @return \Illuminate\Http\Response
     */
    public function create() {
        return view('recipes.create');
    }
    
    /**
     * Read a listing of the resource.
     *
     * @return \Illuminate\Http\Response
     */
    public function read() {
        return response()->json(Recipe::all()->jsonSerialize());
    }
    
    /**
     * Update the specified resource in storage.
     *
     * @param  \Illuminate\Http\Request  $request
     * @param  \App\Models\Recipe  $recipe
     * @return \Illuminate\Http\Response
     */
    public function update(Request $request, int $id) {
        $request->validate([
            'name' => 'required',
            'category' => 'required',
            'todo' => 'required'
        ]);
        
        $recipe = Recipe::query()->find($id);
        $recipe->name = $request->name;
        $recipe->category = $request->category;
        $recipe->todo = $request->todo;
        $recipe->save();
        
        return redirect()->route('recipes.index')->with('success', 'recipe has been updated');
    }
    
    /**
     * Delete the specified resource from storage.
     *
     * @param  \App\Models\Recipe  $recipe
     * @return \Illuminate\Http\Response
     */
    public function delete(int $id) {
        $isDeleted = Recipe::query()->find($id)->delete();
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
            'name' => 'required',
            'category' => 'required',
            'todo' => 'required'
        ]);
        
        $recipe = new Recipe;
        $recipe->name = $request->name;
        $recipe->category = $request->category;
        $recipe->todo = $request->todo;
        $recipe->save();
        
        return redirect()->route('recipes.index')->with('success', 'recipe has been created');
    }

    /**
     * Display the specified resource.
     *
     * @param  \App\Models\Recipe  $recipe
     * @return \Illuminate\Http\Response
     */
    public function show(Recipe $recipe) {
        // TODO
    }

    /**
     * Show the form for editing the specified resource.
     *
     * @param  \App\Models\Recipe  $recipe
     * @return \Illuminate\Http\Response
     */
    public function edit(Recipe $recipe) {
        // TODO
    }

    /**
     * Remove the specified resource from storage.
     *
     * @param  \App\Models\Recipe  $recipe
     * @return \Illuminate\Http\Response
     */
    public function destroy(Recipe $recipe) {
        $recipe->delete();
        return redirect()->route('recipes.index')->with('success', 'recipe has been deleted');
    }
}
