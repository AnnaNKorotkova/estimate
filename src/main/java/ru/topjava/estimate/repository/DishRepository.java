package ru.topjava.estimate.repository;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.topjava.estimate.model.Dish;

import java.time.LocalDateTime;
import java.util.List;

@Repository
@Transactional(readOnly = true)
public interface DishRepository extends JpaRepository<Dish, Long> {

//    @Query("SELECT d FROM Dish d JOIN FETCH d.dishPrice")
@EntityGraph(attributePaths = {"dishPrice"}, type = EntityGraph.EntityGraphType.LOAD)
@Query("SELECT d FROM Dish d")
List<Dish> getAll();


//    @Query("SELECT m from Meal m WHERE m.user.id=:userId AND m.dateTime >= :startDate AND m.dateTime < :endDate ORDER BY m.dateTime DESC")
//    List<Meal> getBetweenHalfOpen(@Param("startDate") LocalDateTime startDate, @Param("endDate") LocalDateTime endDate, @Param("userId") int userId);
}
