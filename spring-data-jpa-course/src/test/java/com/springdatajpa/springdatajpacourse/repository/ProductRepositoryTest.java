package com.springdatajpa.springdatajpacourse.repository;

import com.springdatajpa.springdatajpacourse.entity.Product;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class ProductRepositoryTest {

    @Autowired
    private ProductRepository productRepository;

    @Test
    public void save(){
        //create product
        Product product=new Product();
        product.setName("product 1");
        product.setDescription("product 1 desciption");
        product.setSku("100ABCD");
        product.setPrice(new BigDecimal(100));
        product.setActive(true);
        product.setImgUrl("product1.png");

        //save product
         Product savedObject = productRepository.save(product);
        //display product info
        System.out.println(savedObject.getId());
        System.out.println(savedObject.toString());
    }

    @Test
    void updateusingsavemethod(){
        //find product
        Long id=1L;
         Product product = productRepository.findById(id).get();

         //update product
        product.setName("updated product 2");
        product.setDescription("updated product2 description");

        //save product
        productRepository.save(product);

    }

    @Test
    void saveAllMethod(){
        //first object
        Product product=new Product();
        product.setName("product 2");
        product.setDescription("product 2 description");
        product.setSku("200ABCD");
        product.setPrice(new BigDecimal(200));
        product.setActive(true);
        product.setImgUrl("product 2 imp.png");

        //second object
        Product prooduct3=new Product();
        prooduct3.setName("product 3");
        prooduct3.setDescription("product 3 description");
        prooduct3.setSku("100ABCDE");
        prooduct3.setPrice(new BigDecimal(300));
        prooduct3.setActive(true);
        prooduct3.setImgUrl("product 3 img.png");
        List<Product> list=new ArrayList<>();
        list.add(product);
        list.add(prooduct3);
        productRepository.saveAll(List.of(product,prooduct3));

    }

    @Test
    void findAllMethod(){
         List<Product> all = productRepository.findAll();
         all.forEach((p)->{
             System.out.println(p.getName());
         });
    }

    @Test
    void deleteByIdmethod(){
        Long id=1L;
        productRepository.deleteById(id);
    }

    @Test
    void deleteMethod(){
        Long id=2L;
        Product product = productRepository.findById(id).get();
        productRepository.delete(product);
    }

    @Test
    void deleteALlMethod(){
        //productRepository.deleteAll();
         Product product = productRepository.findById(152L).get();
         Product product1 = productRepository.findById(153L).get();
         productRepository.deleteAll(List.of(product,product1));
    }

    @Test
    void existByIdMethod(){
        Long id=202L;
        boolean b = productRepository.existsById(id);
        System.out.println(b);
    }

    @Test
    void countMethod(){
         long count = productRepository.count();
        System.out.println(count);
    }
}