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

import local.example.data.model.Tutor;

@QuarkusTest
@TestMethodOrder(OrderAnnotation.class)
public class TutorControllerTest {

	private static Tutor tutor;

	@Test
	@Order(1)
	public void readAllEmptyTest() {
		List<Tutor> tutors = RestAssured.given()
				.when().get("/tutor")
				.then()
				.statusCode(200)
				.extract()
				.body()
				.jsonPath()
				.getList(".", Tutor.class);
		Assertions.assertTrue(tutors.isEmpty());
	}

	@Test
	@Order(2)
	public void createTest() {
		TutorControllerTest.setTutor(RestAssured.given()
				.when()
				.contentType(ContentType.JSON)
				.body("{\"name\":\"somebody\"}")
				.post("/tutor")
				.then()
				.statusCode(201)
				.extract()
				.as(Tutor.class));
		Assertions.assertNotNull(TutorControllerTest.getTutor().getId());
	}

	@Test
	@Order(3)
	public void readTest() {
		Tutor temporaryTutor  = RestAssured.given()
				.when()
				.get("/tutor/{id}", TutorControllerTest.getTutor().getId())
				.then()
				.statusCode(200)
				.extract()
				.as(Tutor.class);
		Assertions.assertNotNull(temporaryTutor.getId());
		Assertions.assertTrue(temporaryTutor.getName().contentEquals("somebody"));
	}

	@Test
	@Order(4)
	public void readAllTest() {
		List<Tutor> tutors = RestAssured.given()
				.when().get("/tutor")
				.then()
				.statusCode(200)
				.extract()
				.body()
				.jsonPath()
				.getList(".", Tutor.class);
		Assertions.assertFalse(tutors.isEmpty());
	}

	@Test
	@Order(5)
	public void updateTest() {
		RestAssured.given()
				.when()
				.contentType(ContentType.JSON)
				.body("{\"name\":\"something else\"}")
				.put("/tutor/{id}", TutorControllerTest.getTutor().getId())
				.then()
				.statusCode(204);
		Tutor temporaryTutor  = RestAssured.given()
				.when()
				.get("/tutor/{id}", TutorControllerTest.getTutor().getId())
				.then()
				.statusCode(200)
				.extract()
				.as(Tutor.class);
		Assertions.assertTrue(temporaryTutor.getName().contentEquals("something else"));
	}

	@Test
	@Order(6)
	public void deleteTest() {
		RestAssured.given()
				.when()
				.delete("/tutor/{id}", TutorControllerTest.getTutor().getId())
				.then()
				.statusCode(204);
	}

	public static Tutor getTutor() {
		return tutor;
	}

	public static void setTutor(Tutor tutor) {
		TutorControllerTest.tutor = tutor;
	}
}
