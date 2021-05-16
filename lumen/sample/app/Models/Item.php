<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Model;

class Item extends Model {

    /**
     * The attributes that are mass assignable.
     *
     * @var array
     */
    protected $fillable = [
        'code', 'name', 'description',
    ];
    
    public function customers() {
        return $this->belongsToMany(Customer::class);
    }
    
    public function suppliers() {
        return $this->belongsToMany(Supplier::class);
    }
}
