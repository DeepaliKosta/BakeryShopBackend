package com.bakeryShop.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name="Product")
@NoArgsConstructor
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private String name;
	
	private long price;
	
	private String photoPath;
	
//	@ManyToMany(mappedBy = "productList")
//	private List<Cart> cartList;

	public Product(int id, String name, long price, String photoPath) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.photoPath = photoPath;
	}
	
	
	
	
}
