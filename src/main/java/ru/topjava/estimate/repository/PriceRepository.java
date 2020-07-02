package ru.topjava.estimate.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.topjava.estimate.model.Dish;
import ru.topjava.estimate.model.Price;
import ru.topjava.estimate.model.Restaurant;

import java.time.LocalDate;
import java.util.List;

@Repository
@Transactional(readOnly = true)
public interface PriceRepository extends JpaRepository<Price, Long> {

    List<Price> findAllByRestaurant(Restaurant restaurant);

    List<Price> findAllByDateAndRestaurant(LocalDate date, Restaurant restaurant);

    Price findByDateAndDishAndRestaurant(LocalDate date, Dish dish, Restaurant restaurant);
}
