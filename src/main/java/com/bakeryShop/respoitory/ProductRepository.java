package com.bakeryShop.respoitory;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bakeryShop.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
