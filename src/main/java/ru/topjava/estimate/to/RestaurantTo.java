package ru.topjava.estimate.to;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;


@Getter
@Setter
@NoArgsConstructor
public class RestaurantTo extends NameTo {

    private Set<DishTo> dishToSet;

    private int voteCounter;

    private boolean hasUserVoeToday;
}
