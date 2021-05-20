<?php

use Illuminate\Database\Seeder;
use Illuminate\Support\Facades\DB;
use Illuminate\Support\Facades\Hash;
use Illuminate\Support\Str;

class ItemSeeder extends Seeder
{
    /**
     * Run the database seeds.
     *
     * @return void
     */
    public function run()
    {
        DB::table('customers')->insert([
            'code' => Hash::make(Str::random(12)),
            'name' => Str::random(20),
            'descrition' => Str::random(40),
            'type' => Str::random(8),
            'price' => 0.0,
            'stock' => 0,
        ]);
    }
}
