package ru.topjava.estimate.to;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class UserPriceTo extends BaseTo {

    private LocalDate date;

//    private NamedTo restaurantTo;
//    private String restaurantName;

//    private DishTo dishTo;
    private String dishName;
    private BigDecimal dishPrice;

    public UserPriceTo(Long id, LocalDate date, /*String restaurantName,*/ String dishName, BigDecimal dishPrice) {
        super(id);
        this.date = date;
//        this.restaurantName = restaurantName;
        this.dishName = dishName;
        this.dishPrice = dishPrice;
    }
}
