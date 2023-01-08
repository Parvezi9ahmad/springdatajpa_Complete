package com.springdatajpa.springdatajpacourse.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "addresses")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

/*@Data*/
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String street;
    private String city;
    private String state;
    private String country;
    private String zipcode;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="order_id",referencedColumnName = "id")
    private Order order;
}
