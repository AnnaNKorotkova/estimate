package ru.topjava.estimate;

import ru.topjava.estimate.model.Vote;

import java.time.LocalDate;
import java.time.LocalTime;

public class VoteTestData {

    public final static Vote VOTE_1 = new Vote(100000041L, LocalDate.parse("2020-06-01"), LocalTime.parse("09:58:00"));
    public final static Vote VOTE_2 = new Vote(100000042L, LocalDate.parse("2020-06-02"), LocalTime.parse("10:10:15"));
    public final static Vote VOTE_3 = new Vote(100000043L, LocalDate.parse("2020-06-03"), LocalTime.parse("07:12:13"));

}
