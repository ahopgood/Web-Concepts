package com.alexander.concepts.webservices.cxf.spring.service;

import javax.jws.WebService;

@WebService(endpointInterface="com.alexander.concepts.webservices.cxf.spring.service.HelloWorld")
public class HelloWorldImpl implements HelloWorld {

	@Override
	public String sayHi(String text) {
		System.out.println("sayHi called");
		return "Hello Spring based " + text;
	}
}
