package ru.topjava.estimate.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "menu_item")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class MenuItem extends AbstractBaseEntity {

    @NotNull
    private LocalDate date;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "restaurant_id", nullable = false)
    @NotNull
    private Restaurant restaurant;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dish_id", nullable = false)
    @NotNull
    private Dish dish;

    @NotNull
    @Digits(integer = 10, fraction = 2)
    @Positive
    private BigDecimal price;

    public MenuItem(Long id, LocalDate date, BigDecimal price) {
        super(id);
        this.date = date;
        this.price = price;
    }

    public MenuItem(Long id, LocalDate date, Restaurant restaurant, Dish dish, BigDecimal price) {
        this(id, date, price);
        this.restaurant = restaurant;
        this.dish = dish;
    }
}
