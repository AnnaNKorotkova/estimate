package ru.topjava.estimate.to;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class AdminPriceTo extends BaseTo {

    @NotNull
    private LocalDate date;
    @NotNull
    private NamedTo restaurant;
    @NotNull
    private NamedTo dish;
    @NotNull
    @Positive
    private BigDecimal price;
}
