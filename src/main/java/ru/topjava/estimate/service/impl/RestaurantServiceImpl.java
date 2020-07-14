package ru.topjava.estimate.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import ru.topjava.estimate.exeption.NotFoundException;
import ru.topjava.estimate.model.Price;
import ru.topjava.estimate.model.Restaurant;
import ru.topjava.estimate.model.Vote;
import ru.topjava.estimate.repository.PriceRepository;
import ru.topjava.estimate.repository.RestaurantRepository;
import ru.topjava.estimate.repository.VoteRepository;
import ru.topjava.estimate.service.RestaurantService;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import static ru.topjava.estimate.util.ValidationUtil.checkNotFoundWithId;

@Service
@Slf4j
@Transactional(readOnly = true)
public class RestaurantServiceImpl implements RestaurantService {

    @Autowired
    private RestaurantRepository restaurantRepository;

    @Autowired
    private PriceRepository priceRepository;

    @Autowired
    private VoteRepository voteRepository;

    @Override
    @Transactional
    @CacheEvict(value = "restaurants", allEntries = true)
    public Restaurant save(Restaurant restaurant) {
        Assert.notNull(restaurant, "restaurant must not be null");
        log.info("save restaurant {}", restaurant.getName());
        return restaurantRepository.save(restaurant);
    }

    @Override
    @Transactional
    @CacheEvict(value = "restaurants", allEntries = true)
    public void delete(Long id) {
        Assert.notNull(id, "restaurant must not be null");
        log.info("delete restaurant {}", id);
        restaurantRepository.deleteById(id);
    }

    @Override
    public Restaurant getWithVotes(Long id) {
        Restaurant restaurant = checkNotFoundWithId(restaurantRepository.getWithVotes(id), id);
        log.info("getWithVotes restaurant {}", restaurant.getName());
        return restaurant;
    }

    @Override
    @Transactional
    public Restaurant get(Long id) {
        Restaurant restaurant =  restaurantRepository.findById(id).orElseThrow(NotFoundException::new);
        log.info("get restaurant {}", restaurant.getName());
        return restaurant;
    }

    @Override
    public List<Restaurant> getAll() {
        List<Restaurant> list = restaurantRepository.findAll();
        log.info("getAll, find {} rows", list.size());
        return list;
    }

    @Override
    @Transactional
    @Cacheable(value = "restaurants")
    public List<Restaurant> getAllByToday() {
        final List<Restaurant> restaurants = restaurantRepository.findAll();
        final List<Price> prices = priceRepository.findAllByDate(LocalDate.now());
        final List<Vote> votes = voteRepository.findAllByDate(LocalDate.now());
        log.info("getAllByToday, find {} rows", restaurants.size());
        return restaurants.stream().map(x -> x.setAndGetInstance(
                x,
                prices.stream().filter(y -> y.getRestaurant().equals(x)).collect(Collectors.toSet()),
                votes.stream().filter(y -> y.getRestaurant().equals(x)).collect(Collectors.toSet())
        )).collect(Collectors.toList());
    }
}
