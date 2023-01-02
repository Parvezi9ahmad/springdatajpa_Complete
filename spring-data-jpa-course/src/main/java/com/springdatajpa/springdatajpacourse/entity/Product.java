package com.springdatajpa.springdatajpacourse.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.annotation.Generated;
import javax.persistence.*;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
/*@NamedQuery(name="Product.findByPrice",
query="SELECT p from Product p where p.price=:price")*/
@NamedQueries(
		{
				@NamedQuery(name="Product.findAllOrderByNameDesc",
				query="SELECT p from Product p ORDER By p.name DESC"
				),
				@NamedQuery(name="Product.findByPrice",
				query="SELECT p from Product p where p.price=:price")
		}
)


/*@NamedNativeQuery(
		name="Product.findByDescription",
		query="select * from products p where p.description=:description",
		resultClass = Product.class

)*/

@NamedNativeQueries({
		@NamedNativeQuery(
				name="Product.findByDescription",
				query="select * from products p where p.description=:description",
				resultClass = Product.class

		),
		@NamedNativeQuery(name="Product.findAllOrderByNameAsc",
		query="select * from products Order by name asc ",
		resultClass=Product.class)}
)
@Table(name = "products", schema = "ecommerce", uniqueConstraints = {
		@UniqueConstraint(name = "sku_unique", columnNames = "stock_keeping_unit") })
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,
	generator="product_generator"
	)
	@SequenceGenerator(
			name="product_generator",
			sequenceName ="product_sequence_name"
	)
	private Long id;

	@Column(name = "stock_keeping_unit", nullable = false)
	private String sku;

	@Column(nullable = false)
	private String name;
	private String description;
	private BigDecimal price;
	private boolean active;
	private String imgUrl;

	@CreationTimestamp
	private LocalDateTime dateCreated;

	@UpdateTimestamp
	private LocalDateTime lastUpdated;

}