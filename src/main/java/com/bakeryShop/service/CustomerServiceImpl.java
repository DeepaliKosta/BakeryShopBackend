package com.bakeryShop.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bakeryShop.Exception.EmailIdAlreadyExistsException;
import com.bakeryShop.Exception.NotFoundException;
import com.bakeryShop.entity.Customer;
import com.bakeryShop.entity.CustomerLogin;
import com.bakeryShop.respoitory.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	CustomerRepository customerRepository;

	@Override
	public Customer customerRegister(Customer customer) throws EmailIdAlreadyExistsException {
		Customer p=customerRepository.findByEmail(customer.getEmail());
		if(p == null) {
			return customerRepository.save(customer);
		}
		else {
			throw new EmailIdAlreadyExistsException("This email is already registered,please Login to continue");
		}
		
	}

	@Override
	public Customer customerLogin(CustomerLogin customerLogin) throws NotFoundException {
	Customer customer=customerRepository.findByEmailAndPassword(customerLogin.getEmail(), customerLogin.getPassword());
		if(customer == null) {
			throw new NotFoundException("Customer with this email is not found");
		}
		customer.setLoggedIn(true);
		customerRepository.save(customer);
		return customer;
	}
	
	@Override
	public Customer customerLogout(CustomerLogin customerLogin) throws NotFoundException {
	Customer customer=customerRepository.findByEmailAndPassword(customerLogin.getEmail(), customerLogin.getPassword());
		if(customer == null) {
			throw new NotFoundException("Customer with this email is not found");
		}
		customer.setLoggedIn(false);
		customerRepository.save(customer);
		return customer;
	}
	
	
	@Override
	public Customer logout(int id)  {
	Customer customer= customerRepository.findById(id).get();
	  
	customer.setLoggedIn(false);
	customerRepository.save(customer);
	return customer;
	
	}
	
	

	@Override
	public List<Customer> getAllCustomers() throws NotFoundException {
		// TODO Auto-generated method stub
		List<Customer> customers= customerRepository.findAll();
		if(customers.isEmpty()) {
			throw new NotFoundException("Customer list is empty");
		}
		return customers;
	}

	@Override
	public String deleteCustomer(int id) throws NotFoundException {
		// TODO Auto-generated method stub
		Optional<Customer> customer =customerRepository.findById(id);
		if(customer.isEmpty()) {
			throw new NotFoundException("Customer with id "+id+" is not found");
		}
		customerRepository.deleteById(id);
		return "Customer with id "+id+" deleted";
	}

	@Override
	public boolean isCustomerLoggedIn(int id) {
		Customer customer =customerRepository.findById(id).get();
	    return customer.isLoggedIn();
		
	}

}
