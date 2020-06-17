package ru.topjava.estimate.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import ru.topjava.estimate.model.Dish;
import ru.topjava.estimate.model.Price;
import ru.topjava.estimate.model.Restaurant;
import ru.topjava.estimate.repository.PriceRepository;
import ru.topjava.estimate.service.PriceService;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

import static ru.topjava.estimate.Util.ValidationUtil.checkNotFound;
import static ru.topjava.estimate.Util.ValidationUtil.checkNotFoundWithId;

@Service
@Slf4j
public class PriceServiceImpl implements PriceService {

    @Autowired
    private PriceRepository priceRepository;

    @Override
    public Price save(Price price) {
        Assert.notNull(price, "price must not be null");
        log.info("save price {}", price.getId());
        return priceRepository.save(price);
    }

    @Override
    public void delete(Price price) {
        Assert.notNull(price, "price must not be null");
        log.info("delete price {}", price.getId());
        priceRepository.delete(price);
    }

    @Override
    public Price get(long id) {
        Price price = checkNotFoundWithId(priceRepository.getOne(id), id);
        log.info("get price {}", price.getId());
        return price;
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
