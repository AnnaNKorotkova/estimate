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

    Price findByDateAndDishAndRestaurant(LocalDate date, Dish dish, Restaurant restaurant);

    List<Price> findAllByRestaurant(Restaurant restaurant);

    List<Price> findAllByDateAndRestaurant(LocalDate date, Restaurant restaurant);
}
