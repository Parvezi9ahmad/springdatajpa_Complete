package com.springdatajpa.springdatajpacourse.repository;

import com.springdatajpa.springdatajpacourse.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@SpringBootTest
public class Querymethodest {

    @Autowired
    ProductRepository productRepository;

    @Test
    void findBynametest(){
         Product byName = productRepository.findByName("product 3");
        System.out.println(byName.getName());
        System.out.println(byName.getId());
        System.out.println(byName.getDescription());
    }

    @Test
    void findByidMethod(){
         Product product = productRepository.findById(202L).get();
        System.out.println(product.getName());
    }

    @Test
    void findByNameOrDescriptionMethod(){
         List<Product> products = productRepository.findByNameOrDescription("product 1", "product 1 desciption");
         products.forEach(p->{
             System.out.println(p.getId());
             System.out.println(p.getName());
         });
    }

    @Test
    void findBynameAndDescriptionMethod(){
         List<Product> product = productRepository.findByNameAndDescription("product 1", "product 1 desciption");
         product.forEach(p->{
             System.out.println(p.getId());
             System.out.println(p.getName());
         });
    }

    @Test
    void findDistinctByNameMethod(){
         Product product = productRepository.findDistinctByName("product 2");
        System.out.println(product.getId());
        System.out.println(product.getName());
        System.out.println(product.getDescription());
    }

    @Test
    void findBypriceGreaterThanMethod(){
        List<Product> products = productRepository.findByPriceGreaterThan(new BigDecimal(200));
        products.forEach(p->{
            System.out.println(p.getId());
        });
    }

    @Test
    void findByPriceLessThanMethod(){
        List<Product> products = productRepository.findByPriceLessThan(new BigDecimal(200));
        products.forEach(p->{
            System.out.println(p.getId());
            System.out.println(p.getName());
        });
    }

    @Test
    void findnameContainingMethod(){
         List<Product> product = productRepository.findByNameContaining("product 1");
         product.forEach(p->{
             System.out.println(p.getId());
             System.out.println(p.getName());
         });
    }

    @Test
    void findBynameLikemethod(){
         List<Product> product = productRepository.findByNameLike("product 1");
         product.forEach(p->{
             System.out.println(p.getId());
             System.out.println(p.getName());
         });
    }

    @Test
    void findBypriceBetweenMethod(){
         List<Product> products = productRepository.findByPriceBetween(new BigDecimal(200), new BigDecimal(300));
         products.forEach(p->{
             System.out.println(p.getId());
             System.out.println(p.getName());
             System.out.println(p.getPrice());
         });
    }

    @Test
    void findDateCreatedBetweenMethod(){
        LocalDateTime start = LocalDateTime.of(2022, 12, 22, 14, 5, 22);
         LocalDateTime end = LocalDateTime.of(2022, 12, 22, 14, 8, 37);
         List<Product> products = productRepository.findByDateCreatedBetween(start, end);
         products.forEach(p->{
             System.out.println(p.getId());
             System.out.println(p.getName());
         });
    }

    @Test
    void findByNameInMethod(){
         List<Product> products = productRepository.findByNameIn(List.of("product 1", "product 3"));
         products.forEach(p->{
             System.out.println(p.getId());
             System.out.println(p.getName());
         });
    }

    @Test
    void findFirstOrderBynameMethod(){
       List<Product> products = productRepository.findFirst2ByOrderByNameAsc();
       products.forEach(p->{
           System.out.println(p.getId());
           System.out.println(p.getName());
       });
    }

    @Test
    void findop3ByOrderBymethod(){
        List<Product> products = productRepository.findTop3ByOrderByPriceDesc();
        products.forEach(p->{
            System.out.println(p.getId());
            System.out.println(p.getPrice());
        });
    }
}
