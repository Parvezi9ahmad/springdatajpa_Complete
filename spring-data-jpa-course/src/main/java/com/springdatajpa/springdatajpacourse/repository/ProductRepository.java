package com.springdatajpa.springdatajpacourse.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springdatajpa.springdatajpacourse.entity.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {

    public Product findByName(String name);

    Optional<Product> findById(Long id);

    List<Product> findByNameOrDescription(String name, String description);

    List<Product> findByNameAndDescription(String name, String description);

    Product findDistinctByName(String name);

    List<Product> findByPriceGreaterThan(BigDecimal price);

    List<Product> findByPriceLessThan(BigDecimal price);

    List<Product> findByNameContaining(String name);

    List<Product> findByNameLike(String name);

    List<Product> findByPriceBetween(BigDecimal startPrice, BigDecimal endPrice);

    List<Product> findByDateCreatedBetween(LocalDateTime startDate, LocalDateTime endDate);

    List<Product> findByNameIn(List<String> names);

    List<Product> findFirst2ByOrderByNameAsc();

    List<Product> findTop3ByOrderByPriceDesc();

    @Query("SELECT p from Product p where p.name=?1 or p.description=?2")
    Product findByNameOrDescriptionJpqlIndexParam(String name, String description);

    @Query("SELECT p from Product p where p.name=:name or p.description=:description")
    Product findByNameOrDescriptionJpqlNameParam(@Param("name") String name, @Param("description") String description);

    @Query(value = "select * from products p where p.name=?1 or p.description=?2", nativeQuery = true)
    Product findByNameOrDescriptionSqlIndexParam(String name, String description);

    @Query(value = "select * from Products p where p.name=:name or p.description=:description", nativeQuery = true)
    Product findByNameOrDescriptionSqlNamedParam(String name, String description);

    Product findByPrice(@Param("price") BigDecimal price);

    List<Product> findAllOrderByNameDesc();

    @Query(nativeQuery = true)
    Product findByDescription(@Param("description") String description);

    @Query(nativeQuery = true)
    List<Product> findAllOrderByNameAsc();

}
