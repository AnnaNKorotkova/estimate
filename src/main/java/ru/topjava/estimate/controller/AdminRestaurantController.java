package ru.topjava.estimate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import ru.topjava.estimate.service.RestaurantService;

import java.net.URI;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@RestController
@RequestMapping(value = AdminRestaurantController.URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class AdminRestaurantController {

    final static String URL = "/admin/restaurant";

    @Autowired
    RestaurantService service;
//
//    @GetMapping("/{id}")
//    public Meal get(@PathVariable int id) {
//        return super.get(id);
//    }
//
//    @DeleteMapping("/{id}")
//    @ResponseStatus(value = HttpStatus.NO_CONTENT)
//    public void delete(@PathVariable int id) {
//        super.delete(id);
//    }
//
//    @GetMapping
//    public List<MealTo> getAll() {
//        return super.getAll();
//    }
//
//    @PutMapping
//    @ResponseStatus(value = HttpStatus.NO_CONTENT)
//    public void update(@Validated(View.Web.class) @RequestBody Meal meal, @PathVariable int id) {
//        super.update(meal, id);
//    }
//
//    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<Meal> createWithLocation(@Validated(View.Web.class) @RequestBody Meal meal) {
//        Meal created = super.create(meal);
//
//        URI uriOfNewResource = ServletUriComponentsBuilder.fromCurrentContextPath()
//                .path(REST_URL + "/{id}")
//                .buildAndExpand(created.getId()).toUri();
//
//        return ResponseEntity.created(uriOfNewResource).body(created);
//    }
//
//    @GetMapping(value = "/filter")
//    public List<MealTo> getBetween(
//            @RequestParam @Nullable LocalDate startDate,
//            @RequestParam @Nullable LocalTime startTime,
//            @RequestParam @Nullable LocalDate endDate,
//            @RequestParam @Nullable LocalTime endTime) {
//        return super.getBetween(startDate, startTime, endDate, endTime);
//    }
}
