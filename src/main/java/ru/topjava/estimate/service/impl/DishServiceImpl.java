package ru.topjava.estimate.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import ru.topjava.estimate.exeption.NotFoundException;
import ru.topjava.estimate.model.Dish;
import ru.topjava.estimate.repository.DishRepository;
import ru.topjava.estimate.service.DishService;

import java.util.List;

@Service
@Slf4j
@Transactional(readOnly = true)
public class DishServiceImpl implements DishService {

    private final DishRepository dishRepository;

    public DishServiceImpl(DishRepository dishRepository) {
        this.dishRepository = dishRepository;
    }

    @Override
    @Transactional
    public Dish save(Dish dish) {
        Assert.notNull(dish, "dish must not be null");
        log.info("save dish {}", dish.getName());
        return dishRepository.save(dish);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        Assert.notNull(id, "dish id must not be null");
        log.info("delete dish {}", id);
        dishRepository.deleteById(id);
    }

    @Override
    @Transactional
    public Dish get(Long id) {
        Dish dish = dishRepository.findById(id).orElseThrow(NotFoundException::new);
        log.info("get dish {}", dish.getName());
        return dish;
    }

    @Override
    public List<Dish> getAll() {
        List<Dish> list = dishRepository.getAll();
        log.info("getAll, find {} rows", list.size());
        return list;
    }
}
