package com.DAVS.manejoExcepciones.services;

import java.util.List;
import java.util.Optional;

import com.DAVS.manejoExcepciones.models.domain.User;

public interface UserService {

    List<User> findAll();
    
    Optional<User> findById(Long id);


}
