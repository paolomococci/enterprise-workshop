<?php

use Illuminate\Database\Migrations\Migration;
use Illuminate\Database\Schema\Blueprint;
use Illuminate\Support\Facades\Schema;

class CreateIngredientSupplierRelationTable extends Migration
{
    /**
     * Run the migrations.
     *
     * @return void
     */
    public function up()
    {
        Schema::create('ingredient_supplier_relation', function (Blueprint $table) {
            $table->bigIncrements('id');
            $table->bigInteger('ingredient_id')->unsigned()->index();
            $table->bigInteger('supplier_id')->unsigned()->index();
            $table->decimal('quantity', 5, 3);
            $table->timestamps();
            
            $table->foreign('ingredient_id')->references('id')->on('ingredients');
            $table->foreign('supplier_id')->references('id')->on('suppliers');
        });
    }

    /**
     * Reverse the migrations.
     *
     * @return void
     */
    public function down()
    {
        Schema::dropIfExists('ingredient_supplier_relation');
    }
}
