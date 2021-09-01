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
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import local.example.data.model.Tutorial;

@QuarkusTest
@TestMethodOrder(OrderAnnotation.class)
public class TutorialControllerTests {

	private static Tutorial tutorial;

	@Test
	@Order(1)
	public void readAllEmptyTest() {
		List<Tutorial> tutorials = RestAssured.given()
				.when().get("/tutorial")
				.then()
				.statusCode(200)
				.extract()
				.body()
				.jsonPath()
				.getList(".", Tutorial.class);
		Assertions.assertTrue(tutorials.isEmpty());
	}

	@Test
	@Order(2)
	public void createTest() {
		TutorialControllerTests.setTutorial(RestAssured.given()
				.when()
				.contentType(ContentType.JSON)
				.body("{\"title\":\"some title\"}")
				.post("/tutorial")
				.then()
				.statusCode(201)
				.extract()
				.as(Tutorial.class));
		Assertions.assertNotNull(TutorialControllerTests.getTutorial().getId());
	}

	@Test
	@Order(3)
	public void readTest() {
		Tutorial temporaryTutorial  = RestAssured.given()
				.when()
				.get("/tutorial/{id}", TutorialControllerTests.getTutorial().getId())
				.then()
				.statusCode(200)
				.extract()
				.as(Tutorial.class);
		Assertions.assertNotNull(temporaryTutorial.getId());
		Assertions.assertTrue(temporaryTutorial.getTitle().contentEquals("some title"));
	}

	@Test
	@Order(4)
	public void readAllTest() {
		List<Tutorial> tutorials = RestAssured.given()
				.when().get("/tutorial")
				.then()
				.statusCode(200)
				.extract()
				.body()
				.jsonPath()
				.getList(".", Tutorial.class);
		Assertions.assertFalse(tutorials.isEmpty());
	}

	@Test
	@Order(5)
	public void updateTest() {
		RestAssured.given()
				.when()
				.contentType(ContentType.JSON)
				.body("{\"title\":\"some other title\"}")
				.put("/tutorial/{id}", TutorialControllerTests.getTutorial().getId())
				.then()
				.statusCode(204);
		Tutorial temporaryTutorial  = RestAssured.given()
				.when()
				.get("/tutorial/{id}", TutorialControllerTests.getTutorial().getId())
				.then()
				.statusCode(200)
				.extract()
				.as(Tutorial.class);
		Assertions.assertTrue(temporaryTutorial.getTitle().contentEquals("some other title"));
	}

	@Test
	@Order(6)
	public void deleteTest() {
		RestAssured.given()
				.when()
				.delete("/tutorial/{id}", TutorialControllerTests.getTutorial().getId())
				.then()
				.statusCode(204);
	}

	public static Tutorial getTutorial() {
		return tutorial;
	}

	public static void setTutorial(Tutorial tutorial) {
		TutorialControllerTests.tutorial = tutorial;
	}
}
