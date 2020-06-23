package ru.topjava.estimate;

import ru.topjava.estimate.model.Price;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class PriceTestData {

    public static TestMatcher<Price> PRICE_MATCHER = TestMatcher.usingFieldsComparator(Price.class, "dish", "restaurant");
    public static TestMatcher<Price> PRICE_MATCHER_NO_IGNORE = TestMatcher.usingEquals(Price.class);

    public final static Price PRICE_1 = new Price(100000023L, LocalDate.parse("2020-06-01"), BigDecimal.valueOf(290, 2));
    public final static Price PRICE_2 = new Price(100000024L, LocalDate.parse("2020-06-01"), BigDecimal.valueOf(890, 2));
    public final static Price PRICE_3 = new Price(100000025L, LocalDate.parse("2020-06-02"), BigDecimal.valueOf(840, 2));
    public final static Price PRICE_4 = new Price(100000026L, LocalDate.parse("2020-06-02"), BigDecimal.valueOf(299, 2));
    public final static Price PRICE_5 = new Price(100000027L, LocalDate.parse("2020-06-03"), BigDecimal.valueOf(410, 2));
    public final static Price PRICE_6 = new Price(100000028L, LocalDate.parse("2020-06-03"), BigDecimal.valueOf(550, 2));
    public final static Price PRICE_7 = new Price(100000029L, LocalDate.parse("2020-06-01"), BigDecimal.valueOf(990, 2));
    public final static Price PRICE_8 = new Price(100000030L, LocalDate.parse("2020-06-01"), BigDecimal.valueOf(150, 2));
    public final static Price PRICE_9 = new Price(100000031L, LocalDate.parse("2020-06-02"), BigDecimal.valueOf(112, 2));
    public final static Price PRICE_10 = new Price(100000032L, LocalDate.parse("2020-06-02"), BigDecimal.valueOf(57, 2));
    public final static Price PRICE_11 = new Price(100000033L, LocalDate.parse("2020-06-03"), BigDecimal.valueOf(130, 2));
    public final static Price PRICE_12 = new Price(100000034L, LocalDate.parse("2020-06-03"), BigDecimal.valueOf(1020, 2));
    public final static Price PRICE_13 = new Price(100000035L, LocalDate.parse("2020-06-01"), BigDecimal.valueOf(1399, 2));
    public final static Price PRICE_14 = new Price(100000036L, LocalDate.parse("2020-06-01"), BigDecimal.valueOf(199, 2));
    public final static Price PRICE_15 = new Price(100000037L, LocalDate.parse("2020-06-02"), BigDecimal.valueOf(399, 2));
    public final static Price PRICE_16 = new Price(100000038L, LocalDate.parse("2020-06-02"), BigDecimal.valueOf(299, 2));
    public final static Price PRICE_17 = new Price(100000039L, LocalDate.parse("2020-06-03"), BigDecimal.valueOf(899, 2));
    public final static Price PRICE_18 = new Price(100000040L, LocalDate.parse("2020-06-03"), BigDecimal.valueOf(99, 2));

    public static List<Price> ALL_PRICES = List.of(PRICE_1, PRICE_2, PRICE_3, PRICE_4, PRICE_5, PRICE_6, PRICE_7, PRICE_8, PRICE_9, PRICE_10,
            PRICE_11, PRICE_12, PRICE_13, PRICE_14, PRICE_15, PRICE_16, PRICE_17, PRICE_18);

    public  static List<Price> DATE_REST_PRICES = List.of(PRICE_1, PRICE_2);

    public static List<Price> REST_PRICES = List.of(PRICE_7, PRICE_8, PRICE_9, PRICE_10, PRICE_11, PRICE_12);


    public static Price getNewPrice() {
        return new Price(null, LocalDate.parse("2020-06-15"), BigDecimal.valueOf(0.09));
    }

    public static Price getNewPriceWithId() {
        return new Price(99999999L,  LocalDate.parse("2020-06-15"), BigDecimal.valueOf(1, 2));
    }

//
//    public final static Price PRICE_1 = new Price(100000023L, LocalDate.parse("2020-06-01"), Money.of(2.90, "USD"));
//    public final static Price PRICE_2 = new Price(100000024L, LocalDate.parse("2020-06-01"), Money.of(8.90, "USD"));
//    public final static Price PRICE_3 = new Price(100000025L, LocalDate.parse("2020-06-02"), Money.of(8.40, "USD"));
//    public final static Price PRICE_4 = new Price(100000026L, LocalDate.parse("2020-06-02"), Money.of(2.99, "USD"));
//    public final static Price PRICE_5 = new Price(100000027L, LocalDate.parse("2020-06-03"), Money.of(4.10, "USD"));
//    public final static Price PRICE_6 = new Price(100000028L, LocalDate.parse("2020-06-03"), Money.of(5.50, "USD"));
//    public final static Price PRICE_7 = new Price(100000029L, LocalDate.parse("2020-06-01"), Money.of(9.90, "USD"));
//    public final static Price PRICE_8 = new Price(100000030L, LocalDate.parse("2020-06-01"), Money.of(1.50, "USD"));
//    public final static Price PRICE_9 = new Price(100000031L, LocalDate.parse("2020-06-02"), Money.of(1.12, "USD"));
//    public final static Price PRICE_10 = new Price(100000032L, LocalDate.parse("2020-06-02"), Money.of(0.57, "USD"));
//    public final static Price PRICE_11 = new Price(100000033L, LocalDate.parse("2020-06-03"), Money.of(1.30, "USD"));
//    public final static Price PRICE_12 = new Price(100000034L, LocalDate.parse("2020-06-03"), Money.of(10.20, "USD"));
//    public final static Price PRICE_13 = new Price(100000035L, LocalDate.parse("2020-06-01"), Money.of(13.99, "USD"));
//    public final static Price PRICE_14 = new Price(100000036L, LocalDate.parse("2020-06-01"), Money.of(1.99, "USD"));
//    public final static Price PRICE_15 = new Price(100000037L, LocalDate.parse("2020-06-02"), Money.of(3.99, "USD"));
//    public final static Price PRICE_16 = new Price(100000038L, LocalDate.parse("2020-06-02"), Money.of(2.99, "USD"));
//    public final static Price PRICE_17 = new Price(100000039L, LocalDate.parse("2020-06-03"), Money.of(8.99, "USD"));
//    public final static Price PRICE_18 = new Price(100000040L, LocalDate.parse("2020-06-03"), Money.of(0.99, "USD"));


}
