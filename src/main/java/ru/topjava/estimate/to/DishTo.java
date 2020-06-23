package ru.topjava.estimate.to;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
public class DishTo extends NameTo {

    private BigDecimal price;
}
