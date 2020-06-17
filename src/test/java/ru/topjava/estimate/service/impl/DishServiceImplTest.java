package ru.topjava.estimate.service.impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import ru.topjava.estimate.model.Dish;
import ru.topjava.estimate.repository.DishRepository;
import ru.topjava.estimate.service.DishService;

import static ru.topjava.estimate.DishTestData.getNewDish;

@ExtendWith(SpringExtension.class)
@DataJpaTest
class DishServiceImplTest {

    @Autowired
    private DishService service;

    @Autowired
    private DishRepository repository;

    @Test
    void create() throws Exception {
        Dish newDish = getNewDish();
        Dish created = service.save(newDish);
        long newId = created.id();
        newDish.setId(newId);
        Assertions.assertEquals(newDish.getName(), created.getName());

    }

}