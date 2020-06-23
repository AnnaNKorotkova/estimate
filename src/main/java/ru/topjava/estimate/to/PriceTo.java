package ru.topjava.estimate.to;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class PriceTo extends BaseTo {

    private LocalDate date;

    private NameTo restaurantTo;

    private DishTo dishTo;
}
