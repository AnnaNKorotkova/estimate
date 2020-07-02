package ru.topjava.estimate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.topjava.estimate.mappers.NamedMapper;
import ru.topjava.estimate.model.Dish;
import ru.topjava.estimate.service.DishService;
import ru.topjava.estimate.to.NamedTo;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = AdminDishController.URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class AdminDishController {

    final static String URL = "/admin/dishes";

    @Autowired
    DishService service;

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

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void save(@RequestBody @Valid NamedTo dish) {
        service.save(new Dish(dish.getId(), dish.getName()));
    }
}
