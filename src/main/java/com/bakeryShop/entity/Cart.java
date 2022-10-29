package com.bakeryShop.entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.bakeryShop.entity.Customer;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "Cart")
@NoArgsConstructor
public class Cart {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

//	@OneToOne( mappedBy ="cart")
//	private Customer customer;

	@ManyToMany
	private List<Product> productList = new ArrayList<>();

//	private Map<Product,Integer> productList=new HashMap<>();

}
