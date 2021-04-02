<?php

namespace App\Http\Controllers;

use App\Models\Customer;
use Illuminate\Http\Request;

class CustomerController extends Controller
{
    /**
     * Display a listing of the resource.
     *
     * @return \Illuminate\Http\Response
     */
    public function index() {
        $customers['customers'] = Customer::all();
        return view('cusomers.index', $customers);
    }

    /**
     * Show the form for creating a new resource.
     *
     * @return \Illuminate\Http\Response
     */
    public function create() {
        return view('customers.create');
    }
    
    /**
     * Read a listing of the resource.
     *
     * @return \Illuminate\Http\Response
     */
    public function read() {
        return response()->json(Customer::all()->jsonSerialize());
    }
    
    /**
     * Update the specified resource in storage.
     *
     * @param  \Illuminate\Http\Request  $request
     * @param  \App\Models\Customer  $customer
     * @return \Illuminate\Http\Response
     */
    public function update(Request $request, int $id) {
        $request->validate([
            'name' => 'required|max:255',
            'surname' => 'required|max:255',
            'email' => 'required|email|max:255|unique:customers,email'
        ]);
        
        $customer = Customer::query()->find($id);
        $customer->name = $request->name;
        $customer->surname = $request->surname;
        $customer->email = $request->email;
        $customer->save();
        
        return redirect()->route('customers.index')->with('success', 'customer has been updated');
    }
    
    /**
     * Delete the specified resource from storage.
     *
     * @param  \App\Models\Customer  $customer
     * @return \Illuminate\Http\Response
     */
    public function delete(int $id) {
        $customer = Customer::query()->findOrFail($id);
        $customer->delete();
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
            'email' => 'required|email|max:255|unique:customers,email'
        ]);
        
        $customer = new Customer;
        $customer->name = $request->name;
        $customer->surname = $request->surname;
        $customer->email = $request->email;
        $customer->save();
        
        return redirect()->route('customers.index')->with('success', 'customer has been created');
    }

    /**
     * Display the specified resource.
     *
     * @param  \App\Models\Customer  $customer
     * @return \Illuminate\Http\Response
     */
    public function show(Customer $customer) {
        return view('customers.show', compact('customer'));
    }

    /**
     * Show the form for editing the specified resource.
     *
     * @param  \App\Models\Customer  $customer
     * @return \Illuminate\Http\Response
     */
    public function edit(Customer $customer) {
        return view('customers.edit', compact('customer'));
    }

    /**
     * Remove the specified resource from storage.
     *
     * @param  \App\Models\Customer  $customer
     * @return \Illuminate\Http\Response
     */
    public function destroy(Customer $customer) {
        $customer->delete();
        return redirect()->route('customers.index')->with('success', 'customer has been deleted');
    }
}
