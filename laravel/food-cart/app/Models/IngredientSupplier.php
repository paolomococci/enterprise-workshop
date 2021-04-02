<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Relations\Pivot;

class IngredientSupplier extends Pivot
{
    protected $guarded = ['id'];
}
