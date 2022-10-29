package com.bakeryShop.respoitory;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bakeryShop.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

	public Customer findByEmailAndPassword(String email,String password);

	public Customer findByEmail(String email);


}
