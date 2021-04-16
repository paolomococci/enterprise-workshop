<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Model;

class Faculty extends Model
{
    protected $guarded = ['id'];
    
    /**
     * get the chancellor inverse relationship associated with the faculty
     *
     */
    public function faculty() {
        return $this->belongsTo(Chancellor::class);
    }
}
