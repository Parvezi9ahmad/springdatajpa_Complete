package com.springdatajpa.springdatajpacourse.entity;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

/*@ToString*/
//@Data
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String orderTrackingNumber;
    private int totalQuantity;
    private BigDecimal totalPrice;
    private String status;

    @CreationTimestamp
    private LocalDateTime dateCreated;

    @UpdateTimestamp
    private LocalDateTime lastUpdated;

    @OneToOne(cascade = CascadeType.ALL,mappedBy = "order")
    private Address bilingAddress;

    //one to one unidirectional mapping
   /* @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="billing_Address_id",referencedColumnName = "id")
    private Address billingAddress;*/
}