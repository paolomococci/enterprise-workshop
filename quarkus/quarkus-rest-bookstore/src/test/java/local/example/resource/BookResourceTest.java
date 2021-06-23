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

import javax.ws.rs.core.MediaType;

import static io.restassured.RestAssured.given;

@QuarkusTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class BookResourceTest {

    @Test
    @Order(value = 1)
    public void testReadAllEndpoint() {
        given()
                .when()
                .get("/books")
                .then()
                .statusCode(200);
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
    public void testDeleteAllEndpoint() {

    }
}
