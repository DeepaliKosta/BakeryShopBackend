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

import com.bakeryShop.Exception.NotFoundException;
import com.bakeryShop.entity.Product;
import com.bakeryShop.service.ProductService;

@CrossOrigin(origins="http://localhost:3000")
@RestController
@RequestMapping("api/v1/product")
public class ProductController {
	
	@Autowired
	ProductService productService;
	
	@PostMapping("/addNew")
	public String addProduct(@RequestBody Product product) {
		return productService.addProduct(product);
		
	}
	
	@GetMapping("/allProducts")
	public List<Product> getAllProducts(){
		return productService.getAllProducts();
	}
	
	@DeleteMapping("/{id}")
	public void removeProduct(@PathVariable int id) {
		productService.removeProduct(id);
	}
	
	@PutMapping
	public Product updateProduct(@RequestBody Product product) throws NotFoundException {
		return productService.updateProduct(product);
	}
}
