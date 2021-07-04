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

package local.example.staff.controller

import org.junit.jupiter.api.MethodOrderer
import org.junit.jupiter.api.Order
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestMethodOrder
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*
import org.springframework.test.web.servlet.result.MockMvcResultHandlers.print
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.*

@SpringBootTest
@AutoConfigureMockMvc
@TestMethodOrder(MethodOrderer.OrderAnnotation::class)
class EmployeeRestfulControllerTests {

    @Autowired
    private val mockMvc: MockMvc? = null

    private val employee: String = "{\"name\":\"John\",\"surname\":\"Doe\"}"

    @Test
    @Order(1)
    @Throws(Exception::class)
    fun `existence test`() {
        mockMvc!!.perform(get("/api/employees"))
            .andDo(print())
            .andExpect(status().isOk)
            .andExpect(jsonPath("$._links.self.href")
                .exists())
            .andExpect(jsonPath("$._links.self.href")
                .value("http://localhost/api/employees"))
    }

    @Test
    @Order(2)
    @Throws(Exception::class)
    fun `create test`() {
        mockMvc!!.perform(post("/api/employees").content(employee))
            .andExpect(status().isCreated)
    }

    @Test
    @Order(3)
    @Throws(Exception::class)
    fun `read all test`() {
        mockMvc!!.perform(get("/api/employees"))
            .andExpect(status().isOk)
    }

    @Test
    @Order(4)
    @Throws(Exception::class)
    fun `read test`() {
        // TODO
    }

    @Test
    @Order(5)
    @Throws(Exception::class)
    fun `update test`() {
        // TODO
    }

    @Test
    @Order(6)
    @Throws(Exception::class)
    fun `partial update test`() {
        // TODO
    }

    @Test
    @Order(7)
    @Throws(Exception::class)
    fun `delete test`() {
        // TODO
    }

    @Test
    @Order(8)
    @Throws(Exception::class)
    fun `find by path id test`() {
        // TODO
    }

    @Test
    @Order(9)
    @Throws(Exception::class)
    fun `find by name test`() {
        // TODO
    }

    @Test
    @Order(10)
    @Throws(Exception::class)
    fun `find by surname test`() {
        // TODO
    }
}
