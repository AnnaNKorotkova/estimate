package ru.topjava.estimate.to;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import ru.topjava.estimate.HasId;

@NoArgsConstructor
@AllArgsConstructor
public class BaseTo implements HasId {

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
