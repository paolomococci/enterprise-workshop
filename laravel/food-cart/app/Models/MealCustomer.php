<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Relations\Pivot;

class MealCustomer extends Pivot
{
    protected $guarded = ['id'];
}
