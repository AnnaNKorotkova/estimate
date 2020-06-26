package ru.topjava.estimate.security.jwt;

import ru.topjava.estimate.model.Role;
//import net.proselyte.jwtappdemo.model.Status;
import ru.topjava.estimate.model.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import ru.topjava.estimate.security.jwt.JwtUser;

import java.sql.Date;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public final class JwtUserFactory {

    public JwtUserFactory() {
    }

    public static JwtUser create(User user) {
        return new JwtUser(
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getPassword(),
                mapToGrantedAuthorities(new ArrayList<>(user.getRoles()))
//                user.getStatus().equals(Status.ACTIVE)
//                user.getUpdated()
        );
    }

    private static List<GrantedAuthority> mapToGrantedAuthorities(List<Role> userRoles) {
        return userRoles.stream()
                .map(role ->
//                        new SimpleGrantedAuthority(role.getName())
                        new SimpleGrantedAuthority(role.getAuthority())
                ).collect(Collectors.toList());
    }
}
