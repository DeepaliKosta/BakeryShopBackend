package com.bakeryShop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bakeryShop.Exception.EmailOrPasswordInvalidException;
import com.bakeryShop.entity.AdminLogin;


@RestController
@RequestMapping("api/v1/admin/")
public class AdminController {

	@PostMapping("/login")
	public String checkLogin(@RequestBody AdminLogin adminLogin) throws EmailOrPasswordInvalidException {
		if(!(adminLogin.getEmail().equals("admin") && adminLogin.getPassword().equals("admin"))) {
			throw new EmailOrPasswordInvalidException("Your email or password is invalid");
		}
		return "Login Success";
	}
	 
	 
}
