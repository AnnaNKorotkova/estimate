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
public class Restaurant extends AbstractNamedEntity {
    private final Set<Lunch> lunches;

    public Restaurant(Long id, String name, Set<Lunch> lunches) {
        super(id, name);
        this.lunches = lunches;
    }
}
