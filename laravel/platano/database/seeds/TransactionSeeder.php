<?php

use Illuminate\Database\Seeder;
use Illuminate\Support\Facades\DB;
use Illuminate\Support\Facades\Hash;
use Illuminate\Support\Str;

class TransactionSeeder extends Seeder
{
    /**
     * Run the database seeds.
     *
     * @return void
     */
    public function run()
    {
        /*DB::table('customers')->insert([
            'code' => Hash::make(Str::random(8)),
            'status' => 'sample',
            'payment' => 0.0,
        ]);*/
    }
}
