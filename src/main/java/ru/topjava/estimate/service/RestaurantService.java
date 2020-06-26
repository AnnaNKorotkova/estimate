package ru.topjava.estimate.service;

import ru.topjava.estimate.model.Restaurant;

import java.util.List;

public interface RestaurantService {

    Restaurant save(Restaurant restaurant);

    void delete(Long id);

    Restaurant getWithVotes(Long id);

    Restaurant get(Long id);

    List<Restaurant> getAll();
//
//    List<Restaurant> getAllWithVotes();
//
//    List<Restaurant> getAllWithPriceAndVotes();

}
