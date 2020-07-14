package ru.topjava.estimate.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.EnumSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "user", uniqueConstraints = {@UniqueConstraint(columnNames = {"email"}, name = "users_unique_email_idx")})
public class User extends AbstractNamedEntity {

    @Column(name = "email", nullable = false, unique = true)
    @Email
    @NotBlank
    @Size(max = 100)
    private String email;

    @Column(name = "password", nullable = false)
    @NotBlank
    @Size(min = 5, max = 100)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "role", joinColumns = @JoinColumn(name = "user_id"),
            uniqueConstraints = {@UniqueConstraint(columnNames = {"user_id", "role"}, name = "user_roles_unique_idx")})
    @Column(name = "role")
    @ElementCollection(fetch = FetchType.EAGER)
    private Set<Role> roles;

    public User(Long id, String name, String email, String password) {
        super(id, name);
        this.email = email;
        this.password = password;
    }

    public User(Long id, String name, String email, String password, Role role, Role... roles) {
        this(id, name, email, password);
        this.roles = EnumSet.of(role, roles);
    }
}
