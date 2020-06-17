package ru.topjava.estimate.model;

import lombok.Getter;
import lombok.Setter;
import org.javamoney.moneta.Money;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@Table(name = "price")
public class Price extends AbstractBaseEntity {

    @NotNull
    private final LocalDate date;

    @ManyToOne
    private Restaurant restaurant;

    @ManyToOne
    private Dish dish;

    @NotNull
    private final Money price;

    public Price(Long id, @NotNull LocalDate date, @NotNull Money price) {
        super(id);
        this.date = date;
        this.price = price;
    }
}
