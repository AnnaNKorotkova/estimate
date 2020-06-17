package ru.topjava.estimate.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.topjava.estimate.model.Dish;

@Repository
@Transactional(readOnly = true)
public interface DishRepository extends JpaRepository<Dish, Long> {
}
