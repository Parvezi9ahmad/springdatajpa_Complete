package com.springdatajpa.springdatajpacourse.repository;

import com.springdatajpa.springdatajpacourse.entity.Address;
import com.springdatajpa.springdatajpacourse.entity.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

@SpringBootTest
public class OneToOneBiDirectionalMappingtest {

    @Autowired
    private AddressRepository addressRepository;

    @Test
    void savedAddressMethod() {
        Order order = new Order();
        order.setOrderTrackingNumber("1000ABC");
        order.setStatus("IN PROGRESS");
        order.setTotalQuantity(5);
        order.setTotalPrice(new BigDecimal(1000));

        Address address = new Address();
        address.setCity("Pune");
        address.setState("Maharashtra");
        address.setCountry("India");
        address.setStreet("Kothrud");
        address.setZipcode("411047");

        order.setBilingAddress(address);
        address.setOrder(order);

        Address savedAddress = addressRepository.save(address);
        System.out.println(savedAddress);
    }
    @Test
    void updateAddressMethod(){
        Address address = addressRepository.findById(1L).get();
        address.setZipcode("411047");
        address.getOrder().setStatus("DELIVERED");
        Address updated = addressRepository.save(address);
        System.out.println(updated);
    }

    @Test
    void deleteAddressMethod(){
         addressRepository.deleteById(1L);
    }
}
