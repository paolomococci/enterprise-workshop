<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Relations\Pivot;

class RecipeMeal extends Pivot
{
    protected $guarded = ['id'];
}
