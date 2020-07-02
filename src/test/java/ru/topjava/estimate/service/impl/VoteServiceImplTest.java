package ru.topjava.estimate.service.impl;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;
import ru.topjava.estimate.exeption.NotFoundException;
import ru.topjava.estimate.model.Vote;
import ru.topjava.estimate.service.VoteService;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static ru.topjava.estimate.RestaurantTestData.RESTAURANT_1;
import static ru.topjava.estimate.RestaurantTestData.RESTAURANT_2;
import static ru.topjava.estimate.UserTestData.ADMIN;
import static ru.topjava.estimate.UserTestData.USER;
import static ru.topjava.estimate.VoteTestData.*;

@ExtendWith(SpringExtension.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@SpringBootTest
@Sql(scripts = "classpath:/data.sql")
class VoteServiceImplTest {

    @Autowired
    private VoteService service;

    @Autowired
    private CacheManager cacheManager;

    @Test
    void create() throws Exception {
        Vote newVote = getNewVote();
        newVote.setRestaurant(RESTAURANT_1);
        newVote.setUser(USER);
        Vote created = service.save(newVote);
        Long newId = created.getId();
        newVote.setId(newId);
        assertEquals(newVote, created);
    }

    @Test
    void delete() throws Exception {
        Long id = VOTE_1.getId();
        service.delete(id);
        Assertions.assertThrows(NotFoundException.class,
                () -> service.get(id));
    }

    @Test
    void deleteNotfound() throws Exception {
        Assertions.assertThrows(EmptyResultDataAccessException.class,
                () -> service.delete(getNewVoteWithID().getId()));
    }

    @Test
    @Transactional
    void get() throws Exception {
        VOTE_1.setUser(USER);
        VOTE_1.setRestaurant(RESTAURANT_1);
        VOTE_MATCHER.assertMatch(service.get(VOTE_1.id()), VOTE_1);
    }

    @Test
    @Transactional
    void getNotFound() throws Exception {
        Assertions.assertThrows(NotFoundException.class,
                () -> service.get(getNewVoteWithID().getId()));
    }

    @Test
    void getAll() throws Exception {
        Vote newVote = getNewVote();
        newVote.setUser(ADMIN);
        newVote.setRestaurant(RESTAURANT_2);
        service.save(newVote);
        List<Vote> list = new ArrayList<>(ALL_VOTES);
        list.add(newVote);
        VOTE_MATCHER_NO_FIELDS_IGNORE.assertMatch(service.getAll(), list);
    }

    @Test
    void getAllByUser() throws Exception {
        VOTE_MATCHER_NO_FIELDS_IGNORE.assertMatch(service.getAllByUser(USER), ALL_VOTES);
    }

    @Test
    void findAllByRestaurantAndDate() throws Exception {
        List<Vote> list = service.findAllByRestaurantAndDate(RESTAURANT_2, DATE_2);
        VOTE_MATCHER_NO_FIELDS_IGNORE.assertMatch(list, List.of(VOTE_2));
    }

    @Test
    void notFoundByRestaurantAndDate() throws Exception { ;
        Assertions.assertEquals(service.findAllByRestaurantAndDate(RESTAURANT_1, DATE_2), List.of());
    }

    @Test
    void findByUserAndDate() throws Exception {
        VOTE_MATCHER_NO_FIELDS_IGNORE.assertMatch(service.findByUserAndDate(USER, DATE_3), VOTE_3);
    }

    @Test
    void notFoundByUserAndDate() throws Exception {
        Assertions.assertNull(service.findByUserAndDate(ADMIN, DATE_3));
    }
}