package ru.topjava.estimate.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Vote extends AbstractBaseEntity {
    private final Long userId;

    public Vote(Long id, Long userId) {
        super(id);
        this.userId = userId;
    }
}
