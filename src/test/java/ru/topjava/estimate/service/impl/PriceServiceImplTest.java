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
import ru.topjava.estimate.exeption.NotFoundException;
import ru.topjava.estimate.model.Price;
import ru.topjava.estimate.service.DishService;
import ru.topjava.estimate.service.PriceService;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static ru.topjava.estimate.DishTestData.DISH_1;
import static ru.topjava.estimate.DishTestData.DISH_18;
import static ru.topjava.estimate.PriceTestData.*;
import static ru.topjava.estimate.RestaurantTestData.*;

@ExtendWith(SpringExtension.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@SpringBootTest
@Sql(scripts = "classpath:/data.sql")
class PriceServiceImplTest {

    @Autowired
    private PriceService service;

    @Autowired
    DishService dishService;

    @Test
    void create() throws Exception {
        Price newPrice = getNewPrice();
        newPrice.setRestaurant(RESTAURANT_3);
        newPrice.setDish(DISH_18);
        Price created = service.save(newPrice);
        Long newId = created.getId();
        newPrice.setId(newId);
        assertEquals(newPrice, created);
    }

    @Test
    @Transactional
    void delete() throws Exception {
        Long id = PRICE_2.getId();
        service.delete(id);
        Assertions.assertThrows(NotFoundException.class,
                () -> service.get(id));
    }

    @Test
    @Transactional
    void deleteNotfound() throws Exception {
        Assertions.assertThrows(EmptyResultDataAccessException.class,
                () -> service.delete(getNewPriceWithId().getId()));
    }

    @Test
    @Transactional
    void get() throws Exception {
        PRICE_MATCHER.assertMatch(service.get(PRICE_1.id()), PRICE_1);
    }

    @Test
    @Transactional
    void getNotFound() throws Exception {
        Assertions.assertThrows(NotFoundException.class,
                () -> service.get(getNewPriceWithId().getId()));
    }

    @Test
    void getAll() throws Exception {
        List<Price> prices = service.getAll();
        PRICE_MATCHER.assertMatch(prices, ALL_PRICES);
    }

    @Test
    void findByDateAndDishAndRestaurant() throws Exception {
        Price price = service.findByDateAndDishAndRestaurant(PRICE_1.getDate(), DISH_1, RESTAURANT_1);
        PRICE_MATCHER.assertMatch(price, PRICE_1);
    }

    @Test
    void notFoundByDateAndDishAndRestaurant() throws Exception {
        Assertions.assertThrows(NotFoundException.class,
                () -> service.findByDateAndDishAndRestaurant(PRICE_3.getDate(), DISH_1, RESTAURANT_1));
    }

    @Test
    void findAllByRestaurant() throws Exception {
        List<Price> list = service.findAllByRestaurant(RESTAURANT_2);
        PRICE_MATCHER.assertMatch(list, REST_PRICES);
    }

    @Test
    void findAllByDateAndRestaurant() {
        List<Price> list = service.findAllByDateAndRestaurant(PRICE_1.getDate(), RESTAURANT_1);
        PRICE_MATCHER.assertMatch(list, DATE_REST_PRICES);
    }
}