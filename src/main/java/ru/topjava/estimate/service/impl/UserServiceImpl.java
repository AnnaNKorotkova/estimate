package ru.topjava.estimate.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import ru.topjava.estimate.model.User;
import ru.topjava.estimate.repository.UserRepository;
import ru.topjava.estimate.service.UserService;

import java.util.List;

import static ru.topjava.estimate.util.ValidationUtil.checkNotFoundWithId;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User register(User user) {
        Assert.notNull(user, "user must not be null");
        log.info("register user {}", user.getName());
        return userRepository.save(user);
    }

    @Override
    public void delete(User user) {
        Assert.notNull(user, "user must not be null");
        log.info("delete user {}", user.getName());
        userRepository.delete(user);
    }

    @Override
    public User get(long id) {
        User user =  checkNotFoundWithId(userRepository.getOne(id), id);
        log.info("get user {}", id);
        return user;
    }

    @Override
    public List<User> getAll() {
        List<User> list = userRepository.findAll();
        log.info("getAll, find {} rows", list.size());
        return list;
    }
}
