package ru.topjava.estimate.service.impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import ru.topjava.estimate.model.Dish;

import static ru.topjava.estimate.DishTestData.getNewDish;

@ExtendWith(SpringExtension.class)
@DataJpaTest
class DishServiceImplTest {

    @Autowired
    private DishServiceImpl service;

    @Test
    void create() throws Exception {
        Dish newDish = getNewDish();
        Dish created = service.save(newDish);
        long newId = created.id();
        newDish.setId(newId);
        Assertions.assertEquals(newDish.getName(), created.getName());
//        MEAL_MATCHER.assertMatch(created, newMeal);
//        MEAL_MATCHER.assertMatch(service.get(newId, USER_ID), newMeal);
    }

}