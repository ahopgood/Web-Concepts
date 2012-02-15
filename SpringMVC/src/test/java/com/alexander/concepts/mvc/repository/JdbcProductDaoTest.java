package com.alexander.concepts.mvc.repository;

import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.test.AbstractTransactionalDataSourceSpringContextTests;

import com.alexander.concepts.mvc.domain.Product;

public class JdbcProductDaoTest extends AbstractTransactionalDataSourceSpringContextTests {

	private ProductDao productDAO;
	
	public void setProductDAO(ProductDao productDAO){
		this.productDAO = productDAO;	
	}
	
	@Override
	protected String[] getConfigLocations(){
		return new String[] {"classpath:test-context.xml"};
	}
	
	@Override
	protected void onSetUpInTransaction() throws Exception{
		super.executeSqlScript("classpath:create_products.sql", true);
		super.deleteFromTables(new String[] {"products"});
		super.executeSqlScript("classpath:load_data.sql", true);
	}
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test 
	public void testGetProductList() {
		List<Product> products = productDAO.getProductList();
		
		assertEquals("wrong number of products?", 3, products.size());
	}

	@Test
	public void testSaveProduct() {
        List<Product> products = productDAO.getProductList();
        
        for (Product p : products) {
            p.setPrice(200.12);
            productDAO.saveProduct(p);
        }
        
        List<Product> updatedProducts = productDAO.getProductList();
        for (Product p : updatedProducts) {
            assertEquals("wrong price of product?", 200.12, p.getPrice());
        }
	}

}
