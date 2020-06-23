package ru.topjava.estimate.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import ru.topjava.estimate.Exeption.NotFoundException;
import ru.topjava.estimate.model.Dish;
import ru.topjava.estimate.model.Price;
import ru.topjava.estimate.model.Restaurant;
import ru.topjava.estimate.repository.PriceRepository;
import ru.topjava.estimate.service.PriceService;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

import static ru.topjava.estimate.util.ValidationUtil.checkNotFound;
import static ru.topjava.estimate.util.ValidationUtil.checkNotFoundWithId;

@Service
@Slf4j
@Transactional(readOnly = true)
public class PriceServiceImpl implements PriceService {

    @Autowired
    private PriceRepository priceRepository;

    @Override
    @Transactional
    public Price save(Price price) {
        Assert.notNull(price, "price must not be null");
        log.info("save price {}", price.getId());
        return priceRepository.save(price);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        Assert.notNull(id, "price id must not be null");
        log.info("delete price {}", id);
        priceRepository.deleteById(id);
    }

    @Override
    public Price get(Long id) {
        Price price = priceRepository.findById(id).orElseThrow(NotFoundException::new);
        log.info("get price {}", price.getId());
        return price;
    }

    @Override
    public List<Price> getAll() {
        List<Price> list = priceRepository.findAll();
        log.info("findAll(), found {} rows", list.size());
        return list;
    }

    @Override
    public Price findByDateAndDishAndRestaurant(LocalDate date, Dish dish, Restaurant restaurant) {
        Assert.notNull(date, "date must not be null");
        Assert.notNull(dish, "dish must not be null");
        Assert.notNull(restaurant, "restaurant must not be null");
        Price price = checkNotFound(priceRepository.findByDateAndDishAndRestaurant(date, dish, restaurant),
                "date = " + date + ", dish = " + dish.getName() + ", restaurant = " + restaurant.getName());
        log.info("get price {}", price.getId());
        return price;
    }

    @Override
    public List<Price> findAllByRestaurant(Restaurant restaurant) {
        Assert.notNull(restaurant, "restaurant must not be null");
        List<Price> list = priceRepository.findAllByRestaurant(restaurant);
        log.info("findAllByRestaurant({}), found {} rows", restaurant.getName(), list == null ? 0 : list.size());
        return list == null ? Collections.emptyList() : list;
    }

    @Override
    public List<Price> findAllByDateAndRestaurant(LocalDate date, Restaurant restaurant) {
        Assert.notNull(date, "date must not be null");
        Assert.notNull(restaurant, "restaurant must not be null");
        List<Price> list = priceRepository.findAllByDateAndRestaurant(date, restaurant);
        log.info("findAllByRestaurant({}, {}), found {} rows", date, restaurant.getName(), list == null ? 0 : list.size());
        return list == null ? Collections.emptyList() : list;
    }
}
