package com.curso.spring.springboot_web;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@Configuration
@PropertySources({
    //@PropertySource(value="classpath:values.properties")
    @PropertySource(value="classpath:values.properties", encoding = "UTF-8")
    ///@PropertySource("classpath:values2.properties")
})
public class ValuesConfig {


}
