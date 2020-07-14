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

    @OneToMany(mappedBy = "restaurant", fetch = FetchType.LAZY)
    @Cascade(value = org.hibernate.annotations.CascadeType.ALL)
    private Set<MenuItem> restaurantPrice;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "restaurant")
    @Cascade(value = org.hibernate.annotations.CascadeType.ALL)
    private Set<Vote> votes;

    public Restaurant(Long id, String name) {
        super(id, name);
    }

    public Restaurant(Long id, String name, Set<MenuItem> price, Set<Vote> votes) {
        this(id, name);
        this.restaurantPrice = price;
        this.votes = votes;
    }

    public Restaurant setAndGetInstance(Restaurant restaurant, Set<MenuItem> price, Set<Vote> votes) {
        return new Restaurant(
                restaurant.getId(),
                restaurant.getName(),
                price,
                votes
        );
    }
}
