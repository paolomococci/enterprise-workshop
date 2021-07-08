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

package local.example.family.configuration

import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer
import com.fasterxml.jackson.datatype.jsr310.deser.LocalTimeDeserializer
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer
import com.fasterxml.jackson.datatype.jsr310.ser.LocalTimeSerializer
import org.springframework.boot.autoconfigure.AutoConfigureBefore
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer
import org.springframework.boot.autoconfigure.jackson.JacksonAutoConfiguration
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.time.format.DateTimeFormatter

@Configuration
@AutoConfigureBefore(JacksonAutoConfiguration::class)
class DatetimeAutoConfiguration {
    @Bean
    fun jackson2ObjectMapperBuilderCustomizer(): Jackson2ObjectMapperBuilderCustomizer {
        return Jackson2ObjectMapperBuilderCustomizer { jacksonObjectMapperBuilder ->
            val dateFormat = "dd-MMM-yyyy"
            val timeFormat = "hh:mm:ss a"
            val dateTimeFormat = "dd-MMM-yyyy hh:mm:ss a"
            jacksonObjectMapperBuilder
                .serializers(LocalDateSerializer(DateTimeFormatter.ofPattern(dateFormat)))
                .deserializers(LocalDateDeserializer(DateTimeFormatter.ofPattern(dateFormat)))
                .serializers(LocalTimeSerializer(DateTimeFormatter.ofPattern(timeFormat)))
                .deserializers(LocalTimeDeserializer(DateTimeFormatter.ofPattern(timeFormat)))
                .serializers(LocalDateTimeSerializer(DateTimeFormatter.ofPattern(dateTimeFormat)))
                .deserializers(LocalDateTimeDeserializer(DateTimeFormatter.ofPattern(dateTimeFormat)))
        }
    }
}
