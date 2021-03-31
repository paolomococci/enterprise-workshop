<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Model;
use Illuminate\Support\Str;

class Recipe extends Model
{
    protected $fillable = ['id', 'name', 'category', 'todo'];
}
