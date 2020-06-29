package ru.topjava.estimate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.topjava.estimate.mappers.AdminPriceMapper;
import ru.topjava.estimate.mappers.NamedMapper;
import ru.topjava.estimate.model.Dish;
import ru.topjava.estimate.model.Price;
import ru.topjava.estimate.model.Restaurant;
import ru.topjava.estimate.service.PriceService;
import ru.topjava.estimate.service.RestaurantService;
import ru.topjava.estimate.to.AdminPriceTo;
import ru.topjava.estimate.to.NamedTo;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = AdminPriceController.URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class AdminPriceController {

    final static String URL = "/admin/prices";

    @Autowired
    PriceService service;

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

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void update(/*@Validated(View.Web.class)*/ @RequestBody Price price) {
//        Price updated = service.get(restaurant.getId());
//        updated.setName(restaurant.getName());
        service.save(price);
    }

    @PostMapping//(consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void save(/*@Validated(View.Web.class)*/ @RequestBody AdminPriceTo price) {
//        service.save(new Price(null, LocalDate.now(), new Restaurant(100000003L, "Bangkok"), new Dish(100000013L, "Piance"), BigDecimal.valueOf(1299, 2)));
        Price fromRequest = AdminPriceMapper.INSTANCE.fromDTO(price);
       service.save(fromRequest);
    }

}
