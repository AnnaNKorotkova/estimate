package ru.topjava.estimate.to;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import ru.topjava.estimate.HasId;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@NoArgsConstructor
@AllArgsConstructor
public class BaseTo implements HasId {

    @NotNull
    @Min(value = 100000000)
    @Max(value = Long.MAX_VALUE)
    protected Long id;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }
}
