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
import org.springframework.transaction.annotation.Transactional;
import ru.topjava.estimate.Exeption.NotFoundException;
import ru.topjava.estimate.model.Restaurant;
import ru.topjava.estimate.model.User;
import ru.topjava.estimate.service.UserService;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static ru.topjava.estimate.RestaurantTestData.*;
import static ru.topjava.estimate.UserTestData.*;

@ExtendWith(SpringExtension.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@SpringBootTest
@Sql(scripts = "classpath:/data.sql")
class UserServiceImplTest {

    @Autowired
    private UserService service;

    @Test
    void save() throws Exception {
        User newUser = getNewUser();
        User created = service.register(newUser);
        Long newId = created.getId();
        newUser.setId(newId);
        assertEquals(newUser, created);
    }

    @Test
    void delete() throws Exception {
        Long id = USER.getId();
        service.delete(id);
        Assertions.assertThrows(NotFoundException.class,
                () -> service.get(id));
    }

    @Test
    void deleteNotfound() throws Exception {
        Assertions.assertThrows(EmptyResultDataAccessException.class,
                () -> service.delete(getNewRestaurantWithId().getId()));
    }

    @Test
    @Transactional
    void get() throws Exception {
        USER_MATCHER.assertMatch(service.get(USER.getId()), USER);
    }

    @Test
    void getNotFound() throws Exception {
        Assertions.assertThrows(NotFoundException.class,
                () -> service.get(getNewUserWithId().getId()));
    }

    @Test
    void getAll() throws Exception {
        List<User> list = service.getAll();
        USER_MATCHER.assertMatch(list, List.of(USER, ADMIN));
    }

}