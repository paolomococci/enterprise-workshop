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
import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.RestAssured;

import local.example.data.model.Audience;

@QuarkusTest
public class AudienceControllerTest {

	@Test
	public void create() {
		// TODO
	}

	@Test
	public void read() {
		// TODO
	}

	@Test
	public void readAll() {
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
	public void update() {
		// TODO
	}

	@Test
	public void delete() {
		// TODO
	}
}
