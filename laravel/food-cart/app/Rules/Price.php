<?php

namespace App\Rules;

use Illuminate\Contracts\Validation\Rule;

class Price implements Rule
{
    /**
     * Create a new rule instance.
     *
     * @return void
     */
    public function __construct()
    {
        // TODO
    }

    /**
     * Determine if the validation rule passes.
     *
     * @param  string  $attribute
     * @param  mixed  $value
     * @return bool
     */
    public function passes($attribute, $value)
    {
        // TODO
    }

    /**
     * Get the validation error message.
     *
     * @return string
     */
    public function message()
    {
        return 'price must be a number with two decimal places';
    }
}
