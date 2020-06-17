package ru.topjava.estimate.service;

import ru.topjava.estimate.model.User;

import java.util.List;

public interface UserService {

    User register(User user);

    void delete(User user);

    User get(long id);

    List<User> getAll();
}
