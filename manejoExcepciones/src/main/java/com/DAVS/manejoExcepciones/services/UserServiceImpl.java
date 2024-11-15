package com.DAVS.manejoExcepciones.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.DAVS.manejoExcepciones.models.domain.User;


@Service
public class UserServiceImpl implements UserService{

    private List<User> users;

    public UserServiceImpl(){
        this.users = new ArrayList<>();
        users.add(new User(1L, "Pepe", "Gonzalez"));
        users.add(new User(2L, "Andrés", "Mena"));
        users.add(new User(3L, "Maria", "Perez"));
        users.add(new User(4L, "Josefa", "Ramirez"));
        users.add(new User(5L, "Ale", "Gutierrez"));
    }


    @Override
    public List<User> findAll() {
        return users;
        
    }

    @Override
    public Optional<User> findById(Long id) {

        User user = null;
        for(User u: users){
            if(u.getId().equals(id)){
                user = u;
                break;
            }
        }

        

        return Optional.ofNullable(user);
        
    }

}
