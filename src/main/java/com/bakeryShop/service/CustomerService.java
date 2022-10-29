package com.bakeryShop.service;

import java.util.List;

import com.bakeryShop.Exception.EmailIdAlreadyExistsException;
import com.bakeryShop.Exception.NotFoundException;
import com.bakeryShop.entity.Customer;
import com.bakeryShop.entity.CustomerLogin;

public interface CustomerService {

	Customer customerRegister(Customer customer) throws EmailIdAlreadyExistsException;

	Customer customerLogin(CustomerLogin customerLogin) throws NotFoundException;

    List<Customer> getAllCustomers() throws NotFoundException;

	String deleteCustomer(int id) throws NotFoundException;

	Customer customerLogout(CustomerLogin customerLogin) throws NotFoundException;

	Customer logout(int id);

	boolean isCustomerLoggedIn(int id);

}
