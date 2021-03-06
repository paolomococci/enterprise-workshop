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

package local.example;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class GreetingResourceTest {

    @Test
    public void testHelloEndpoint() {
        given()
          .when()
          .get("/resteasy")
          .then()
          .statusCode(200)
          .body(is("Hello from quarkus-restful-pet-clinic application"));
    }

    @Test
    public void testGreetingEndpoint() {
        given()
           .when()
           .get("/greeting/test")
           .then()
           .statusCode(200)
           .body(is("Hello test!"));
    }

    @Test
    public void testGreetingParameterizedEndpoint() {
        String arg = UUID.randomUUID().toString();
        given()
            .pathParam("arg", arg)
            .when()
            .get("/greeting/{arg}")
            .then()
            .statusCode(200)
            .body(is("Hello " + arg + "!"));
    }
}
