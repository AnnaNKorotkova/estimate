package ru.topjava.estimate.to;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
public class NamedTo extends BaseTo {

    @NotBlank
    @Size(min = 2, max = 100)
    private String name;

    public NamedTo(Long id, String nameTo) {
        super(id);
        this.name = nameTo;
    }
}
