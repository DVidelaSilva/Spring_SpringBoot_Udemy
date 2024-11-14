package com.davs.springboot.springboot_di.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.davs.springboot.springboot_di.models.Product;
import com.davs.springboot.springboot_di.repositories.ProductRepository;


@Service
public class ProductServiceImpl implements ProductService {
    

    private ProductRepository repository;

    // //INYECCION metodo Set
    // @Autowired
    // public void setRepository(ProductRepository repository) {
    //     this.repository = repository;
    // }
    
    public ProductServiceImpl(ProductRepository repository) {
        this.repository = repository;
    }
    

    @Override
    public List<Product> findAll(){
        return repository.findAll().stream().map(p -> {
            Double priceTax = p.getPrice() * 1.25d;
            // Product newProd = new Product(p.getId(), p.getName(), priceTax.longValue());
            Product newProd = (Product) p.clone();
            newProd.setPrice(priceTax.longValue());
            return newProd;
        }).collect(Collectors.toList());
    }


    @Override
    public Product findById(Long id){
        return repository.findById(id);
    }




}
