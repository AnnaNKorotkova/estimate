package ru.topjava.estimate.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.topjava.estimate.model.Restaurant;
import ru.topjava.estimate.model.User;
import ru.topjava.estimate.model.Vote;

import java.time.LocalDate;
import java.util.List;

@Repository
@Transactional(readOnly = true)
public interface VoteRepository extends JpaRepository<Vote, Long> {

    List<Vote> findAllByUser (User user);

    List<Vote> findAllByRestaurantAndDate(Restaurant restaurant, LocalDate date);

    Vote findByUserAndDate(User user, LocalDate date);

    List<Vote> findAllByDate (LocalDate date);
}
