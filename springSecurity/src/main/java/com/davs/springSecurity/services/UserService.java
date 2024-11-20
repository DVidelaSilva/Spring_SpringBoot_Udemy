package com.davs.springSecurity.services;

import java.util.List;

import com.davs.springSecurity.entities.User;

public interface UserService {

    List<User> findAll();

    User save(User user);

    boolean existsByUsername(String username);


}
