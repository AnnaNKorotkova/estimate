package ru.topjava.estimate;

import ru.topjava.estimate.model.Role;
import ru.topjava.estimate.model.User;

public class UserTestData {

   public final static TestMatcher<User> USER_MATCHER = TestMatcher.usingFieldsComparator(User.class, "roles");

    public final static User USER = new User(100000000L, "User", "user@yandex.ru", "{noop}password", Role.USER);
    public final static User ADMIN = new User(100000001L, "Admin", "admin@gmail.com", "{noop}admin", Role.USER, Role.ADMIN);

    public static User getNewUser() {
        return new User(null, "Vasia", "vasia@code.net", "{noop}passsss");
    }

    public static User getNewUserWithId() {
        return new User(99999999L, "Vasia", "vasia@code.net", "{noop}passsss");
    }
}
