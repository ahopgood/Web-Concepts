package com.example.services;

import javax.jws.WebService;

@WebService(endpointInterface = "com.example.HelloWorld",
		serviceName = "HelloWorld")
public class HelloWorldImpl implements HelloWorld {

	@Override
	public String sayHi(String text) {
		System.out.println("sayHi called");
		return "Hello " + text;
	}

}
