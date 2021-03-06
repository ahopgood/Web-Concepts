package com.alexander.concepts.mvc.repository;

import java.util.List;

import com.alexander.concepts.mvc.domain.Product;

public interface ProductDao {

	public List<Product> getProductList();
	
	public void saveProduct(Product prod);
}
