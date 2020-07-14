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
import ru.topjava.estimate.model.MenuItem;
import ru.topjava.estimate.service.DishService;
import ru.topjava.estimate.service.MenuItemService;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static ru.topjava.estimate.DishTestData.DISH_1;
import static ru.topjava.estimate.DishTestData.DISH_18;
import static ru.topjava.estimate.MenuItemTestData.*;
import static ru.topjava.estimate.RestaurantTestData.*;

@ExtendWith(SpringExtension.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@SpringBootTest
@Sql(scripts = "classpath:/data.sql")
class MenuItemServiceImplTest {

    @Autowired
    private MenuItemService service;

    @Autowired
    private DishService dishService;

    @Test
    void create() throws Exception {
        MenuItem newPrice = getNewPrice();
        newPrice.setRestaurant(RESTAURANT_3);
        newPrice.setDish(DISH_18);
        MenuItem created = service.save(newPrice);
        Long newId = created.getId();
        newPrice.setId(newId);
        assertEquals(newPrice, created);
    }

    @Test
    @Transactional
    void delete() throws Exception {
        Long id = MENU_ITEM_2.getId();
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
        MENU_ITEM_MATCHER.assertMatch(service.get(MENU_ITEM_1.id()), MENU_ITEM_1);
    }

    @Test
    @Transactional
    void getNotFound() throws Exception {
        Assertions.assertThrows(NotFoundException.class,
                () -> service.get(getNewPriceWithId().getId()));
    }

    @Test
    void getAll() throws Exception {
        List<MenuItem> prices = service.getAll();
        MENU_ITEM_MATCHER.assertMatch(prices, ALL_MENU_ITEMS);
    }

    @Test
    void findByDateAndDishAndRestaurant() throws Exception {
        MenuItem price = service.findByRestaurantAndDishAndDate(RESTAURANT_1, DISH_1, MENU_ITEM_1.getDate());
        MENU_ITEM_MATCHER.assertMatch(price, MENU_ITEM_1);
    }

    @Test
    void notFoundByDateAndDishAndRestaurant() throws Exception {
        Assertions.assertThrows(NotFoundException.class,
                () -> service.findByRestaurantAndDishAndDate(RESTAURANT_1, DISH_1, MENU_ITEM_3.getDate()));
    }

    @Test
    void findAllByRestaurant() throws Exception {
        List<MenuItem> list = service.findAllByRestaurant(RESTAURANT_2);
        MENU_ITEM_MATCHER.assertMatch(list, REST_MENU_ITEMS);
    }

    @Test
    void findAllByDateAndRestaurant() {
        List<MenuItem> list = service.findAllByRestaurantAndDate(RESTAURANT_1, MENU_ITEM_1.getDate());
        MENU_ITEM_MATCHER.assertMatch(list, DATE_REST_MENU_ITEMS);
    }
}