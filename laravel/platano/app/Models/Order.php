<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Model;

class Order extends Model
{
    protected $guarded = ['id'];
    
    public function customer() {
        return $this->belongsTo(Customer::class);
    }
    
    public function invoice() {
        return $this->hasOne(Invoice::class);
    }
    
    public function items() {
        return $this->belongsToMany(Item::class);
    }
}
