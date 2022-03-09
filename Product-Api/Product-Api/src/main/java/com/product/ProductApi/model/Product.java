package com.product.ProductApi.model;

import java.io.Serializable;

import javax.persistence.Entity;

import org.springframework.data.redis.core.RedisHash;


@Entity
public class Product implements Serializable {
	
	@javax.persistence.Id
	private int Id;
	private String name;
	private double price;
	public Product(int id, String name, double price) {
		super();
		Id = id;
		this.name = name;
		this.price = price;
	}
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Product [Id=" + Id + ", name=" + name + ", price=" + price + "]";
	}
	
	
	

}
