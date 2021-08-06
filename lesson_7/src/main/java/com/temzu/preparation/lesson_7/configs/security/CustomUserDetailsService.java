package com.temzu.preparation.lesson_7.configs.security;

import com.temzu.preparation.lesson_7.model.entities.User;
import com.temzu.preparation.lesson_7.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final UserService userService;

    @Override
    public CustomUserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        User user = userService.findByLogin(login);
        return CustomUserDetails.fromUserToCustomUserDetails(user);
    }
}
