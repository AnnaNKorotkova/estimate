package ru.topjava.estimate;

import ru.topjava.estimate.model.Restaurant;

import java.util.List;

public class RestaurantTestData {

    public static TestMatcher<Restaurant> RESTAURANT_MATCHER = TestMatcher.usingFieldsComparator(Restaurant.class, "votes", "restaurantPrice");
    public static TestMatcher<Restaurant> RESTAURANT_WITH_VOTES_MATCHER = TestMatcher.usingFieldsComparator(Restaurant.class, "restaurantPrice");
    public static TestMatcher<Restaurant> RESTAURANT_MATCHER_NO_IGNORE = TestMatcher.usingEquals(Restaurant.class);

    public final static Restaurant RESTAURANT_1 = new Restaurant(100000002L, "Barcelona");
    public final static Restaurant RESTAURANT_2 = new Restaurant(100000003L, "Bangkok");
    public final static Restaurant RESTAURANT_3 = new Restaurant(100000004L, "Austin");

    public static Restaurant getNewRestaurant() {
        return new Restaurant(null, "Русский");
    }
    public static Restaurant getNewRestaurantWithId() {
        return new Restaurant(888888L, "Русский");
    }

    public final static List<Restaurant> LIST_ALL_RESTAURANT = List.of(RESTAURANT_1, RESTAURANT_2, RESTAURANT_3);

}
