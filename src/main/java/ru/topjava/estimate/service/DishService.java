package ru.topjava.estimate.service;

import ru.topjava.estimate.model.Dish;

import java.util.List;

public interface DishService {

    Dish save(Dish dish);

    void delete (Dish dish);

    Dish get (long id);

    List<Dish> getAll() ;

}
