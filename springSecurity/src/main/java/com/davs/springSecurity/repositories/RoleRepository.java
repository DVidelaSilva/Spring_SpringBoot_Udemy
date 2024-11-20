package com.davs.springSecurity.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.davs.springSecurity.entities.Role;

public interface RoleRepository extends CrudRepository<Role, Long>{

    Optional<Role> findByName(String name);

}
