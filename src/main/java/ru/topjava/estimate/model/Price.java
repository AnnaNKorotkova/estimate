package ru.topjava.estimate.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
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
    //   @OnDelete(action = OnDeleteAction.CASCADE)
    private Restaurant restaurant;

    @ManyToOne(fetch = FetchType.LAZY)
//    @OnDelete(action = OnDeleteAction.CASCADE)
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
}
