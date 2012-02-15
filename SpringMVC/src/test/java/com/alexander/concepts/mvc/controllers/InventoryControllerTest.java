package com.alexander.concepts.mvc.controllers;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.Map;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import com.alexander.concepts.mvc.domain.Product;
import com.alexander.concepts.mvc.repository.InMemoryDao;
import com.alexander.concepts.mvc.service.SimpleProductManager;

public class InventoryControllerTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testHandleRequest() throws Exception {
        InventoryController controller = new InventoryController();
        SimpleProductManager productManager = new SimpleProductManager();
        productManager.setProductDao(new InMemoryDao(new ArrayList<Product>()));
        controller.setProductManager(productManager);
        
        ModelAndView modelAndView = controller.handleRequest(null, null);
        //Was "WEB-INF/jsp/hello.jsp" before decoupling the view from the controller, see springapp-servlet.xml
        assertEquals("hello", modelAndView.getViewName());
        assertNotNull(modelAndView.getModel());

        Map<String, Object> model =  (Map<String, Object>)modelAndView.getModel().get("model");
        String nowValue = (String) model.get("now");
        assertNotNull(nowValue);
	}

}
