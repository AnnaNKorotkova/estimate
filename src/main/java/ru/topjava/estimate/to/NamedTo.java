package ru.topjava.estimate.to;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class NamedTo extends BaseTo {

    private String name;

    public NamedTo(Long id, String nameTo) {
        super(id);
        this.name = nameTo;
    }

    public NamedTo(String name) {
        this.name = name;
    }
}
