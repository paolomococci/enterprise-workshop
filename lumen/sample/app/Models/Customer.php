<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Model;

class Customer extends Model {

    /**
     * The attributes that are mass assignable.
     *
     * @var array
     */
    protected $fillable = [
        'code', 'name', 'email',
    ];
    
    public function items() {
        return $this->belongsToMany(Item::class);
    }
}
