package ru.topjava.estimate;

import org.javamoney.moneta.Money;
import ru.topjava.estimate.model.Price;

import java.time.LocalDate;

public class PriceTestData {

    public final static Price PRICE_1 = new Price(100000023L, LocalDate.parse("2020-06-01"), Money.of(2.90, "USD"));
    public final static Price PRICE_2 = new Price(100000024L, LocalDate.parse("2020-06-01"), Money.of(8.90, "USD"));
    public final static Price PRICE_3 = new Price(100000025L, LocalDate.parse("2020-06-02"), Money.of(8.40, "USD"));
    public final static Price PRICE_4 = new Price(100000026L, LocalDate.parse("2020-06-02"), Money.of(2.99, "USD"));
    public final static Price PRICE_5 = new Price(100000027L, LocalDate.parse("2020-06-03"), Money.of(4.10, "USD"));
    public final static Price PRICE_6 = new Price(100000028L, LocalDate.parse("2020-06-03"), Money.of(5.50, "USD"));
    public final static Price PRICE_7 = new Price(100000029L, LocalDate.parse("2020-06-01"), Money.of(9.90, "USD"));
    public final static Price PRICE_8 = new Price(100000030L, LocalDate.parse("2020-06-01"), Money.of(1.50, "USD"));
    public final static Price PRICE_9 = new Price(100000031L, LocalDate.parse("2020-06-02"), Money.of(1.12, "USD"));
    public final static Price PRICE_10 = new Price(100000032L, LocalDate.parse("2020-06-02"), Money.of(0.57, "USD"));
    public final static Price PRICE_11 = new Price(100000033L, LocalDate.parse("2020-06-03"), Money.of(1.30, "USD"));
    public final static Price PRICE_12 = new Price(100000034L, LocalDate.parse("2020-06-03"), Money.of(10.20, "USD"));
    public final static Price PRICE_13 = new Price(100000035L, LocalDate.parse("2020-06-01"), Money.of(13.99, "USD"));
    public final static Price PRICE_14 = new Price(100000036L, LocalDate.parse("2020-06-01"), Money.of(1.99, "USD"));
    public final static Price PRICE_15 = new Price(100000037L, LocalDate.parse("2020-06-02"), Money.of(3.99, "USD"));
    public final static Price PRICE_16 = new Price(100000038L, LocalDate.parse("2020-06-02"), Money.of(2.99, "USD"));
    public final static Price PRICE_17 = new Price(100000039L, LocalDate.parse("2020-06-03"), Money.of(8.99, "USD"));
    public final static Price PRICE_18 = new Price(100000040L, LocalDate.parse("2020-06-03"), Money.of(0.99, "USD"));


}
