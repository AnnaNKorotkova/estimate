package ru.topjava.estimate.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Lunch extends AbstractNamedEntity {
    private final Date date;
    private final List<Dish> menu;
    private final Set<Vote> votes;
    private final Long restaurantId;

    protected Lunch(Long id, String name, Date date, List<Dish> menu, Set<Vote> votes, Long restaurantId) {
        super(id, name);
        this.date = date;
        this.menu = menu;
        this.votes = votes;
        this.restaurantId = restaurantId;
    }
}
