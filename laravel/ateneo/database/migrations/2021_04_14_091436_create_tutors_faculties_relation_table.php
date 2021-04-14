<?php

use Illuminate\Database\Migrations\Migration;
use Illuminate\Database\Schema\Blueprint;
use Illuminate\Support\Facades\Schema;

class CreateTutorsFacultiesRelationTable extends Migration
{
    /**
     * Run the migrations.
     *
     * @return void
     */
    public function up()
    {
        Schema::create('tutors_faculties_relation', function (Blueprint $table) {
            $table->bigIncrements('id');
            $table->bigInteger('tutor_id')->unsigned()->index();
            $table->bigInteger('faculty_id')->unsigned()->index();
            $table->timestamps();
            
            $table->foreign('tutor_id')->references('id')->on('tutors');
            $table->foreign('faculty_id')->references('id')->on('faculties');
        });
    }

    /**
     * Reverse the migrations.
     *
     * @return void
     */
    public function down()
    {
        Schema::dropIfExists('tutors_faculties_relation');
    }
}
