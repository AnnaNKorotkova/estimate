package ru.topjava.estimate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import ru.topjava.estimate.mappers.NamedMapper;
import ru.topjava.estimate.model.Restaurant;
import ru.topjava.estimate.service.RestaurantService;
import ru.topjava.estimate.to.NamedTo;

import java.net.URI;
import java.time.LocalDate;
import java.time.LocalTime;
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
                .map(NamedMapper.INSTANCE::toDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public NamedTo get(@PathVariable long id) {
        return NamedMapper.INSTANCE.toDTO(service.get(id));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable long id) {
        service.delete(id);
    }

    @PutMapping
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void update(/*@Validated(View.Web.class)*/ @RequestBody NamedTo restaurant) {
        Restaurant updated = service.get(restaurant.getId());
        updated.setName(restaurant.getName());
        service.save(updated);
    }

    @PostMapping
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void save(/*@Validated(View.Web.class)*/ @RequestBody NamedTo restaurant) {
        service.save(new Restaurant(null, restaurant.getName()));
    }

}
