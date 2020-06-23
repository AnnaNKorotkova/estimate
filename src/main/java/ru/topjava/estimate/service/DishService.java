package ru.topjava.estimate.service;

import ru.topjava.estimate.model.Dish;

import java.util.List;


public interface DishService {

    Dish save(Dish dish);

    void delete (Long id);

    Dish get (Long id);

    List<Dish> getAll() ;

}
