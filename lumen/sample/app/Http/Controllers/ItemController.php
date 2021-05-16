<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;

use App\Models\Item;

class ItemController extends Controller {

    public function readAllItems() {
        $items = Item::all();
        return response()->json($items, '200');
    }
    
    public function readItem($id) {
        $item = Item::find($id);
        return response()->json($item, '200');
    }
    
    public function createItem(Request $request) {
        $item = Item::create($request->all());
        return response()->json($item, '201');
    }
    
    public function updateItem(Request $request, $id) {
        $item = Item::find($id);
        $item->code = $request->input('code');
        $item->name = $request->input('name');
        $item->description = $request->input('description');
        $item->save();
        return response()->json($item, '205');
    }
    
    public function deleteItem($id) {
        $item = Item::find($id);
        $item->delete();
        return response()->json('No Content', '204');
    }
}
