package ru.topjava.estimate.to;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
public class DishTo extends NamedTo {

    private BigDecimal price;

    public DishTo(Long id, String name, BigDecimal price) {
        super(id, name);
        this.price = price;

    }
    public DishTo(String name, BigDecimal price) {
        super(name);
        this.price = price;
    }
}
