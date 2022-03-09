package com.product.ProductApi.service;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.product.ProductApi.dao.ProductDao;
import com.product.ProductApi.model.Product;

@Service
public class ProductService implements ProductInterface{
	
	
	@Autowired
	private ProductDao productDao;
	
	
	/*
	 * private RedisTemplate<String, Object> redisTemplate;
	 * 
	 * private HashOperations<String , Integer, Product>
	 */
	

	
	public List<Product> getAllList() {
		// TODO Auto-generated method stub
		return productDao.findAll();
	}

	public Product Addproduct(Product product) {
		// TODO Auto-generated method stub
		productDao.save(product);
		return product;
	}

	
	public Optional<Product> getproduct(int parseInt) {
		// TODO Auto-generated method stub
//		Product product = null;
		
		
		return productDao.findById(parseInt);
	}

	public Product updateProduct(Integer id ,Product details) {
		// TODO Auto-generated method stub
		Product product = new Product();
		if(id == details.getId())
		{
			product.setId(details.getId());
			product.setName(details.getName());
			product.setPrice(details.getPrice());
		}
		
//		Product product = productDao.findById(id);
//		productDao.saveAll(product);
		productDao.save(product);
		return product;
	}

	public String deleteProduct(Integer id) {
	
	
		Product product = productDao.getById(id);
		
		productDao.delete(product);
		
		return "product deleted";
		
	}


	
}
