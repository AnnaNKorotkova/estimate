package ru.topjava.estimate.service;

import ru.topjava.estimate.model.Dish;
import ru.topjava.estimate.model.Price;
import ru.topjava.estimate.model.Restaurant;

import java.time.LocalDate;
import java.util.List;

public interface PriceService {

    Price save(Price price);

    void delete(Long id);

    Price get(Long id);

    List<Price> getAll();

    Price findByRestaurantAndDishAndDate(Restaurant restaurant, Dish dish, LocalDate date);

    List<Price> findAllByRestaurant(Restaurant restaurant);

    List<Price> findAllByRestaurantAndDate(Restaurant restaurant, LocalDate date);
}
