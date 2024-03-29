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
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import local.example.data.model.Audience;

@QuarkusTest
@TestMethodOrder(OrderAnnotation.class)
public class AudienceControllerTests {

	private static Audience audience;

	@Test
	@Order(1)
	@Disabled
	public void readAllEmptyTest() {
		List<Audience> audiences = RestAssured.given()
				.when().get("/audience")
				.then()
				.statusCode(200)
				.extract()
				.body()
				.jsonPath()
				.getList(".", Audience.class);
		Assertions.assertTrue(audiences.isEmpty());
	}

	@Test
	@Order(2)
	public void createTest() {
		AudienceControllerTests.setAudience(RestAssured.given()
				.when()
				.contentType(ContentType.JSON)
				.body("{\"name\":\"something\"}")
				.post("/audience")
				.then()
				.statusCode(201)
				.extract()
				.as(Audience.class));
		Assertions.assertNotNull(AudienceControllerTests.getAudience().getId());
	}

	@Test
	@Order(3)
	public void readTest() {
		Audience temporaryAudience  = RestAssured.given()
				.when()
				.get("/audience/{id}", AudienceControllerTests.getAudience().getId())
				.then()
				.statusCode(200)
				.extract()
				.as(Audience.class);
		Assertions.assertNotNull(temporaryAudience.getId());
		Assertions.assertTrue(temporaryAudience.getName().contentEquals("something"));
	}

	@Test
	@Order(4)
	public void readAllTest() {
		List<Audience> audiences = RestAssured.given()
				.when().get("/audience")
				.then()
				.statusCode(200)
				.extract()
				.body()
				.jsonPath()
				.getList(".", Audience.class);
		Assertions.assertFalse(audiences.isEmpty());
	}

	@Test
	@Order(5)
	public void updateTest() {
		RestAssured.given()
				.when()
				.contentType(ContentType.JSON)
				.body("{\"name\":\"something else\"}")
				.put("/audience/{id}", AudienceControllerTests.getAudience().getId())
				.then()
				.statusCode(204);
		Audience temporaryAudience  = RestAssured.given()
				.when()
				.get("/audience/{id}", AudienceControllerTests.getAudience().getId())
				.then()
				.statusCode(200)
				.extract()
				.as(Audience.class);
		Assertions.assertTrue(temporaryAudience.getName().contentEquals("something else"));
	}

	@Test
	@Order(6)
	public void deleteTest() {
		RestAssured.given()
				.when()
				.delete("/audience/{id}", AudienceControllerTests.getAudience().getId())
				.then()
				.statusCode(204);
	}

	protected static Audience getAudience() {
		return audience;
	}

	protected static void setAudience(Audience audience) {
		AudienceControllerTests.audience = audience;
	}
}
