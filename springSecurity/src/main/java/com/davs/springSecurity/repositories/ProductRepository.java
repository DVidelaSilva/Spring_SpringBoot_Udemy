package com.davs.springSecurity.repositories;

import org.springframework.data.repository.CrudRepository;

import com.davs.springSecurity.entities.Product;



public interface ProductRepository extends CrudRepository<Product, Long> {
    boolean existsBySku(String sku);
}
