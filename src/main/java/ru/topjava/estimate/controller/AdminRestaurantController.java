package ru.topjava.estimate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.topjava.estimate.mappers.NamedMapper;
import ru.topjava.estimate.model.Restaurant;
import ru.topjava.estimate.service.RestaurantService;
import ru.topjava.estimate.to.NamedTo;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = AdminRestaurantController.URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class AdminRestaurantController {

    final static String URL = "/admin/restaurants";

    @Autowired
    RestaurantService service;

    @GetMapping
    public List<NamedTo> getAll() {
        return service.getAll().stream()
                .map(NamedMapper.INSTANCE::toRestaurantTo)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public NamedTo get(@PathVariable long id) {
        return NamedMapper.INSTANCE.toRestaurantTo(service.get(id));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable long id) {
        service.delete(id);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void save(@RequestBody @Valid NamedTo restaurant) {

        service.save(new Restaurant(restaurant.getId(), restaurant.getName()));
    }
}
