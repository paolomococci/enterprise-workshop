<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Model;

class Chancellor extends Model
{
    protected $guarded = ['id'];
    
    /**
     * get the faculty record associated with the chancellor
     * 
     */
    public function faculty() {
        return $this->hasOne(Faculty::class);
    }
}
