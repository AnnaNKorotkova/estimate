package ru.topjava.estimate.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.topjava.estimate.model.Dish;
import ru.topjava.estimate.model.MenuItem;
import ru.topjava.estimate.model.Restaurant;

import java.time.LocalDate;
import java.util.List;

@Repository
@Transactional(readOnly = true)
public interface MenuItemRepository extends JpaRepository<MenuItem, Long> {

    List<MenuItem> findAllByRestaurant(Restaurant restaurant);

    List<MenuItem> findAllByDateAndRestaurant(LocalDate date, Restaurant restaurant);

    MenuItem findByDateAndDishAndRestaurant(LocalDate date, Dish dish, Restaurant restaurant);

    List<MenuItem> findAllByDate(LocalDate date);
}
