package ru.topjava.estimate.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.annotations.Cache;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Table(name = "vote", uniqueConstraints = {@UniqueConstraint(columnNames = {"date", "user_id", "restaurant_id"}, name = "vote_unique_date_user_id_restaurant_id_idx")})
public class Vote extends AbstractBaseEntity {

    @Column(name = "date", nullable = false)
    @NotNull
    private  LocalDate date;

    @Column(name = "time", nullable = false)
    @NotNull
    private  LocalTime time;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "restaurant_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Restaurant restaurant;

    public Vote(Long id, LocalDate date, LocalTime time) {
        super(id);
        this.date = date;
        this.time = time;
    }

    public Vote(Long id, LocalDate date, LocalTime time, User user, Restaurant restaurant) {
        super(id);
        this.date = date;
        this.time = time;
        this.user = user;
        this.restaurant = restaurant;
    }
}
