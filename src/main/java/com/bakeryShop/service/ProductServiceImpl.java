package com.bakeryShop.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bakeryShop.Exception.NotFoundException;
import com.bakeryShop.entity.Product;
import com.bakeryShop.respoitory.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductRepository productRepository;

	@Override
	public String addProduct(Product product) {
		// TODO Auto-generated method stub
		productRepository.save(product);
		return "Product added sucessfully";
	}

	@Override
	public List<Product> getAllProducts() {
		// TODO Auto-generated method stub
		return productRepository.findAll();
	}

	@Override
	public void removeProduct(int id) {
		// TODO Auto-generated method stub
		productRepository.deleteById(id);

	}

	@Override
	public Product updateProduct(Product product) throws NotFoundException {
		// TODO Auto-generated method stub
		try {
			Product p = productRepository.findById(product.getId()).get();
			p.setName(product.getName());
			p.setPrice(product.getPrice());
			p.setPhotoPath(product.getPhotoPath());
			productRepository.save(p);
			return p;
		} catch (Exception e) {

			throw new NotFoundException("Product id not found");

		}
	}

}
