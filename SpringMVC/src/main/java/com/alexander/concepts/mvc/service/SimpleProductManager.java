package com.alexander.concepts.mvc.service;

import java.util.List;

import com.alexander.concepts.mvc.domain.Product;
import com.alexander.concepts.mvc.repository.ProductDao;

public class SimpleProductManager implements ProductManager {

	private static final long serialVersionUID = 7058397138102338686L;
	private ProductDao productDao; 
	
	public void setProductDao(ProductDao productDao){
		this.productDao = productDao;
	}
	
	public void increasePrice(int percentage) {
		List<Product> products = this.productDao.getProductList();
		if (products != null){
			for (Product product : products){
				double newPrice = product.getPrice().doubleValue()
						* (100 + percentage)/100;
				product.setPrice(newPrice);
			}
		}
	}

	public List<Product> getProducts() {
		return this.productDao.getProductList();
	}
	
//	public void setProducts(List<Product> products){
//		this.products = products;
//	}

}
