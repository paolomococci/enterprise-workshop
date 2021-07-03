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

package local.example.staff.repository

import org.hamcrest.Matchers
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation
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
@TestMethodOrder(OrderAnnotation::class)
class EmployeeRepositoryTests {

    @Autowired
    private val mockMvc: MockMvc? = null

    @Autowired
    private val employeeRepository: EmployeeRepository? = null

    private val employee: String = "{\"name\":\"John\",\"surname\":\"Doe\"}"

    @Test
    @Order(1)
    @Throws(Exception::class)
    fun `verify existence`() {
        mockMvc!!.perform(get("/"))
            .andDo(print())
            .andExpect(status().isOk)
            .andExpect(jsonPath("$._links.employees").exists())
    }

    @Test
    @Order(2)
    @Throws(Exception::class)
    fun `create test`() {
        mockMvc!!.perform(post("/employees").content(employee))
            .andExpect(status().isCreated)
            .andExpect(header().string(
                "Location", Matchers.containsString("employees/"
            )))
    }

    @Test
    @Order(3)
    @Throws(Exception::class)
    fun `read test`() {
        val mvcResult = mockMvc!!.perform(post("/employees").content(employee))
            .andExpect(status().isCreated)
            .andReturn()
        val result = mvcResult.response.getHeader("Location")
        mockMvc.perform(get(result!!))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.name").value("John"))
            .andExpect(jsonPath("$.surname").value("Doe"))
    }

    @Test
    @Order(4)
    @Throws(Exception::class)
    fun `update test`() {
        val mvcResult = mockMvc!!.perform(post("/employees").content(employee))
            .andExpect(status().isCreated)
            .andReturn()
        val result = mvcResult.response.getHeader("Location")
        mockMvc.perform(put(result!!).content("{\"name\":\"Peter\",\"surname\":\"Smith\"}"))
            .andExpect(status().isNoContent)
        mockMvc.perform(get(result))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.name").value("Peter"))
            .andExpect(jsonPath("$.surname").value("Smith"))
    }

    @Test
    @Order(5)
    @Throws(Exception::class)
    fun `partial update test`() {
        val mvcResult = mockMvc!!.perform(post("/employees").content(employee))
            .andExpect(status().isCreated)
            .andReturn()
        val result = mvcResult.response.getHeader("Location")
        mockMvc.perform(patch(result!!).content("{\"name\":\"James\"}"))
            .andExpect(status().isNoContent)
        mockMvc.perform(get(result))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.name").value("James"))
    }

    @Test
    @Order(6)
    @Throws(Exception::class)
    fun `delete test`() {
        val mvcResult = mockMvc!!.perform(post("/employees").content(employee))
            .andExpect(status().isCreated)
            .andReturn()
        val result = mvcResult.response.getHeader("Location")
        mockMvc.perform(delete(result!!)).andExpect(status().isNoContent)
        mockMvc.perform(get(result)).andExpect(status().isNotFound)
    }
}
