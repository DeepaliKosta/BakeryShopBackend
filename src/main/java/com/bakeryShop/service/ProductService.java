package com.bakeryShop.service;

import java.util.List;

import com.bakeryShop.Exception.NotFoundException;
import com.bakeryShop.entity.Product;

public interface ProductService {

	String addProduct(Product product);

	List<Product> getAllProducts();

	void removeProduct(int id);

	Product updateProduct(Product product) throws NotFoundException;

}
