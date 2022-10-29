package com.bakeryShop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bakeryShop.entity.Cart;
import com.bakeryShop.entity.Customer;
import com.bakeryShop.entity.Product;
import com.bakeryShop.respoitory.CartRepository;
import com.bakeryShop.respoitory.CustomerRepository;
import com.bakeryShop.respoitory.ProductRepository;

@Service
public class CartServiceImpl implements CartService {

	@Autowired
	CartRepository cartRepository;

	@Autowired
	CustomerRepository customerRepository;

	@Autowired
	ProductRepository productRepository;

	@Override
	public Cart addToCart(Cart cart, int userId) {
		// TODO Auto-generated method stub
		Cart customerCart = customerRepository.findById(userId).get().getCart();

		
		customerCart.setProductList(cart.getProductList());
//		customerCart.getProductList().add(cart.)
		cartRepository.save(customerCart);

		return null;
	}

	@Override
	public Cart addToCart_two(Product product, int userId) {
		// TODO Auto-generated method stub
		Cart customerCart = customerRepository.findById(userId).get().getCart();

		customerCart.getProductList().add(product);
		//customerCart.getProductList().put(product, 1);
		cartRepository.save(customerCart);

		return customerCart;
	}

	@Override
	public Customer addToCart_three(int productId, int userId) {
		// TODO Auto-generated method stub
		Cart customerCart = customerRepository.findById(userId).get().getCart();
		Product product = productRepository.findById(productId).get();

		customerCart.getProductList().add(product);
		//customerCart.getProductList().put(product, 1);
		cartRepository.save(customerCart);

		return customerRepository.findById(userId).get();
	}

	@Override
	public Customer removeFromCart(int productId, int userId) {
		Cart customerCart = customerRepository.findById(userId).get().getCart();
		Product product = productRepository.findById(productId).get();

		customerCart.getProductList().remove(product);
		cartRepository.save(customerCart);

		return customerRepository.findById(userId).get();
	}

	@Override
	public int countItemsInCart( int userId) {
		Cart customerCart = customerRepository.findById(userId).get().getCart();
		

		int count=customerCart.getProductList().size();


		return count;
	}
	
	@Override
	public int totalInCart( int userId) {
		Cart customerCart = customerRepository.findById(userId).get().getCart();
		
		int count=0;
		
		List<Product> productList=customerCart.getProductList();
		
		for(Product p:productList) {
			count += (int) p.getPrice();
		}
		
		


		return count;
	}
	
	@Override
	public List<Product> showCart(int userId){
		Cart customerCart = customerRepository.findById(userId).get().getCart();
		
		return customerCart.getProductList();
	}

}
