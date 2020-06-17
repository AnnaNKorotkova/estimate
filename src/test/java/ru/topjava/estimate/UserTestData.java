package ru.topjava.estimate;

import ru.topjava.estimate.model.Role;
import ru.topjava.estimate.model.User;

public class UserTestData {

    public final static User USER = new User(100000000L, "User", "user@yandex.ru", "password", Role.USER);
    public final static User ADMIN = new User(100000001L, "Admin", "admin@gmail.com", "admin", Role.USER, Role.ADMIN);

}
