package ru.topjava.estimate.to;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class UserRestaurantTo extends NamedTo {


    private Set<UserMenuItemTo> price;

    private int voteCounter;

    private boolean hasVoteToday;

    public UserRestaurantTo(Long id, String name, Set<UserMenuItemTo> price, int voteCounter, boolean hasVoteToday) {
        super(id, name);
        this.price = price;
        this.voteCounter = voteCounter;
        this.hasVoteToday = hasVoteToday;
    }

    public UserRestaurantTo setAndGetInstance(UserRestaurantTo restaurant, boolean hasVoteToday) {
        return new UserRestaurantTo(
                restaurant.getId(),
                restaurant.getName(),
                restaurant.getPrice(),
                restaurant.getVoteCounter(),
                hasVoteToday
        );
    }
}
