package com.bakeryShop.respoitory;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bakeryShop.entity.Cart;

public interface CartRepository extends JpaRepository<Cart, Integer> {

}
