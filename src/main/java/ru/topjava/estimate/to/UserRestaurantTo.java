package ru.topjava.estimate.to;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class UserRestaurantTo extends NamedTo {

//    private Set<DishTo> dishToSet;

    private Set<UserPriceTo> price;

    private int voteCounter;

    private boolean hasVoteToday;

    public UserRestaurantTo(Long id, String name, Set<UserPriceTo> price, int voteCounter, boolean hasVoteToday) {
        super(id, name);
        this.price = price;
        this.voteCounter = voteCounter;
        this.hasVoteToday = hasVoteToday;
    }
//
//    public RestaurantTo setAndGet(RestaurantTo restaurant, Set<PriceTo> price) {
//        return new RestaurantTo(
//                restaurant.getId(),
//                restaurant.getName(),
//                price,
//                restaurant.getVoteCounter(),
//                restaurant.isHasVoteToday()
//        );
//    }

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
