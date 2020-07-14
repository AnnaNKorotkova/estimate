package ru.topjava.estimate.service;

import ru.topjava.estimate.model.Dish;
import ru.topjava.estimate.model.MenuItem;
import ru.topjava.estimate.model.Restaurant;

import java.time.LocalDate;
import java.util.List;

public interface MenuItemService {

    MenuItem save(MenuItem price);

    void delete(Long id);

    MenuItem get(Long id);

    List<MenuItem> getAll();

    MenuItem findByRestaurantAndDishAndDate(Restaurant restaurant, Dish dish, LocalDate date);

    List<MenuItem> findAllByRestaurant(Restaurant restaurant);

    List<MenuItem> findAllByRestaurantAndDate(Restaurant restaurant, LocalDate date);
}
