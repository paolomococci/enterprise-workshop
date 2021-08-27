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

package local.example.controller;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import local.example.data.model.Hearer;

@QuarkusTest
@TestMethodOrder(OrderAnnotation.class)
public class HearerControllerTest {

	private static Hearer hearer;

	@Test
	@Order(1)
	public void readAllEmptyTest() {
		List<Hearer> hearers = RestAssured.given()
				.when().get("/hearer")
				.then()
				.statusCode(200)
				.extract()
				.body()
				.jsonPath()
				.getList(".", Hearer.class);
		Assertions.assertTrue(hearers.isEmpty());
	}

	@Test
	@Order(2)
	public void createTest() {
		HearerControllerTest.setHearer(RestAssured.given()
				.when()
				.contentType(ContentType.JSON)
				.body("{\"name\":\"something\"}")
				.post("/hearer")
				.then()
				.statusCode(201)
				.extract()
				.as(Hearer.class));
		Assertions.assertNotNull(HearerControllerTest.getHearer().getId());
	}

	@Test
	@Order(3)
	public void readTest() {
		Hearer temporaryHearer  = RestAssured.given()
				.when()
				.get("/hearer/{id}", HearerControllerTest.getHearer().getId())
				.then()
				.statusCode(200)
				.extract()
				.as(Hearer.class);
		Assertions.assertNotNull(temporaryHearer.getId());
		Assertions.assertTrue(temporaryHearer.getName().contentEquals("something"));
	}

	@Test
	@Order(4)
	public void readAllTest() {
		List<Hearer> hearers = RestAssured.given()
				.when().get("/hearer")
				.then()
				.statusCode(200)
				.extract()
				.body()
				.jsonPath()
				.getList(".", Hearer.class);
		Assertions.assertFalse(hearers.isEmpty());
	}

	@Test
	@Order(5)
	public void updateTest() {
		RestAssured.given()
			.when()
			.contentType(ContentType.JSON)
			.body("{\"name\":\"something else\"}")
			.put("/hearer/{id}", HearerControllerTest.getHearer().getId())
			.then()
			.statusCode(204);
		Hearer temporaryHearer  = RestAssured.given()
				.when()
				.get("/hearer/{id}", HearerControllerTest.getHearer().getId())
				.then()
				.statusCode(200)
				.extract()
				.as(Hearer.class);
		Assertions.assertTrue(temporaryHearer.getName().contentEquals("something else"));
	}

	@Test
	@Order(6)
	public void deleteTest() {
		RestAssured.given()
				.when()
				.delete("/hearer/{id}", HearerControllerTest.getHearer().getId())
				.then()
				.statusCode(204);
	}

	public static Hearer getHearer() {
		return hearer;
	}

	public static void setHearer(Hearer hearer) {
		HearerControllerTest.hearer = hearer;
	}
}
