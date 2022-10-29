package com.bakeryShop.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bakeryShop.Exception.EmailIdAlreadyExistsException;
import com.bakeryShop.Exception.NotFoundException;
import com.bakeryShop.entity.Customer;
import com.bakeryShop.entity.CustomerLogin;
import com.bakeryShop.service.CustomerService;

@CrossOrigin(origins="http://localhost:3000")
@RestController
@RequestMapping("api/v1/customer")
public class CustomerController {

	@Autowired
	CustomerService customerService;

	@PostMapping("/register")
	public Customer customerRegister(@Valid @RequestBody Customer customer) throws EmailIdAlreadyExistsException {
	return	customerService.customerRegister(customer);
//		return "Registration successful";
	}

	@PostMapping("/login")
	public Customer customerLogin(@RequestBody CustomerLogin customerLogin) throws NotFoundException {
		Customer customer = customerService.customerLogin(customerLogin);
		return customer;
	}
	
//	@PostMapping("/logout")
//	public Customer customerLogout(@RequestBody CustomerLogin customerLogin) throws NotFoundException {
//		Customer customer = customerService.customerLogout(customerLogin);
//		return customer;
//	}
	
	@PostMapping("/logout/{id}")
	public Customer customerLogout(@PathVariable int id) throws NotFoundException {
		Customer customer = customerService.logout(id);
		return customer;
	}
	
	

	@GetMapping
	public List<Customer> getAllCustomers() throws NotFoundException {
		return customerService.getAllCustomers();
	}
	
	@DeleteMapping("/{id}")
	public String deleteCustomer(@PathVariable int id) throws NotFoundException {
		return customerService.deleteCustomer(id);
	}
	

	@GetMapping("/isLoogedIn/{id}")
	public boolean isCustomerLoggedIn(@PathVariable int id) {
		return customerService.isCustomerLoggedIn(id);
	}

}
