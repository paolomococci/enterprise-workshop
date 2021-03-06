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

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.response.Response;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import javax.ws.rs.core.MediaType;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;

@QuarkusTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class BookControllerTest {

    @Test
    @Order(value = 1)
    public void testReadAllEndpoint() {
        given()
                .when()
                .get("/books")
                .then()
                .statusCode(200)
                .body(is("[]"));
    }

    @Test
    @Order(value = 2)
    public void testCreateEndpoint() {
        given()
                .body("{\"code\": \"32000004\", \"title\": \"some title\", \"author\":\"John Doe\", \"description\":\"some description\"}")
                .header("Content-Type", MediaType.APPLICATION_JSON)
                .when()
                .post("/books")
                .then()
                .statusCode(201);
    }

    @Test
    @Order(value = 3)
    public void testReadEndpointWithNonExistentIdentifier() {
        given()
                .when()
                .get("/books/100")
                .then()
                .statusCode(404);
    }

    @Test
    @Order(value = 4)
    public void testReadEndpoint() {
        String id;
        Response response;
        response = given()
                .when()
                .get("/books")
                .then()
                .statusCode(200)
                .extract().response();
        id = response.jsonPath().getString("id[0]");
        given()
                .when()
                .get("/books/"+id)
                .then()
                .statusCode(200)
                .body("code", containsString("32000004"));
    }

    @Test
    @Order(value = 5)
    public void testDeleteEndpoint() {
        String id;
        Response response;
        response = given()
                .when()
                .get("/books")
                .then()
                .statusCode(200)
                .extract().response();
        id = response.jsonPath().getString("id[0]");
        given()
                .when()
                .delete("/books/"+id)
                .then()
                .statusCode(204);
    }
}
