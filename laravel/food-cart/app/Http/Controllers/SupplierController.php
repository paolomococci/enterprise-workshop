<?php

namespace App\Http\Controllers;

use App\Models\Supplier;
use Illuminate\Http\Request;

class SupplierController extends Controller
{
    /**
     * Display a listing of the resource.
     *
     * @return \Illuminate\Http\Response
     */
    public function index() {
        $suppliers['suppliers'] = Supplier::all()->sortKeysDesc()->setPerPage(5);
        return view('suppliers.index', $suppliers);
    }

    /**
     * Show the form for creating a new resource.
     *
     * @return \Illuminate\Http\Response
     */
    public function create() {
        return view('suppliers.create');
    }
    
    /**
     * Read a listing of the resource.
     *
     * @return \Illuminate\Http\Response
     */
    public function read() {
        return response()->json(Supplier::all()->jsonSerialize());
    }
    
    /**
     * Update the specified resource in storage.
     *
     * @param  \Illuminate\Http\Request  $request
     * @param  \App\Models\Supplier  $supplier
     * @return \Illuminate\Http\Response
     */
    public function update(Request $request, int $id) {
        $request->validate([
            'name' => 'required|max:255',
            'surname' => 'required|max:255',
            'email' => 'required|email|max:255|unique:suppliers,email'
        ]);
        
        $supplier = Supplier::query()->find($id);
        $supplier->name = $request->name;
        $supplier->surname = $request->surname;
        $supplier->email = $request->email;
        $supplier->save();
        
        return redirect()->route('suppliers.index')->with('success', 'supplier has been updated');
    }
    
    /**
     * Delete the specified resource from storage.
     *
     * @param  \App\Models\Supplier  $supplier
     * @return \Illuminate\Http\Response
     */
    public function delete(int $id) {
        $supplier = Supplier::query()->findOrFail($id);
        $supplier->delete();
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
            'surname' => 'required|max:255',
            'email' => 'required|email|max:255|unique:suppliers,email'
        ]);
        
        $supplier = new Supplier;
        $supplier->name = $request->name;
        $supplier->surname = $request->surname;
        $supplier->email = $request->email;
        $supplier->save();
        
        return redirect()->route('suppliers.index')->with('success', 'supplier has been created');
    }

    /**
     * Display the specified resource.
     *
     * @param  \App\Models\Supplier  $supplier
     * @return \Illuminate\Http\Response
     */
    public function show(Supplier $supplier) {
        return view('suppliers.show', compact('supplier'));
    }

    /**
     * Show the form for editing the specified resource.
     *
     * @param  \App\Models\Supplier  $supplier
     * @return \Illuminate\Http\Response
     */
    public function edit(Supplier $supplier) {
        return view('suppliers.edit', compact('supplier'));
    }

    /**
     * Remove the specified resource from storage.
     *
     * @param  \App\Models\Supplier  $supplier
     * @return \Illuminate\Http\Response
     */
    public function destroy(Supplier $supplier) {
        $supplier->delete();
        return redirect()->route('suppliers.index')->with('success', 'supplier has been deleted');
    }
}
