package ru.topjava.estimate.security;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.topjava.estimate.model.User;
import ru.topjava.estimate.security.jwt.JwtUser;
import ru.topjava.estimate.security.jwt.JwtUserFactory;
import ru.topjava.estimate.service.UserService;

@Service
@Slf4j
public class JwtUserDetailsService implements UserDetailsService {

    private final UserService userService;

    @Autowired
    public JwtUserDetailsService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
//        User user = userService.findByUsername(username);
        User user = userService.findByEmail(email);

        if (user == null) {
            throw new UsernameNotFoundException("User with username: " + email + " not found");
        }

        JwtUser jwtUser = JwtUserFactory.create(user);
        log.info("IN loadUserByUsername - user with username: {} successfully loaded", email);
        return jwtUser;
    }
}
