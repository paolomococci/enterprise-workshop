<?php

use Illuminate\Database\Migrations\Migration;
use Illuminate\Database\Schema\Blueprint;
use Illuminate\Support\Facades\Schema;

class CreatePresidentsChancellorsRelationTable extends Migration
{
    /**
     * Run the migrations.
     *
     * @return void
     */
    public function up()
    {
        Schema::create('presidents_chancellors_relation', function (Blueprint $table) {
            $table->bigIncrements('id');
            $table->bigInteger('president_id')->unsigned()->index();
            $table->bigInteger('chancellor_id')->unsigned()->index();
            $table->string('title');
            $table->string('directive');
            $table->timestamps();
            
            $table->foreign('president_id')->references('id')->on('presidents');
            $table->foreign('chancellor_id')->references('id')->on('chancellors');
        });
    }

    /**
     * Reverse the migrations.
     *
     * @return void
     */
    public function down()
    {
        Schema::dropIfExists('presidents_chancellors_relation');
    }
}
