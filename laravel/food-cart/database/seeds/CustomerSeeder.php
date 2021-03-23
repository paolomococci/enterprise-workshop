<?php

use Illuminate\Database\Seeder;

class CustomerSeeder extends Seeder
{
    /**
     * Run the database seeds.
     *
     * @return void
     */
    public function run()
    {
        DB::table('customers')->insert([
            // a series of completely invented names for the sole purpose of example
            [
                'name' => 'Susan',
                'surname' => 'Weave',
                'email' => 'susan.weave@example.local',
            ],
            [
                'name' => 'Fiona',
                'surname' => 'Win',
                'email' => 'fiona.win@example.local',
            ],
            [
                'name' => 'John',
                'surname' => 'Tell',
                'email' => 'john.tell@example.local',
            ],
            [
                'name' => 'Ann',
                'surname' => 'Think',
                'email' => 'ann.think@example.local',
            ],
            [
                'name' => 'Bob',
                'surname' => 'Swing',
                'email' => 'bob.swing@example.local',
            ],
            // TODO
        ]);
    }
}
