<?php

use Illuminate\Database\Seeder;
use Illuminate\Support\Facades\DB;

class OrderSeeder extends Seeder
{
    /**
     * Run the database seeds.
     *
     * @return void
     */
    public function run()
    {
        DB::table('customers')->insert([
            'status' => 'sample',
            'total' => 0,
            'tax' => 0,
            'shipping' => 0,
        ]);
    }
}
