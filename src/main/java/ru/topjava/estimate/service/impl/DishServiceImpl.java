package ru.topjava.estimate.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import ru.topjava.estimate.model.Dish;
import ru.topjava.estimate.repository.DishRepository;
import ru.topjava.estimate.service.DishService;

import java.util.List;

import static ru.topjava.estimate.util.ValidationUtil.checkNotFoundWithId;

@Service
@Slf4j
public class DishServiceImpl implements DishService {

    @Autowired
    private DishRepository dishRepository;

    @Override
    public Dish save(Dish dish) {
        Assert.notNull(dish, "dish must not be null");
        log.info("save dish {}", dish.getName());
        return dishRepository.save(dish);
    }

    @Override
    public void delete(Dish dish) {
        Assert.notNull(dish, "dish must not be null");
        log.info("delete dish {}", dish.getName());
        dishRepository.delete(dish);
    }

    @Override
    public Dish get(long id) {
        Dish dish = checkNotFoundWithId(dishRepository.getOne(id), id);
        log.info("get dish {}", dish.getName());
        return dish;
    }

    @Override
    public List<Dish> getAll() {
        List<Dish> list = dishRepository.findAll();
        log.info("getAll, find {} rows", list.size());
        return list;
    }
}
