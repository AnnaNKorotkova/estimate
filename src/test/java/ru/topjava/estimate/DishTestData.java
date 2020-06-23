package ru.topjava.estimate;

import ru.topjava.estimate.model.Dish;

import java.util.List;

public class DishTestData {

    public static TestMatcher<Dish> DISH_MATCHER = TestMatcher.usingFieldsComparator(Dish.class, "dishPrice");
    public static TestMatcher<Dish> DISH_MATCHER_NO_IGNORE = TestMatcher.usingEquals(Dish.class);

    public static final Dish DISH_1 = new Dish(100000005L, "Cesar");
    public static final Dish DISH_2 = new Dish(100000006L, "Jamon");
    public static final Dish DISH_3 = new Dish(100000007L, "Pescado");
    public static final Dish DISH_4 = new Dish(100000008L, "Greece salad");
    public static final Dish DISH_5 = new Dish(100000009L, "Pasta");
    public static final Dish DISH_6 = new Dish(100000010L, "Pizza");
    public static final Dish DISH_7 = new Dish(100000011L, "Peking duck");
    public static final Dish DISH_8 = new Dish(100000012L, "Rice");
    public static final Dish DISH_9 = new Dish(100000013L, "Piance");
    public static final Dish DISH_10 = new Dish(100000014L, "Kimchi");
    public static final Dish DISH_11 = new Dish(100000015L, "Fruit salad");
    public static final Dish DISH_12 = new Dish(100000016L, "Fried shrimps");
    public static final Dish DISH_13 = new Dish(100000017L, "Steak ribeye");
    public static final Dish DISH_14 = new Dish(100000018L, "Beans");
    public static final Dish DISH_15 = new Dish(100000019L, "Guacamole");
    public static final Dish DISH_16 = new Dish(100000020L, "Burrito");
    public static final Dish DISH_17 = new Dish(100000021L, "Burger");
    public static final Dish DISH_18 = new Dish(100000022L, "Coffee");

    public static List<Dish> ALL_DISHES = List.of(DISH_1, DISH_2, DISH_3, DISH_4, DISH_5, DISH_6, DISH_7, DISH_8,
            DISH_9, DISH_10, DISH_11, DISH_12, DISH_13, DISH_14, DISH_15, DISH_16, DISH_17, DISH_18);

    public static Dish getNewDish() {
        return new Dish(null, "Cheesecake");
    }

    public static Dish getNewDishWithId() {
        return new Dish(99999999L, "Cheesecake");
    }

}
