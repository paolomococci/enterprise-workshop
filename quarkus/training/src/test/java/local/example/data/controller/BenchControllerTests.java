/**
 *
 * Copyright 2021 paolo mococci
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * 	   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed following in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package local.example.data.controller;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import local.example.data.model.Bench;

@QuarkusTest
@TestMethodOrder(OrderAnnotation.class)
public class BenchControllerTest {

	private static Bench bench;

	@Test
	@Order(1)
	public void readAllEmptyTest() {
		List<Bench> benchs = RestAssured.given()
				.when().get("/bench")
				.then()
				.statusCode(200)
				.extract()
				.body()
				.jsonPath()
				.getList(".", Bench.class);
		Assertions.assertTrue(benchs.isEmpty());
	}

	@Test
	@Order(2)
	public void createTest() {
		BenchControllerTest.setBench(RestAssured.given()
				.when()
				.contentType(ContentType.JSON)
				.body("{\"name\":\"something\"}")
				.post("/bench")
				.then()
				.statusCode(201)
				.extract()
				.as(Bench.class));
		Assertions.assertNotNull(BenchControllerTest.getBench().getId());
	}

	@Test
	@Order(3)
	public void readTest() {
		Bench temporaryBench  = RestAssured.given()
				.when()
				.get("/bench/{id}", BenchControllerTest.getBench().getId())
				.then()
				.statusCode(200)
				.extract()
				.as(Bench.class);
		Assertions.assertNotNull(temporaryBench.getId());
		Assertions.assertTrue(temporaryBench.getName().contentEquals("something"));
	}

	@Test
	@Order(4)
	public void readAllTest() {
		List<Bench> benchs = RestAssured.given()
				.when().get("/bench")
				.then()
				.statusCode(200)
				.extract()
				.body()
				.jsonPath()
				.getList(".", Bench.class);
		Assertions.assertFalse(benchs.isEmpty());
	}

	@Test
	@Order(5)
	public void updateTest() {
		RestAssured.given()
				.when()
				.contentType(ContentType.JSON)
				.body("{\"name\":\"something else\"}")
				.put("/bench/{id}", BenchControllerTest.getBench().getId())
				.then()
				.statusCode(204);
		Bench temporaryBench  = RestAssured.given()
				.when()
				.get("/bench/{id}", BenchControllerTest.getBench().getId())
				.then()
				.statusCode(200)
				.extract()
				.as(Bench.class);
		Assertions.assertTrue(temporaryBench.getName().contentEquals("something else"));
	}

	@Test
	@Order(6)
	public void deleteTest() {
		RestAssured.given()
				.when()
				.delete("/bench/{id}", BenchControllerTest.getBench().getId())
				.then()
				.statusCode(204);
	}

	public static Bench getBench() {
		return bench;
	}

	public static void setBench(Bench bench) {
		BenchControllerTest.bench = bench;
	}
}
