package com.product.ProductApi.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.product.ProductApi.model.Product;
import com.product.ProductApi.service.ProductService;

@RestController
@EnableCaching
public class MyController {
	
	
	@Autowired
	private  ProductService productService;
	
	// get list of product 
	
	@GetMapping("/product")
	public List<Product> getProductList()
	{
		return this.productService.getAllList(); 
	}
	
	// add new product
	
	@PostMapping("/product")
	public Product addProduct(@RequestBody Product product)
	{
		return productService.Addproduct( product);
	}

	// get product by id
	
	@GetMapping("/product/{id}")
	@Cacheable(key = "#id" , value = "product")
	public Optional<Product> getProduct(@PathVariable String id)
	{
		return this.productService.getproduct(Integer.parseInt(id));
	}
	
	// update product by id
	
	@PutMapping("/product/{id}")
	@CachePut(key = "#id",value = "product")
	public Product updateProduct(@RequestBody Product details , @PathVariable Integer id)
	{
		return this.productService.updateProduct(id , details);
	}
	
	// delete product by id
	
	@DeleteMapping("/product/{id}")
	@CacheEvict(value = "product", allEntries = true)
	public String deleteProduct(@PathVariable Integer id)
	{
		return this.productService.deleteProduct(id);
		
	}

}
