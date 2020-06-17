package ru.topjava.estimate.service;

import ru.topjava.estimate.model.Dish;
import ru.topjava.estimate.model.Price;
import ru.topjava.estimate.model.Restaurant;

import java.time.LocalDate;
import java.util.List;

public interface PriceService {

    Price save(Price price);

    void delete(Price price);

    Price get(long id);

    Price findByDateAndDishAndRestaurant(LocalDate date, Dish dish, Restaurant restaurant);

    List<Price> findAllByRestaurant(Restaurant restaurant);

    List<Price> findAllByDateAndRestaurant(LocalDate date, Restaurant restaurant);
}