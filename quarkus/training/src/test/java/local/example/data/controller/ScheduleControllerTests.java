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

import local.example.data.model.Schedule;

@QuarkusTest
@TestMethodOrder(OrderAnnotation.class)
public class ScheduleControllerTests {

	private static Schedule schedule;

	@Test
	@Order(1)
	public void readAllEmptyTest() {
		List<Schedule> schedules = RestAssured.given()
				.when().get("/schedule")
				.then()
				.statusCode(200)
				.extract()
				.body()
				.jsonPath()
				.getList(".", Schedule.class);
		Assertions.assertTrue(schedules.isEmpty());
	}

	@Test
	@Order(2)
	public void createTest() {
		ScheduleControllerTests.setSchedule(RestAssured.given()
				.when()
				.contentType(ContentType.JSON)
				.body("{\"name\":\"something\"}")
				.post("/schedule")
				.then()
				.statusCode(201)
				.extract()
				.as(Schedule.class));
		Assertions.assertNotNull(ScheduleControllerTests.getSchedule().getId());
	}

	@Test
	@Order(3)
	public void readTest() {
		Schedule temporarySchedule  = RestAssured.given()
				.when()
				.get("/schedule/{id}", ScheduleControllerTests.getSchedule().getId())
				.then()
				.statusCode(200)
				.extract()
				.as(Schedule.class);
		Assertions.assertNotNull(temporarySchedule.getId());
		Assertions.assertTrue(temporarySchedule.getName().contentEquals("something"));
	}

	@Test
	@Order(4)
	public void readAllTest() {
		List<Schedule> schedules = RestAssured.given()
				.when().get("/schedule")
				.then()
				.statusCode(200)
				.extract()
				.body()
				.jsonPath()
				.getList(".", Schedule.class);
		Assertions.assertFalse(schedules.isEmpty());
	}

	@Test
	@Order(5)
	public void updateTest() {
		RestAssured.given()
				.when()
				.contentType(ContentType.JSON)
				.body("{\"name\":\"something else\"}")
				.put("/schedule/{id}", ScheduleControllerTests.getSchedule().getId())
				.then()
				.statusCode(204);
		Schedule temporarySchedule  = RestAssured.given()
				.when()
				.get("/schedule/{id}", ScheduleControllerTests.getSchedule().getId())
				.then()
				.statusCode(200)
				.extract()
				.as(Schedule.class);
		Assertions.assertTrue(temporarySchedule.getName().contentEquals("something else"));
	}

	@Test
	@Order(6)
	public void deleteTest() {
		RestAssured.given()
				.when()
				.delete("/schedule/{id}", ScheduleControllerTests.getSchedule().getId())
				.then()
				.statusCode(204);
	}

	public static Schedule getSchedule() {
		return schedule;
	}

	public static void setSchedule(Schedule schedule) {
		ScheduleControllerTests.schedule = schedule;
	}
}
