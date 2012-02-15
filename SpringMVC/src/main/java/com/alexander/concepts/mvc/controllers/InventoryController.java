package com.alexander.concepts.mvc.controllers;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.alexander.concepts.mvc.service.ProductManager;

public class InventoryController implements Controller {

	protected final Log logger = LogFactory.getLog(getClass());

	private ProductManager productManager;
	
	public ModelAndView handleRequest(HttpServletRequest arg0,
			HttpServletResponse arg1) throws Exception, IOException {

		String now = (new Date()).toString();
		logger.info("Returning hello view with " + now);
		
		Map<String, Object> myModel = new HashMap<String, Object>();
		myModel.put("now", now);
		myModel.put("products", productManager.getProducts());
		
		//previously WEB-INF/jsp/hello.jsp before we decoupled the view and controller in springapp-serlvet.xml
		return new ModelAndView("hello", "model", myModel);
	}
	
	public void setProductManager(ProductManager productManager){
		this.productManager = productManager;
	}

}
