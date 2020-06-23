package ru.topjava.estimate.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import ru.topjava.estimate.Exeption.NotFoundException;
import ru.topjava.estimate.model.User;
import ru.topjava.estimate.repository.UserRepository;
import ru.topjava.estimate.service.UserService;

import java.util.List;

@Service
@Slf4j
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional
    public User register(User user) {
        Assert.notNull(user, "user must not be null");
        log.info("register user {}", user.getName());
        return userRepository.save(user);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        Assert.notNull(id, "user must not be null");
        log.info("delete user {}", id);
        userRepository.deleteById(id);
    }

    @Override
    @Transactional
    public User get(Long id) {
        User user =  userRepository.findById(id).orElseThrow(NotFoundException::new);
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
