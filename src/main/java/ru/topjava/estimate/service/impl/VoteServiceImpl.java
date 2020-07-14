package ru.topjava.estimate.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import ru.topjava.estimate.exeption.NotFoundException;
import ru.topjava.estimate.model.Restaurant;
import ru.topjava.estimate.model.User;
import ru.topjava.estimate.model.Vote;
import ru.topjava.estimate.repository.RestaurantRepository;
import ru.topjava.estimate.repository.VoteRepository;
import ru.topjava.estimate.service.VoteService;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.Collections;
import java.util.List;

@Service
@Slf4j
@Transactional(readOnly = true)
public class VoteServiceImpl implements VoteService {

    @Autowired
    private VoteRepository voteRepository;

    @Autowired
    private RestaurantRepository restaurantRepository;

    @Override
    @Transactional
    @CacheEvict(value = {"votes", "vote"}, allEntries = true)
    public Vote save(Vote vote) {
        Assert.notNull(vote, "vote must not be null");
        log.info("save dish {}", vote.getId());
        return voteRepository.save(vote);
    }

    @Override
    @Transactional
    @CacheEvict(value = {"votes", "vote"}, allEntries = true)
    public void delete(Long id) {
        Assert.notNull(id, "vote must not be null");
        log.info("delete vote {}", id);
        voteRepository.deleteById(id);
    }

    @Override
    public Vote get(Long id) {
        Vote vote =  voteRepository.findById(id).orElseThrow(NotFoundException::new);
        log.info("get vote {}", id);
        return vote;
    }

    @Override
    public List<Vote> getAll() {
        List<Vote> list = voteRepository.findAll();
        log.info("getAll, find {} rows", list.size());
        return list;
    }

    @Override
    public List<Vote> getAllByUser(User user) {
        Assert.notNull(user, "user must not be null");
        List<Vote> list = voteRepository.findAllByUser(user);
        log.info("getAllByUser({}), find {} rows", user.getName(), list == null ? 0 : list.size());
        return list == null ? Collections.emptyList() : list;
    }

    @Override
    @Cacheable(value = "votes")
    public List<Vote> findAllByRestaurantAndDate(Restaurant restaurant, LocalDate date) {
        Assert.notNull(restaurant, "restaurant must not be null");
        Assert.notNull(date, "date must not be null");
        List<Vote> list = voteRepository.findAllByRestaurantAndDate(restaurant, date);
        log.info("findAllByRestaurantAndDate({}, {}), find {} rows", restaurant.getName(), date, list == null ? 0 : list.size());
        return list == null ? Collections.emptyList() : list;
    }

    @Override
    @Cacheable(value = "vote")
    public Vote findByUserAndDate(User user, LocalDate date) {
        Assert.notNull(user, "user must not be null");
        Assert.notNull(date, "date must not be null");
        Vote vote = voteRepository.findByUserAndDate(user, date);
        log.info("findByUserAndDate({}, {}), find {}", user.getName(), date, vote == null ? null : vote.getId());
        return vote;
    }

    @Override
    @Transactional
    public String vote(Long restaurantId, User user, String votingEndTime) {
        Assert.notNull(user, "user must not be null");
        Assert.notNull(restaurantId, "restaurant_id must not be null");
        Assert.notNull(votingEndTime, "votingEndTime must not be null");

        LocalDate today = LocalDate.now();
        Vote existing = voteRepository.findByUserAndDate(user, today);

        if (existing != null && LocalTime.now().isAfter(LocalTime.parse(votingEndTime))) {
            return "Sorry, you can't change your vote after " + votingEndTime + " AM";
        }

        Long id = existing == null ? null : existing.getId();
        Vote created = voteRepository.save(
                new Vote(id, today, LocalTime.now(), user, restaurantRepository.findById(restaurantId).orElse(null))
        );
        return "You have voted for '" + created.getRestaurant().getName() + "' at " +
                created.getTime().truncatedTo(ChronoUnit.SECONDS);
    }
}
