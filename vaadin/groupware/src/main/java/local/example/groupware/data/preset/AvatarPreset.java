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

package local.example.groupware.data.preset;

import com.vaadin.flow.spring.annotation.SpringComponent;

import local.example.groupware.data.entity.Role;
import local.example.groupware.data.entity.User;
import local.example.groupware.data.repository.UserRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Collections;

@SpringComponent
public class AvatarPreset {

    @Bean
    public CommandLineRunner loadData(
            PasswordEncoder passwordEncoder,
            UserRepository userRepository
    ) {
        return args -> {
            Logger logger = LoggerFactory.getLogger(getClass());
            if (userRepository.count() != 0L) {
                logger.info("the system will use the users registered in the database");
                return;
            }

            logger.info("no user registered in the system was found...");

            logger.info("generating preset normal user johndoe");
            User normal = new User();
            normal.setName("John Doe");
            normal.setUsername("johndoe");
            normal.setHashedPassword(passwordEncoder.encode("normal"));
            normal.setRoles(Collections.singleton(Role.USER));
            userRepository.save(normal);

            logger.info("generating preset admin user jamesdoe");
            User admin = new User();
            admin.setName("James Doe");
            admin.setUsername("jamesdoe");
            admin.setHashedPassword(passwordEncoder.encode("admin"));
            admin.setRoles(Collections.singleton(Role.ADMIN));
            userRepository.save(admin);
        };
    }
}
