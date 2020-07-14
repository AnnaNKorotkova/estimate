package ru.topjava.estimate.service;

import ru.topjava.estimate.model.Restaurant;
import ru.topjava.estimate.model.User;
import ru.topjava.estimate.model.Vote;

import java.time.LocalDate;
import java.util.List;

public interface VoteService {

    Vote save(Vote vote);

    void delete(Long id);

    Vote get(Long id);

    List<Vote> getAll();

    List<Vote> getAllByUser(User user);

    List<Vote> findAllByRestaurantAndDate(Restaurant restaurant, LocalDate date);

    Vote findByUserAndDate(User user, LocalDate date);

    String vote(Long restaurantId, User user, String votingEndTime);
}
