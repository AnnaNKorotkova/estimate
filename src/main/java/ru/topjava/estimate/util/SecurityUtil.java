package ru.topjava.estimate.util;

import ru.topjava.estimate.model.Role;
import ru.topjava.estimate.model.User;

public class SecurityUtil {
    public static User getAuthorizedUser() {
        return new User(100000000L, "User", "user@yandex.ru", "{noop}password", Role.USER);
    }
}
