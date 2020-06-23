package ru.topjava.estimate;

import ru.topjava.estimate.model.Restaurant;
import ru.topjava.estimate.model.User;
import ru.topjava.estimate.model.Vote;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class VoteTestData {

    public final static TestMatcher<Vote> VOTE_MATCHER = TestMatcher.usingFieldsComparator(Vote.class, "user", "restaurant");
    public final static TestMatcher<Vote> VOTE_MATCHER_NO_FIELDS_IGNORE = TestMatcher.usingEquals(Vote.class);

    public final static LocalDate DATE_1 = LocalDate.parse("2020-06-01");
    public final static LocalDate DATE_2 = LocalDate.parse("2020-06-02");
    public final static LocalDate DATE_3 = LocalDate.parse("2020-06-03");

    public final static Vote VOTE_1 = new Vote(100000041L, DATE_1, LocalTime.parse("09:58:00"));
    public final static Vote VOTE_2 = new Vote(100000042L, DATE_2, LocalTime.parse("10:10:15"));
    public final static Vote VOTE_3 = new Vote(100000043L, DATE_3, LocalTime.parse("07:12:13"));

    public static Vote getNewVote() {
        return new Vote(null, LocalDate.parse("2020-06-05"), LocalTime.parse("10:30:00"));
    }

    public static Vote getNewVoteWithID() {
        return new Vote(99999999L, LocalDate.parse("2020-06-05"), LocalTime.parse("10:30:00"));
    }

    public final static List<Vote> ALL_VOTES = List.of(VOTE_1, VOTE_2, VOTE_3);
}
