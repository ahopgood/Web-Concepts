package com.alexander.concepts.mvc.repository;

import java.util.LinkedList;
import java.util.List;

import com.alexander.concepts.mvc.domain.Product;

public class InMemoryDao implements ProductDao {

	/**
	 * Used in our junit tests for the {@link InventoryController} and 
	 * {@link SimpleProductManager} classes
	 */
	List<Product> productList = new LinkedList<Product>();
	
	public InMemoryDao(List<Product> productList){
		this.productList = productList;
	}
	
	public List<Product> getProductList() {
		return this.productList;
	}

	public void saveProduct(Product prod) {
		
	}
}
