package com.bakeryShop.controllerTest;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.bakeryShop.Exception.NotFoundException;
import com.bakeryShop.controller.ProductController;
import com.bakeryShop.entity.Product;
import com.bakeryShop.service.ProductService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(ProductController.class)
public class ProductControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private ProductService productService;

	private Product product;
	
	private Product product1;

	@BeforeEach
	void productControllerTestSetup() {

		product = Product.builder().id(88).name("Cup cake").price(300).photoPath("cupCake.jpg").build();
		product1 = Product.builder().id(89).name("Brownie").price(200).photoPath("brownie.jpg").build();
		
//		product.setId(88);
//		product.setName("Cup cake");
//		product.setId(300);
//		product.setPhotoPath("cupCake.jpg");
//		
//		product1.setId(89);
//		product1.setName("Browniw");
//		product1.setId(200);
//		product1.setPhotoPath("brownie.jpg");
	}

	@Test
	public void addProductTest() throws Exception {
		Mockito.when(productService.addProduct(product)).thenReturn("Product added sucessfully");

		MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/product/addNew")
				.accept(MediaType.APPLICATION_JSON).content(new ObjectMapper().writeValueAsString(product))
				.contentType(MediaType.APPLICATION_JSON)).andReturn();

		MockHttpServletResponse response = mvcResult.getResponse();

		String result = response.getContentAsString();

		assertThat(result).isEqualTo("Product added sucessfully");

//		mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/product/addNew").contentType(MediaType.APPLICATION_JSON).content(new ObjectMapper()
//				.writeValueAsString(product))).andExpect(MockMvcResultMatchers.status().isOk());
	}
	
	@Test
	public void getAllProductsTest() throws JsonProcessingException, Exception {
		
		List<Product> productList = new ArrayList<>();
		
		productList.add(product);
		productList.add(product1);
		
		Mockito.when(productService.getAllProducts()).thenReturn(productList);
		
	    MvcResult mvcResult=mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/product/allProducts").accept(MediaType.APPLICATION_JSON)).andReturn();
		
	    String result=  mvcResult.getResponse().getContentAsString();
    
	    assertThat(result).isEqualTo(new ObjectMapper().writeValueAsString(productList) );
		

	}
	
	@Test
	public void removeProductTest() throws Exception {
		
		Mockito.doNothing().when(productService).removeProduct(Mockito.anyInt());
		
		mockMvc.perform(MockMvcRequestBuilders.delete("/api/v1/product/88").accept(MediaType.APPLICATION_JSON)).andExpect(MockMvcResultMatchers.status().isOk());
		
		
	}
	
	
	
	
	
	
	
}
