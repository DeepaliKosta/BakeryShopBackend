package com.bakeryShop.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name="Customer")
@NoArgsConstructor
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@NotBlank(message = "Name is mandatory")
	private String name;
	
	@NotBlank(message = "Email is mandatory")
	private String email;
	
	@NotBlank(message = "Password is mandatory")
	private String password;
	
	
	private boolean isLoggedIn;
	
	
	public Customer(int id, String name, String email, String password) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
	}



	@OneToOne(cascade = CascadeType.ALL)
	private Cart cart;
}
