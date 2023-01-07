package com.springdatajpa.springdatajpacourse.repository;

import com.springdatajpa.springdatajpacourse.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class NativeSqlQuerytest {
    @Autowired
    private ProductRepository productRepository;

    @Test
    void findBynameOrDescriptionSqlIndexParamMethod() {
        Product product = productRepository.findByNameOrDescriptionSqlIndexParam("product 2", "product 2 description");
        System.out.println(product.getId());
        System.out.println(product.getName());
    }

    @Test
    void findBynameOrDescriptionSqlNamedParamMethod() {
        Product product = productRepository.findByNameOrDescriptionSqlNamedParam("product 2", "product 2 description");
        System.out.println(product.getId());
        System.out.println(product.getName());
        System.out.println(product.getDescription());
    }
}
