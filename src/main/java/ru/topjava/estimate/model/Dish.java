package ru.topjava.estimate.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "dish")
public class Dish extends AbstractNamedEntity {

    @OneToMany(mappedBy = "dish", cascade = CascadeType.ALL)
    private Set<Price> dishPrice;

    public Dish(Long id, String name) {
        super(id, name);
    }
}
