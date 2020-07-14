package ru.topjava.estimate;

import ru.topjava.estimate.model.MenuItem;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class MenuItemTestData {

    public static TestMatcher<MenuItem> MENU_ITEM_MATCHER = TestMatcher.usingFieldsComparator(MenuItem.class, "dish", "restaurant");
    public static TestMatcher<MenuItem> MENU_ITEM_MATCHER_NO_IGNORE = TestMatcher.usingEquals(MenuItem.class);

    public final static MenuItem MENU_ITEM_1 = new MenuItem(100000023L, LocalDate.parse("2020-06-01"), BigDecimal.valueOf(290, 2));
    public final static MenuItem MENU_ITEM_2 = new MenuItem(100000024L, LocalDate.parse("2020-06-01"), BigDecimal.valueOf(890, 2));
    public final static MenuItem MENU_ITEM_3 = new MenuItem(100000025L, LocalDate.parse("2020-06-02"), BigDecimal.valueOf(840, 2));
    public final static MenuItem MENU_ITEM_4 = new MenuItem(100000026L, LocalDate.parse("2020-06-02"), BigDecimal.valueOf(299, 2));
    public final static MenuItem MENU_ITEM_5 = new MenuItem(100000027L, LocalDate.parse("2020-06-03"), BigDecimal.valueOf(410, 2));
    public final static MenuItem MENU_ITEM_6 = new MenuItem(100000028L, LocalDate.parse("2020-06-03"), BigDecimal.valueOf(550, 2));
    public final static MenuItem MENU_ITEM_7 = new MenuItem(100000029L, LocalDate.parse("2020-06-01"), BigDecimal.valueOf(990, 2));
    public final static MenuItem MENU_ITEM_8 = new MenuItem(100000030L, LocalDate.parse("2020-06-01"), BigDecimal.valueOf(150, 2));
    public final static MenuItem MENU_ITEM_9 = new MenuItem(100000031L, LocalDate.parse("2020-06-02"), BigDecimal.valueOf(112, 2));
    public final static MenuItem MENU_ITEM_10 = new MenuItem(100000032L, LocalDate.parse("2020-06-02"), BigDecimal.valueOf(57, 2));
    public final static MenuItem MENU_ITEM_11 = new MenuItem(100000033L, LocalDate.parse("2020-06-03"), BigDecimal.valueOf(130, 2));
    public final static MenuItem MENU_ITEM_12 = new MenuItem(100000034L, LocalDate.parse("2020-06-03"), BigDecimal.valueOf(1020, 2));
    public final static MenuItem MENU_ITEM_13 = new MenuItem(100000035L, LocalDate.parse("2020-06-01"), BigDecimal.valueOf(1399, 2));
    public final static MenuItem MENU_ITEM_14 = new MenuItem(100000036L, LocalDate.parse("2020-06-01"), BigDecimal.valueOf(199, 2));
    public final static MenuItem MENU_ITEM_15 = new MenuItem(100000037L, LocalDate.parse("2020-06-02"), BigDecimal.valueOf(399, 2));
    public final static MenuItem MENU_ITEM_16 = new MenuItem(100000038L, LocalDate.parse("2020-06-02"), BigDecimal.valueOf(299, 2));
    public final static MenuItem MENU_ITEM_17 = new MenuItem(100000039L, LocalDate.parse("2020-06-03"), BigDecimal.valueOf(899, 2));
    public final static MenuItem MENU_ITEM_18 = new MenuItem(100000040L, LocalDate.parse("2020-06-03"), BigDecimal.valueOf(99, 2));

    public static List<MenuItem> ALL_MENU_ITEMS = List.of(MENU_ITEM_1, MENU_ITEM_2, MENU_ITEM_3, MENU_ITEM_4, MENU_ITEM_5, MENU_ITEM_6, MENU_ITEM_7, MENU_ITEM_8, MENU_ITEM_9, MENU_ITEM_10,
            MENU_ITEM_11, MENU_ITEM_12, MENU_ITEM_13, MENU_ITEM_14, MENU_ITEM_15, MENU_ITEM_16, MENU_ITEM_17, MENU_ITEM_18);

    public  static List<MenuItem> DATE_REST_MENU_ITEMS = List.of(MENU_ITEM_1, MENU_ITEM_2);

    public static List<MenuItem> REST_MENU_ITEMS = List.of(MENU_ITEM_7, MENU_ITEM_8, MENU_ITEM_9, MENU_ITEM_10, MENU_ITEM_11, MENU_ITEM_12);


    public static MenuItem getNewPrice() {
        return new MenuItem(null, LocalDate.parse("2020-06-15"), BigDecimal.valueOf(0.09));
    }

    public static MenuItem getNewPriceWithId() {
        return new MenuItem(99999999L,  LocalDate.parse("2020-06-15"), BigDecimal.valueOf(1, 2));
    }

//
//    public final static Price MENU_ITEM_1 = new Price(100000023L, LocalDate.parse("2020-06-01"), Money.of(2.90, "USD"));
//    public final static Price MENU_ITEM_2 = new Price(100000024L, LocalDate.parse("2020-06-01"), Money.of(8.90, "USD"));
//    public final static Price MENU_ITEM_3 = new Price(100000025L, LocalDate.parse("2020-06-02"), Money.of(8.40, "USD"));
//    public final static Price MENU_ITEM_4 = new Price(100000026L, LocalDate.parse("2020-06-02"), Money.of(2.99, "USD"));
//    public final static Price MENU_ITEM_5 = new Price(100000027L, LocalDate.parse("2020-06-03"), Money.of(4.10, "USD"));
//    public final static Price MENU_ITEM_6 = new Price(100000028L, LocalDate.parse("2020-06-03"), Money.of(5.50, "USD"));
//    public final static Price MENU_ITEM_7 = new Price(100000029L, LocalDate.parse("2020-06-01"), Money.of(9.90, "USD"));
//    public final static Price MENU_ITEM_8 = new Price(100000030L, LocalDate.parse("2020-06-01"), Money.of(1.50, "USD"));
//    public final static Price MENU_ITEM_9 = new Price(100000031L, LocalDate.parse("2020-06-02"), Money.of(1.12, "USD"));
//    public final static Price MENU_ITEM_10 = new Price(100000032L, LocalDate.parse("2020-06-02"), Money.of(0.57, "USD"));
//    public final static Price MENU_ITEM_11 = new Price(100000033L, LocalDate.parse("2020-06-03"), Money.of(1.30, "USD"));
//    public final static Price MENU_ITEM_12 = new Price(100000034L, LocalDate.parse("2020-06-03"), Money.of(10.20, "USD"));
//    public final static Price MENU_ITEM_13 = new Price(100000035L, LocalDate.parse("2020-06-01"), Money.of(13.99, "USD"));
//    public final static Price MENU_ITEM_14 = new Price(100000036L, LocalDate.parse("2020-06-01"), Money.of(1.99, "USD"));
//    public final static Price MENU_ITEM_15 = new Price(100000037L, LocalDate.parse("2020-06-02"), Money.of(3.99, "USD"));
//    public final static Price MENU_ITEM_16 = new Price(100000038L, LocalDate.parse("2020-06-02"), Money.of(2.99, "USD"));
//    public final static Price MENU_ITEM_17 = new Price(100000039L, LocalDate.parse("2020-06-03"), Money.of(8.99, "USD"));
//    public final static Price MENU_ITEM_18 = new Price(100000040L, LocalDate.parse("2020-06-03"), Money.of(0.99, "USD"));


}
