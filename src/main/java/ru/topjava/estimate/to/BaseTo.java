package ru.topjava.estimate.to;

import lombok.NoArgsConstructor;
import ru.topjava.estimate.HasId;

@NoArgsConstructor
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
