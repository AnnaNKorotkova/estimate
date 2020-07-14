package ru.topjava.estimate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.topjava.estimate.mappers.AdminMenuMapper;
import ru.topjava.estimate.service.MenuItemService;
import ru.topjava.estimate.to.AdminMenuTo;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = AdminMenuController.URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class AdminMenuController {

    final static String URL = "/admin/menu";

    @Autowired
    MenuItemService service;

    @GetMapping
    public List<AdminMenuTo> getAll() {
        return service.getAll().stream()
                .map(AdminMenuMapper.INSTANCE::toDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public AdminMenuTo get(@PathVariable long id) {
        return AdminMenuMapper.INSTANCE.toDTO(service.get(id));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable long id) {
        service.delete(id);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void save(@RequestBody @Valid AdminMenuTo priceTo) {
       service.save(AdminMenuMapper.INSTANCE.fromDTO(priceTo));
    }

}
