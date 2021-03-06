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

package local.example.likelihood;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class MaxLikelihoodEstimationTest {

    @Test
    public void simpleEndpointTest() {
        given()
          .when().get("/likelihood")
          .then()
             .statusCode(200)
             .body(is("Max Likelihood Estimation, response example in TEXT_PLAIN"));
    }

    @Test
    public void injectedStringPathParamEndpointTest() {
        given()
          .when().get("/likelihood/injected_string")
          .then()
             .statusCode(200)
             .body(is("injected value: injected_string"));
    }
}
