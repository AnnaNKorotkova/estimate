package ru.topjava.estimate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.topjava.estimate.mappers.AdminPriceMapper;
import ru.topjava.estimate.service.PriceService;
import ru.topjava.estimate.to.AdminPriceTo;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = AdminPriceController.URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class AdminPriceController {

    final static String URL = "/admin/prices";

    @Autowired
    PriceService service;

    @GetMapping
    public List<AdminPriceTo> getAll() {
        return service.getAll().stream()
                .map(AdminPriceMapper.INSTANCE::toDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public AdminPriceTo get(@PathVariable long id) {
        return AdminPriceMapper.INSTANCE.toDTO(service.get(id));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable long id) {
        service.delete(id);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void save(@RequestBody @Valid AdminPriceTo priceTo) {
       service.save(AdminPriceMapper.INSTANCE.fromDTO(priceTo));
    }

}
