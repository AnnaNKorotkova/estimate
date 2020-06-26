package ru.topjava.estimate.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Cascade;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "restaurant")
public class Restaurant extends AbstractNamedEntity {

    @OneToMany(mappedBy = "restaurant", fetch = FetchType.LAZY, orphanRemoval = true)
    @Cascade(value = org.hibernate.annotations.CascadeType.ALL)
    private Set<Price> restaurantPrice;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "restaurant")
    @Cascade(value = org.hibernate.annotations.CascadeType.ALL)
    private Set<Vote> votes;

    public Restaurant(Long id, String name) {
        super(id, name);
    }

    public Restaurant(Long id, String name, Set<Price> price, Set<Vote> votes) {
        this(id, name);
        this.restaurantPrice = price;
        this.votes = votes;
    }

    public Restaurant setAndGetInstance(Restaurant restaurant, Set<Price> price) {
        return new Restaurant(
                restaurant.getId(),
                restaurant.getName(),
                price,
                restaurant.getVotes()
        );
    }
}
