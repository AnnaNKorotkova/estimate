package ru.topjava.estimate.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "price")
public class Price extends AbstractBaseEntity {

    @NotNull
    private LocalDate date;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "restaurant_id", nullable = false)
    //   @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonBackReference
    private Restaurant restaurant;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dish_id", nullable = false)
//    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonBackReference
    private Dish dish;

    @NotNull
//    @ManyToOne(fetch = FetchType.EAGER)
//    @JoinTable(name = "currency", joinColumns = @JoinColumn(name = "currency_id"),
//            inverseJoinColumns = @JoinColumn(name = "id"))
    @Digits(integer = 10, fraction = 2)
    private BigDecimal price;

    public Price(Long id, @NotNull LocalDate date, @NotNull BigDecimal price) {
        super(id);
        this.date = date;
        this.price = price;
    }

    public Price(Long id, LocalDate date, Restaurant restaurant, Dish dish, BigDecimal price) {
        super(id);
        this.date = date;
        this.restaurant = restaurant;
        this.dish = dish;
        this.price = price;
    }

}
