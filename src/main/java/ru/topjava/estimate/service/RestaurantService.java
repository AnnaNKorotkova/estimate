package ru.topjava.estimate.service;

import ru.topjava.estimate.model.Restaurant;

import java.util.List;

public interface RestaurantService {

    Restaurant save(Restaurant restaurant);

    void delete(Restaurant restaurant);

    Restaurant getWithVotes(long id);

    Restaurant get(long id);

    List<Restaurant> getAll();

    List<Restaurant> getAllWithVotes();
}
