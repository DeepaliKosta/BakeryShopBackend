package com.bakeryShop.entity;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class CustomerLogin {
	
	@NotBlank(message = "Email is mandatory")
	private String email;
	
	@NotBlank(message = "Password is mandatory")
	private String password;

}
