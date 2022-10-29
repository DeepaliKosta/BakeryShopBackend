package com.bakeryShop.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Data
@AllArgsConstructor
@Table(name="AdminLogin")
public class Admin {
	
	@Id
	private int Id;
	private String email;
	private String password;

}
