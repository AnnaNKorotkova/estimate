package ru.topjava.estimate.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import ru.topjava.estimate.exeption.NotFoundException;
import ru.topjava.estimate.model.Dish;
import ru.topjava.estimate.model.MenuItem;
import ru.topjava.estimate.model.Restaurant;
import ru.topjava.estimate.repository.MenuItemRepository;
import ru.topjava.estimate.service.MenuItemService;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

import static ru.topjava.estimate.util.ValidationUtil.checkNotFound;

@Service
@Slf4j
@Transactional(readOnly = true)
public class MenuItemServiceImpl implements MenuItemService {

    @Autowired
    private MenuItemRepository menuItemRepository;

    @Override
    @Transactional
    @CacheEvict(value = "menuItems", allEntries = true)
    public MenuItem save(MenuItem menuItem) {
        Assert.notNull(menuItem, "menuItem must not be null");
        log.info("save menuItem {}", menuItem.getId());
        return menuItemRepository.save(menuItem);
    }

    @Override
    @Transactional
    @CacheEvict(value = "menuItems", allEntries = true)
    public void delete(Long id) {
        Assert.notNull(id, "menuItem id must not be null");
        log.info("delete menuItem {}", id);
        menuItemRepository.deleteById(id);
    }

    @Override
    public MenuItem get(Long id) {
        MenuItem menuItem = menuItemRepository.findById(id).orElseThrow(NotFoundException::new);
        log.info("get menuItem {}", menuItem.getId());
        return menuItem;
    }

    @Override
    public List<MenuItem> getAll() {
        List<MenuItem> list = menuItemRepository.findAll();
        log.info("findAll(), found {} rows", list.size());
        return list;
    }

    @Override
    public MenuItem findByRestaurantAndDishAndDate(Restaurant restaurant, Dish dish, LocalDate date) {
        Assert.notNull(date, "date must not be null");
        Assert.notNull(dish, "dish must not be null");
        Assert.notNull(restaurant, "restaurant must not be null");
        MenuItem menuItem = checkNotFound(menuItemRepository.findByDateAndDishAndRestaurant(date, dish, restaurant),
                "date = " + date + ", dish = " + dish.getName() + ", restaurant = " + restaurant.getName());
        log.info("get menuItem {}", menuItem.getId());
        return menuItem;
    }

    @Override
    public List<MenuItem> findAllByRestaurant(Restaurant restaurant) {
        Assert.notNull(restaurant, "restaurant must not be null");
        List<MenuItem> list = menuItemRepository.findAllByRestaurant(restaurant);
        log.info("findAllByRestaurant({}), found {} rows", restaurant.getName(), list == null ? 0 : list.size());
        return list == null ? Collections.emptyList() : list;
    }

    @Override
    @Cacheable(value = "menuItems", key = "#date")
    public List<MenuItem> findAllByRestaurantAndDate(Restaurant restaurant, LocalDate date) {
        Assert.notNull(date, "date must not be null");
        Assert.notNull(restaurant, "restaurant must not be null");
        List<MenuItem> list = menuItemRepository.findAllByDateAndRestaurant(date, restaurant);
        log.info("findAllByRestaurant({}, {}), found {} rows", date, restaurant.getName(), list == null ? 0 : list.size());
        return list == null ? Collections.emptyList() : list;
    }
}
