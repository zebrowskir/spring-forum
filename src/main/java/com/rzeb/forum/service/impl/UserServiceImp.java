package com.rzeb.forum.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.rzeb.forum.model.User;
import com.rzeb.forum.repository.RoleRepository;
import com.rzeb.forum.repository.UserRepository;
import com.rzeb.forum.service.UserService;

import java.util.Collections;
import java.util.Optional;

@Service
public class UserServiceImp implements UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    private static final String USER_ROLE = "ROLE_USER";

    @Autowired
    public UserServiceImp(UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public User save(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setActive(1);
        // Set role to USER
        user.setRoles(Collections.singletonList(roleRepository.findByRole(USER_ROLE)));
        return userRepository.saveAndFlush(user);
    }
}