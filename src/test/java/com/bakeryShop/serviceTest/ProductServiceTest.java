package com.bakeryShop.serviceTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.bakeryShop.Exception.NotFoundException;
import com.bakeryShop.entity.Product;
import com.bakeryShop.respoitory.ProductRepository;
import com.bakeryShop.service.ProductService;

@WebMvcTest(ProductService.class)
public class ProductServiceTest {

	@Autowired
	private ProductService productService;

	@MockBean
	private ProductRepository productRepository;

	private Product product;

	private Product product1;

	@BeforeEach
	public void productServiceTestSetup() {
		product = Product.builder().id(88).name("Cup Cake").price(200).photoPath("cupCake.jpg").build();

		product1 = Product.builder().id(89).name("Brownie").price(200).photoPath("brownie.jpg").build();
	}

	@Test
	public void addProductTest() {
		Mockito.when(productRepository.save(product)).thenReturn(product);

		assertThat(productService.addProduct(product)).isEqualTo("Product added sucessfully");

	}

	@Test
	public void getAllProductsTest() {
		List<Product> productList = new ArrayList<>();

		productList.add(product);
		productList.add(product1);

		Mockito.when(productRepository.findAll()).thenReturn(productList);

		assertThat(productService.getAllProducts()).isEqualTo(productList);
	}

	@Test
	public void removeProductTest() {
		Mockito.doNothing().when(productRepository).deleteById(Mockito.anyInt());

		productService.removeProduct(Mockito.anyInt());

		verify(productRepository, times(1)).deleteById(Mockito.anyInt());
	}

	@Test
	public void updateProductTest() throws NotFoundException {
		
	
       Mockito.when(productRepository.save(product)).thenReturn(product);
       
       Mockito.when(productRepository.findById(88)).thenReturn(Optional.of(product));
       
       product.setName("Chocolate Cup cake");
       product.setPrice(250);
       
       Product updatedProduct = productService.updateProduct(product);
       
       assertThat(updatedProduct.getName()).isEqualTo("Chocolate Cup cake");
       assertThat(updatedProduct.getPrice()).isEqualTo(250);
	}
}
