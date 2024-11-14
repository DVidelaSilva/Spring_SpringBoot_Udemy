package com.davs.springboot.springboot_di.services;

import java.util.List;

import com.davs.springboot.springboot_di.models.Product;

public interface ProductService {

    List<Product> findAll();

    Product findById (Long id);

}
