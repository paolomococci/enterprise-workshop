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

package local.example.resource;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import io.restassured.response.Response;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

@QuarkusTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class OwnerResourceTest {

    @Test
    @Order(value = 1)
    public void testOwnerResourceEndpoint() {
        given()
                .when()
                .get("/rest-owner/owners")
                .then()
                .statusCode(200)
                .body(is("[]"));
    }

    @Test
    @Order(value = 2)
    public void testCreateOwnerResourceEndpoint() {
        given()
                .contentType("application/json")
                .body("{\"name\":\"John\"}")
                .when()
                .post("/rest-owner")
                .then()
                .statusCode(201);
    }

    @Test
    @Order(value = 3)
    public void testReadOwnerResourceEndpointWithNonExistentIdentifier() {
        given()
                .when()
                .get("/rest-owner/100")
                .then()
                .statusCode(404);
    }

    @Test
    @Order(value = 4)
    public void testReadOwnerResourceEndpoint() {
        Response response;
        response = given()
                .when()
                .get("/rest-owner/owners")
                .then()
                .statusCode(200)
                .extract().response();
        System.out.println("--- response ---");
        System.out.println(response.body().prettyPrint());
        System.out.println(response.jsonPath().getString("id[0]"));
        System.out.println("--- response ---");
    }

    @Test
    @Order(value = 5)
    public void testReadOwnerResourceEndpointFromIdentifier() {
        String id;
        Response response;
        response = given()
                .when()
                .get("/rest-owner/owners")
                .then()
                .statusCode(200)
                .extract().response();
        id = response.jsonPath().getString("id[0]");
        given()
                .when()
                .get("/rest-owner/"+id)
                .then()
                .statusCode(200)
                .body("name", containsString("John"));
    }

    @Test
    @Order(value = 6)
    public void testUpdateOwnerResourceEndpoint() {
        String id;
        Response response;
        response = given()
                .when()
                .get("/rest-owner/owners")
                .then()
                .statusCode(200)
                .extract().response();
        id = response.jsonPath().getString("id[0]");
        given()
                .contentType("application/json")
                .body("{\"name\":\"James\"}")
                .when()
                .put("/rest-owner/"+id)
                .then()
                .statusCode(205);
    }

    @Test
    @Order(value = 7)
    public void testReadOwnerResourceEndpointFromIdentifierAfterUpdated() {
        String id;
        Response response;
        response = given()
                .when()
                .get("/rest-owner/owners")
                .then()
                .statusCode(200)
                .extract().response();
        id = response.jsonPath().getString("id[0]");
        given()
                .when()
                .get("/rest-owner/"+id)
                .then()
                .statusCode(200)
                .body("name", containsString("James"));
    }

    @Test
    @Order(value = 8)
    public void testDeleteOwnerResourceEndpoint() {
        String id;
        Response response;
        response = given()
                .when()
                .get("/rest-owner/owners")
                .then()
                .statusCode(200)
                .extract().response();
        id = response.jsonPath().getString("id[0]");
        given()
                .when()
                .delete("/rest-owner/"+id)
                .then()
                .statusCode(204);
    }
}
