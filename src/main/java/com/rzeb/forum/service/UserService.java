package com.rzeb.forum.service;

import java.util.Optional;

import com.rzeb.forum.model.User;

public interface UserService {

    Optional<User> findByUsername(String username);

    Optional<User> findByEmail(String email);

    User save(User user);
}
