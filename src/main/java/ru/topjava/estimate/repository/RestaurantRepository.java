package ru.topjava.estimate.repository;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.topjava.estimate.model.Restaurant;

import java.util.List;

@Repository
@Transactional(readOnly = true)
public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {

    @EntityGraph(attributePaths = {"votes"}, type = EntityGraph.EntityGraphType.LOAD)
    @Query("SELECT r FROM Restaurant r WHERE r.id=?1")
    Restaurant getWithVotes(Long id);

//    @EntityGraph(attributePaths = {"votes"}, type = EntityGraph.EntityGraphType.LOAD)
//    @Query("SELECT r FROM Restaurant r")
//    List<Restaurant> getAllWithVotes();

//    @EntityGraph(attributePaths = {"votes", "restaurantPrice"}, type = EntityGraph.EntityGraphType.LOAD)
//    @Query(value =
//            "SELECT DISTINCT r.* FROM RESTAURANT r " +
//                    "JOIN PRICE p ON r.ID = p.RESTAURANT_ID " +
//                    "JOIN DISH d ON d.ID = p.DISH_ID " +
//                    "JOIN VOTE v ON r.ID = v.RESTAURANT_ID " +
//                    "WHERE p.DATE = '2020-06-02'",
//            nativeQuery = true)
////    List<Restaurant> getAllWithPriceAndVotes();
//    List<Restaurant> getAllWithVotes();
}
