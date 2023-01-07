package com.springdatajpa.springdatajpacourse.repository;

import com.springdatajpa.springdatajpacourse.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.util.List;

@SpringBootTest
public class PaginationAndSortingTest {
    @Autowired
    private ProductRepository productRepository;

    @Test
    void Pagination() {
        int pageNo = 0;
        int pageSize = 5;

        //create pagable object
        PageRequest pagable = PageRequest.of(pageNo, pageSize);

        //pass pagable object to findall method
        Page<Product> page = productRepository.findAll(pagable);

        List<Product> product = page.getContent();

        product.forEach(p -> {
            System.out.println(p);
        });
        //total page
        int totalPages = page.getTotalPages();

        //total element
        long totalElements = page.getTotalElements();

        //number of elements
        int numberOfElements = page.getNumberOfElements();

        //size
        int size = page.getSize();

        //last
        boolean last = page.isLast();

        //first
        boolean first = page.isFirst();

        System.out.println("totalPages  >" + totalPages);
        System.out.println("totalElements  >" + totalElements);
        System.out.println("numberOfElements   >" + numberOfElements);
        System.out.println("size  >" + size);
        System.out.println("last  >" + last);
        System.out.println("first   >" + first);
    }

    @Test
    void sorting() {

        String sortBy = "price";
        String sortDir = "asc";
        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();

        List<Product> products = productRepository.findAll(sort);
        products.forEach(p -> {
            System.out.println(p);
        });
    }

    @Test
    void SortMultipleFields() {
        String sortByname = "name";
        String sortByDesc = "description";
        String sortDir = "asc";
        Sort sortName = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortByname).ascending() : Sort.by(sortByname).descending();

        Sort sortDescription = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortByDesc).ascending() : Sort.by(sortByDesc).descending();

        Sort sort = sortDescription.and(sortName);
        List<Product> products = productRepository.findAll(sort);
        products.forEach(p -> {
            System.out.println(p);
        });
    }

    @Test
    void PaginationAndSortingTogether() {
        String sortBy = "name";
        String sortDir = "asc";
        int pageNo = 0;
        int pageSize = 5;

        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
        PageRequest pagable = PageRequest.of(pageNo, pageSize, sort);
        Page<Product> page = productRepository.findAll(pagable);
        List<Product> products = page.getContent();
        products.forEach(p -> {
            System.out.println(p);
        });
    }

    @Test
    void paginationAndSortMultipleFields() {
        String sortbyname = "name";
        String sortbyprice = "price";
        String sortDir = "asc";
        int pageNo = 0;
        int pageSize = 5;
        Sort sortName = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortbyname).ascending() : Sort.by(sortbyname).ascending();
        Sort sortPrice = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortbyprice).ascending() : Sort.by(sortbyprice).descending();
        Sort groupSort = sortPrice.and(sortName);

        PageRequest pagable = PageRequest.of(pageNo, pageSize, groupSort);
        Page<Product> page = productRepository.findAll(pagable);
        List<Product> products = page.getContent();

        products.forEach(p->{
            System.out.println(p);
        });

    }
}
