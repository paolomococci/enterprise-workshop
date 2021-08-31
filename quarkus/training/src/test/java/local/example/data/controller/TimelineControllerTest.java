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

import local.example.data.model.Timeline;

@QuarkusTest
@TestMethodOrder(OrderAnnotation.class)
public class TimelineControllerTest {

	private static Timeline timeline;

	@Test
	@Order(1)
	public void readAllEmptyTest() {
		List<Timeline> timelines = RestAssured.given()
				.when().get("/timeline")
				.then()
				.statusCode(200)
				.extract()
				.body()
				.jsonPath()
				.getList(".", Timeline.class);
		Assertions.assertTrue(timelines.isEmpty());
	}

	@Test
	@Order(2)
	public void createTest() {
		TimelineControllerTest.setTimeline(RestAssured.given()
				.when()
				.contentType(ContentType.JSON)
				.body("{\"label\":\"something\"}")
				.post("/timeline")
				.then()
				.statusCode(201)
				.extract()
				.as(Timeline.class));
		Assertions.assertNotNull(TimelineControllerTest.getTimeline().getId());
	}

	@Test
	@Order(3)
	public void readTest() {
		Timeline temporaryTimeline  = RestAssured.given()
				.when()
				.get("/timeline/{id}", TimelineControllerTest.getTimeline().getId())
				.then()
				.statusCode(200)
				.extract()
				.as(Timeline.class);
		Assertions.assertNotNull(temporaryTimeline.getId());
		Assertions.assertTrue(temporaryTimeline.getLabel().contentEquals("something"));
	}

	@Test
	@Order(4)
	public void readAllTest() {
		List<Timeline> timelines = RestAssured.given()
				.when().get("/timeline")
				.then()
				.statusCode(200)
				.extract()
				.body()
				.jsonPath()
				.getList(".", Timeline.class);
		Assertions.assertFalse(timelines.isEmpty());
	}

	@Test
	@Order(5)
	public void updateTest() {
		RestAssured.given()
				.when()
				.contentType(ContentType.JSON)
				.body("{\"label\":\"something else\"}")
				.put("/timeline/{id}", TimelineControllerTest.getTimeline().getId())
				.then()
				.statusCode(204);
		Timeline temporaryTimeline  = RestAssured.given()
				.when()
				.get("/timeline/{id}", TimelineControllerTest.getTimeline().getId())
				.then()
				.statusCode(200)
				.extract()
				.as(Timeline.class);
		Assertions.assertTrue(temporaryTimeline.getLabel().contentEquals("something else"));
	}

	@Test
	@Order(6)
	public void deleteTest() {
		RestAssured.given()
				.when()
				.delete("/timeline/{id}", TimelineControllerTest.getTimeline().getId())
				.then()
				.statusCode(204);
	}

	public static Timeline getTimeline() {
		return timeline;
	}

	public static void setTimeline(Timeline timeline) {
		TimelineControllerTest.timeline = timeline;
	}
}
