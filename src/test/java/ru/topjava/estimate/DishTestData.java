package ru.topjava.estimate;

import ru.topjava.estimate.model.Dish;

public class DishTestData {
    private static final Dish DISH_1 = new Dish(100000005L, "Cesar");
    private static final Dish DISH_2 = new Dish(100000006L, "Jamon");
    private static final Dish DISH_3 = new Dish(100000007L, "Pescado");
    private static final Dish DISH_4 = new Dish(100000008L, "Greece salad");
    private static final Dish DISH_5 = new Dish(100000009L, "Pasta");
    private static final Dish DISH_6 = new Dish(100000010L, "Pizza");
    private static final Dish DISH_7 = new Dish(100000011L, "Peking duck");
    private static final Dish DISH_8 = new Dish(100000012L, "Rice");
    private static final Dish DISH_9 = new Dish(100000013L, "Piance");
    private static final Dish DISH_10 = new Dish(100000014L, "Kimchi");
    private static final Dish DISH_11 = new Dish(100000015L, "Fruit salad");
    private static final Dish DISH_12 = new Dish(100000016L, "Fried shrimps");
    private static final Dish DISH_13 = new Dish(100000017L, "Steak ribeye");
    private static final Dish DISH_14 = new Dish(100000018L, "Beans");
    private static final Dish DISH_15 = new Dish(100000019L, "Guacamole");
    private static final Dish DISH_16 = new Dish(100000020L, "Burrito");
    private static final Dish DISH_17 = new Dish(100000021L, "Burger");
    private static final Dish DISH_18 = new Dish(100000022L, "Coffee");

    public static Dish getNewDish() {
        return new Dish(null, "Cheesecake");
    }

}
