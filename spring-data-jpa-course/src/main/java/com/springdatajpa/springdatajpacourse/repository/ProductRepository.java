package com.springdatajpa.springdatajpacourse.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springdatajpa.springdatajpacourse.entity.Product;

public interface ProductRepository  extends JpaRepository<Product,Long>{

}
