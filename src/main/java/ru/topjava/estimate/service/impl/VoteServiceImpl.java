package ru.topjava.estimate.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import ru.topjava.estimate.Exeption.NotFoundException;
import ru.topjava.estimate.model.Restaurant;
import ru.topjava.estimate.model.User;
import ru.topjava.estimate.model.Vote;
import ru.topjava.estimate.repository.VoteRepository;
import ru.topjava.estimate.service.VoteService;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

import static ru.topjava.estimate.util.ValidationUtil.checkNotFoundWithId;
import static ru.topjava.estimate.util.ValidationUtil.checkNotFound;

@Service
@Slf4j
@Transactional(readOnly = true)
public class VoteServiceImpl implements VoteService {

    @Autowired
    private VoteRepository voteRepository;

    @Override
    @Transactional
    public Vote save(Vote vote) {
        Assert.notNull(vote, "vote must not be null");
        log.info("save dish {}", vote.getId());
        return voteRepository.save(vote);
    }

    @Override
    @Transactional
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
    public List<Vote> findAllByRestaurantAndDate(Restaurant restaurant, LocalDate date) {
        Assert.notNull(restaurant, "restaurant must not be null");
        Assert.notNull(date, "date must not be null");
        List<Vote> list = voteRepository.findAllByRestaurantAndDate(restaurant, date);
        log.info("findAllByRestaurantAndDate({}, {}), find {} rows", restaurant.getName(), date, list == null ? 0 : list.size());
        return list == null ? Collections.emptyList() : list;
    }

    @Override
    public Vote findByUserAndDate(User user, LocalDate date) {
        Assert.notNull(user, "user must not be null");
        Assert.notNull(date, "date must not be null");
        Vote vote = checkNotFound(voteRepository.findByUserAndDate(user, date),
                "user = " + user.getName() + ", date = " + date);
        log.info("findByUserAndDate({}, {}), find {}", user.getName(), date, vote.getId());
        return vote;
    }
}
