package com.DAVS.proyecto_DI_Facturas;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;

import com.DAVS.proyecto_DI_Facturas.models.Item;
import com.DAVS.proyecto_DI_Facturas.models.Product;

@Configuration
@PropertySource(value = "classpath:data.properties", encoding = "UTF-8")
public class AppConfig {

    @Bean
    List<Item> itemsInvoice(){
        Product p1 = new Product("Camara Sony", 800);
        Product p2 = new Product("Bicicleta Bianchi 26", 1200);

        List<Item> items = Arrays.asList(new Item(p1, 2), new Item(p2, 4));
        
        return items;
    }

    @Primary
    @Bean
    List<Item> itemsInvoiceOffice(){
        Product p1 = new Product("Monitor Asus 24", 700);
        Product p2 = new Product("Notebook Raizer", 2400);
        Product p3 = new Product("Impresora HP", 800);
        Product p4 = new Product("Escritorio Oficina", 900);

        List<Item> items = Arrays.asList(new Item(p1, 4), new Item(p2, 6), new Item(p3, 1), new Item(p4, 4));
        
        return items;
    }
    
    

}
