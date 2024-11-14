package com.DAVS.proyecto_DI_Facturas.models;

public class Product {


    private String name;
    private Integer price;

    

    public Product(String name, Integer price) {
        this.name = name;
        this.price = price;
    }

    


    public Product() {
    }




    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Integer getPrice() {
        return price;
    }
    public void setPrice(Integer price) {
        this.price = price;
    }


    

}
