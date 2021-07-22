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

package local.example.users.data.security.auth;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.server.VaadinServletRequest;

import local.example.users.data.entity.User;
import local.example.users.data.repository.UserRepository;
import local.example.users.data.security.conf.UserConf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserAuth {

    @Autowired
    private UserRepository userRepository;

    private UserDetails getUserAuth() {
        SecurityContext securityContext = SecurityContextHolder.getContext();
        Object principalAuthenticationFromSecurityContext = securityContext.getAuthentication().getPrincipal();
        if (principalAuthenticationFromSecurityContext instanceof UserDetails) {
            UserDetails userDetails = (UserDetails) securityContext.getAuthentication().getPrincipal();
            return userDetails;
        }
        return null;
    }

    public Optional<User> get() {
        UserDetails userDetail = getUserAuth();
        if (userDetail == null) {
            return Optional.empty();
        }
        return Optional.of(userRepository.findByUsername(userDetail.getUsername()));
    }

    public void logout() {
        UI.getCurrent().getPage().setLocation(UserConf.LOGOUT_URL);
        SecurityContextLogoutHandler securityContextLogoutHandler = new SecurityContextLogoutHandler();
        securityContextLogoutHandler.logout(
                VaadinServletRequest.getCurrent().getHttpServletRequest(),
                null,
                null
        );
    }
}
