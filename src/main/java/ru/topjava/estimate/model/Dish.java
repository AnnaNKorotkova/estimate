package ru.topjava.estimate.model;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.javamoney.moneta.Money;

import javax.persistence.Entity;


@Entity
@Getter
@Setter
@NoArgsConstructor
public class Dish extends AbstractNamedEntity {

    private final Money price;

    public Dish(Long id, String name, Money price) {
        super(id, name);
        this.price = price;
    }
}
