package com.bakeryShop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bakeryShop.entity.Cart;
import com.bakeryShop.entity.Customer;
import com.bakeryShop.entity.Product;
import com.bakeryShop.service.CartService;

@CrossOrigin(origins="http://localhost:3000")
@RestController
@RequestMapping("api/v1/cart")
public class CartController {
	
	@Autowired
	CartService cartService;
	
//	@PutMapping("/{userId}")
//	public Cart addToCart(@RequestBody Cart cart,@PathVariable int userId) {
//		return cartService.addToCart(cart,userId);
//	}
	
//	@PutMapping("/{userId}")
//	public Cart addToCart_two(@RequestBody Product product,@PathVariable int userId) {
//		return cartService.addToCart_two(product,userId);
//	}
	
	@PutMapping("/{userId}/addToCart/{productId}")
	public Customer addToCart_two(@PathVariable int productId,@PathVariable int userId) {
		return cartService.addToCart_three(productId,userId);
	}
	
	@DeleteMapping("/{userId}/removeFromCart/{productId}")
	public Customer removeFromCart(@PathVariable int productId,@PathVariable int userId) {
		return cartService.removeFromCart(productId,userId);
	}
	
	@GetMapping("/{userId}")
	public int countItemsInCart(@PathVariable int userId) {
		return cartService.countItemsInCart(userId);
	}
	
	@GetMapping("/totalPrice/{userId}")
	public int totalInCart(@PathVariable int userId) {
		return cartService.totalInCart(userId);
	}
	
	@GetMapping("/yourCart/{userId}")
	public List<Product> showCart(@PathVariable int userId) {
		return cartService.showCart(userId);
	}
	
	
	
	
	

}
