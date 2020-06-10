package ru.topjava.estimate.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class User extends AbstractNamedEntity {

    private final String email;
    private final String password;
    private final Set<Role> roles;
    private final Set<Vote> votes;

    public User(Long id, String name, String email, String password, Set<Role> roles, Set<Vote> votes) {
        super(id, name);
        this.email = email;
        this.password = password;
        this.roles = roles;
        this.votes = votes;
    }
}
