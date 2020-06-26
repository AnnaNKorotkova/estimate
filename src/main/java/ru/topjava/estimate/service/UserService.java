package ru.topjava.estimate.service;

import ru.topjava.estimate.model.User;

import java.util.List;

public interface UserService {

    User register(User user);

    void delete(Long id);

    User get(Long id);

    User findByEmail(String email);

    List<User> getAll();
}
