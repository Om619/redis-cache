package com.product.ProductApi.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;
import org.springframework.stereotype.Repository;

import com.product.ProductApi.model.Product;


@Repository
public interface ProductDao extends JpaRepository<Product, Integer> {

	void save(Optional<Product> product);

}
