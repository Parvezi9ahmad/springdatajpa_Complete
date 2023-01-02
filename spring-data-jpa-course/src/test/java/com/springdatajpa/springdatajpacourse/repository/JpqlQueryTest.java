package com.springdatajpa.springdatajpacourse.repository;

import com.springdatajpa.springdatajpacourse.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class JpqlQueryTest {

    @Autowired
    private ProductRepository productRepository;

    @Test
    void findBynameOrDescriptionJpqlIndexParamMethod(){
        Product product = productRepository.findByNameOrDescriptionJpqlIndexParam("product 2", "product 2 description");
        System.out.println(product.getId());
        System.out.println(product.getName());
    }

    @Test
    void findByNameOrDescriptionJpqlNamedParamMethod(){
        Product product = productRepository.findByNameOrDescriptionJpqlNameParam("product 2", "product 2 description");
        System.out.println(product.getId());
        System.out.println(product.getName());
    }


}
