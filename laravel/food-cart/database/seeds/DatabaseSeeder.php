<?php

namespace Database\Seeds;

use Illuminate\Database\Seeder;
use Illuminate\Support\Facades\DB;

class DatabaseSeeder extends Seeder
{
    /**
     * Seed the application's database.
     *
     * @return void
     */
    public function run()
    {
        //$this->call(UserSeeder::class);
        $this->call(CustomerSeeder::class);
        //$this->call(IngredientSeeder::class);
        //$this->call(MealSeeder::class);
        //$this->call(RecipeSeeder::class);
        //$this->call(SupplierSeeder::class);
    }
}
