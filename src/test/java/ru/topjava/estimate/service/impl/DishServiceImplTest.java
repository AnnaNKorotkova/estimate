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
import ru.topjava.estimate.model.Dish;
import ru.topjava.estimate.service.DishService;

import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static ru.topjava.estimate.DishTestData.*;

@ExtendWith(SpringExtension.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@SpringBootTest
@Sql(scripts = "classpath:/data.sql")
class DishServiceImplTest {

    @Autowired
    private DishService service;

    @Test
    void create() throws Exception {
        Dish newDish = getNewDish();
        Dish created = service.save(newDish);
        Long newId = created.getId();
        newDish.setId(newId);
        assertEquals(newDish, created);
    }

    @Test
    void delete() throws Exception {
        Long id = DISH_1.getId();
        service.delete(id);
        Assertions.assertThrows(NotFoundException.class,
                () -> service.get(id));
    }

    @Test
    void deleteNotFound() throws Exception {
        Assertions.assertThrows(EmptyResultDataAccessException.class,
                () -> service.delete(getNewDishWithId().getId()));
    }

    @Test
    @Transactional
    void get() throws Exception {
        DISH_MATCHER.assertMatch(service.get(DISH_1.getId()), DISH_1);
    }

    @Test
    @Transactional
    void getNotFound() throws Exception {
        Assertions.assertThrows(NotFoundException.class,
                () -> service.get(getNewDishWithId().getId()));
    }

    @Test
    void getAll() throws Exception {
        DISH_MATCHER.assertMatch(service.getAll(), ALL_DISHES);
    }
}