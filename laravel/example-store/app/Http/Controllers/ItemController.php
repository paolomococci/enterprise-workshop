<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;

class ItemController extends Controller
{
    public function getItemDetail($id) {
        return 'item detail identified by: ' . $id;
    }
}
