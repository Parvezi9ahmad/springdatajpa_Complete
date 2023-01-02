package com.springdatajpa.springdatajpacourse.repository;

import com.springdatajpa.springdatajpacourse.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

@SpringBootTest
public class NamedQueryTest {
    @Autowired
    private ProductRepository productRepository;

    @Test
    void findByPriceTest(){
         Product product = productRepository.findByPrice(new BigDecimal(200));
        System.out.println(product.getId());
        System.out.println(product.getName());
    }

    @Test
    void namedJpqlQueries(){
        List<Product> product = productRepository.findAllOrderByNameDesc();
        product.forEach(p->{
            System.out.println(p.getId());
            System.out.println(p.getName());

        });
        Product product1 = productRepository.findByPrice(new BigDecimal(200));
        System.out.println(product1.getId());
        System.out.println(product1.getName());

    }

    @Test
    void namedNativeSqlQuery(){
        Product product = productRepository.findByDescription("product 3 description");
        System.out.println(product.getId());
        System.out.println(product.getName());
        System.out.println(product.getDescription());
    }

    @Test
    void namedNativeQueries(){
      List<Product> product = productRepository.findAllOrderByNameAsc();
      product.forEach(p->{
          System.out.println(p.getId());
          System.out.println(p.getName());
      });

         Product product1 = productRepository.findByDescription("product 3 description");
        System.out.println(product1.getId());
        System.out.println(product1.getName());
    }
}
