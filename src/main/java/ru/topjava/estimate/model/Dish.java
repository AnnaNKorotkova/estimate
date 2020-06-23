package ru.topjava.estimate.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "dish")
public class Dish extends AbstractNamedEntity {

    @OneToMany(mappedBy = "dish", fetch = FetchType.LAZY, orphanRemoval = true)
    @Cascade(value = org.hibernate.annotations.CascadeType.ALL)
    private Set<Price> dishPrice;

    public Dish(Long id, String name) {
        super(id, name);
    }
}
