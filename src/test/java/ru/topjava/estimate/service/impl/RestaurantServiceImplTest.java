package ru.topjava.estimate.service.impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import ru.topjava.estimate.exeption.NotFoundException;
import ru.topjava.estimate.model.Restaurant;
import ru.topjava.estimate.service.RestaurantService;

import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static ru.topjava.estimate.RestaurantTestData.*;
import static ru.topjava.estimate.VoteTestData.*;

@ExtendWith(SpringExtension.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@SpringBootTest
@Sql(scripts = "classpath:/data.sql")
class RestaurantServiceImplTest {

    @Autowired
    private RestaurantService service;

    @Test
    void save() throws Exception {
        Restaurant newRestaurant = getNewRestaurant();
        Restaurant created = service.save(newRestaurant);
        Long newId = created.getId();
        newRestaurant.setId(newId);
        assertEquals(newRestaurant, created);
    }

    @Test
    void delete() throws Exception {
        Long id = RESTAURANT_1.getId();
        service.delete(id);
        Assertions.assertThrows(NotFoundException.class,
                () -> service.get(id));
    }

    @Test
    void deleteNotFound() throws Exception {
        Assertions.assertThrows(EmptyResultDataAccessException.class,
                () -> service.delete(getNewRestaurantWithId().getId()));
    }

    @Test
    void get() throws Exception {
        RESTAURANT_MATCHER.assertMatch(service.get(RESTAURANT_1.id()), RESTAURANT_1);
    }

    @Test
    void getNotFound() throws Exception {
        Assertions.assertThrows(NotFoundException.class,
                () -> service.get(getNewRestaurantWithId().getId()));
    }

    @Test
    void getAll() throws Exception {
        List<Restaurant> list = service.getAll();
        RESTAURANT_MATCHER.assertMatch(list, LIST_ALL_RESTAURANT);
    }

    @Test
    void getWithVotes() throws Exception {
        Restaurant restaurant = RESTAURANT_1;
        restaurant.setVotes(Set.of(VOTE_1));
        RESTAURANT_WITH_VOTES_MATCHER.assertMatch(restaurant, service.getWithVotes(restaurant.getId()));
    }

//    @Test
//    void getAllWithVotes() throws Exception {
//        Restaurant restaurant1 = RESTAURANT_1;
//        restaurant1.setVotes(Set.of(VOTE_1));
//        Restaurant restaurant2 = RESTAURANT_2;
//        restaurant2.setVotes(Set.of(VOTE_2));
//        Restaurant restaurant3 = RESTAURANT_3;
//        restaurant3.setVotes(Set.of(VOTE_3));
//        List<Restaurant> list = List.of(restaurant1, restaurant2, restaurant3);
//        RESTAURANT_WITH_VOTES_MATCHER.assertMatch(list, service.getAllWithVotes());
//    }
}