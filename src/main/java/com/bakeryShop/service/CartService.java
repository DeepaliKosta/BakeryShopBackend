package com.bakeryShop.service;

import java.util.List;

import com.bakeryShop.entity.Cart;
import com.bakeryShop.entity.Customer;
import com.bakeryShop.entity.Product;

public interface CartService {

	Cart addToCart(Cart cart, int userId);

	Cart addToCart_two(Product product, int userId);

	Customer addToCart_three(int productId, int userId);

	Customer removeFromCart(int productId, int userId);

	int countItemsInCart( int userId);

	int totalInCart(int userId);

	List<Product> showCart(int userId);

	

}
