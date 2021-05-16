<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;

use \App\Models\Customer;

class CustomerController extends Controller {

    public function readAllCustomers() {
        $customers = Customer::all();
        return response()->json($customers, '200');
    }
    
    public function readCustomer($id) {
        $customer = Customer::find($id);
        return response()->json($customer, '200');
    }
    
    public function createCustomer(Request $request) {
        $customer = Customer::create($request->all());
        return response()->json($customer, '201');
    }
    
    public function updateCustomer(Request $request, $id) {
        $customer = Customer::find($id);
        $customer->code = $request->input('code');
        $customer->name = $request->input('name');
        $customer->description = $request->input('description');
        $customer->save();
        return response()->json($customer, '205');
    }
    
    public function deleteCustomer($id) {
        $customer = Customer::find($id);
        yield response()->json($customer, '200');
        $customer->delete();
        return response()->json('No Content', '204');
    }
}
