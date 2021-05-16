<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;

use App\Models\Supplier;

class SupplierController extends Controller {

    public function readAllSuppliers() {
        $suppliers = Supplier::all();
        return response()->json($suppliers, '200');
    }
    
    public function readSupplier($id) {
        $supplier = Supplier::find($id);
        return response()->json($supplier, '200');
    }
    
    public function createSupplier(Request $request) {
        $supplier = Supplier::create($request->all());
        return response()->json($supplier, '201');
    }
    
    public function updateSupplier(Request $request, $id) {
        $supplier = Supplier::find($id);
        $supplier->code = $request->input('code');
        $supplier->name = $request->input('name');
        $supplier->description = $request->input('description');
        $supplier->save();
        return response()->json($supplier, '205');
    }
    
    public function deleteSupplier($id) {
        $supplier = Supplier::find($id);
        $supplier->delete();
        return response()->json('No Content', '204');
    }
}
