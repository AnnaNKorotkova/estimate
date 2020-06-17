package ru.topjava.estimate.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "restaurant")
public class Restaurant extends AbstractNamedEntity {

    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL)
    private Set<Price> restaurantPrice;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "restaurant")
    private Set<Vote> votes;


    public Restaurant(Long id, String name) {
        super(id, name);
    }
}
