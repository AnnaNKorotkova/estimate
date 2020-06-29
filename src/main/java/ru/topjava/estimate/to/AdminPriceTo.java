package ru.topjava.estimate.to;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.topjava.estimate.model.Dish;
import ru.topjava.estimate.model.Restaurant;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class AdminPriceTo extends BaseTo {
    private LocalDate date;
    private Restaurant restaurant;
    private Dish dish;
    private BigDecimal price;

//    public AdminPriceTo(Long id, LocalDate date, Restaurant restaurant, Dish dish, BigDecimal price) {
//        super(id);
//        this.date = date;
//        this.restaurant = restaurant;
//        this.dish = dish;
//        this.price = price;
//    }
}
