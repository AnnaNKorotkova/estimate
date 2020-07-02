package ru.topjava.estimate.repository;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.topjava.estimate.model.Dish;

import java.util.List;

@Repository
@Transactional(readOnly = true)
public interface DishRepository extends JpaRepository<Dish, Long> {

    @EntityGraph(attributePaths = {"dishPrice"}, type = EntityGraph.EntityGraphType.LOAD)
    @Query("SELECT d FROM Dish d")
    List<Dish> getAll();
}
