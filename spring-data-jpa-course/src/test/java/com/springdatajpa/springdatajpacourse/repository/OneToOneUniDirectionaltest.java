package com.springdatajpa.springdatajpacourse.repository;

import com.springdatajpa.springdatajpacourse.entity.Address;
import com.springdatajpa.springdatajpacourse.entity.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

//@SpringBootTest
public class OneToOneUniDirectionaltest {

   // @Autowired
   // private OrderRepository orderRepository;

  //  @Test
    void saveOrdermethod(){
        /*Order order=new Order();
        order.setOrderTrackingNumber("1000ABC");
        order.setTotalQuantity(5);
        order.setStatus("IN PROGRESS");
        order.setTotalPrice(new BigDecimal(1000));

        Address address=new Address();
        address.setCity("Pune");
        address.setStreet("Kothrud");
        address.setState("Maharashtra");
        address.setCountry("India");
        address.setZipcode("411847");*/

       // order.setBillingAddress(address);

      //  orderRepository.save(order);
    }

  // @Test
    void updateOrderMethod(){
       /*  Order order = orderRepository.findById(1L).get();
         order.setStatus("DELIVERED");
         order.getBillingAddress().setZipcode("411087");
         orderRepository.save(order);*/
    }

   // @Test
    void getOrderMethod(){
       /* Order order = orderRepository.findById(2L).get();
        System.out.println(order.toString());*/
    }

   // @Test
    void deleteOrderMethod(){
       // orderRepository.deleteById(1L);
    }
}
