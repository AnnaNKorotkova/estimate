package ru.topjava.estimate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.topjava.estimate.mappers.PriceMapper;
import ru.topjava.estimate.service.PriceService;
import ru.topjava.estimate.to.UserPriceTo;

import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping(value = AdminPriceController.URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class AdminPriceController {

    final static String URL = "/admin/price";

    @Autowired
    PriceService service;

    @GetMapping(value = "/{id}")
    public UserPriceTo get(@PathVariable long id) {
        return PriceMapper.INSTANCE.toDTO(service.get(id));
    }

    @GetMapping
    public List<UserPriceTo> getAll() {
        return service.getAll()
                .stream()
                .map(PriceMapper.INSTANCE::toDTO)
                .collect(Collectors.toList());
    }
}
