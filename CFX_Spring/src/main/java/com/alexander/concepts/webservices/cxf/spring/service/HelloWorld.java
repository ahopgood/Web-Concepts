package com.alexander.concepts.webservices.cxf.spring.service;

import javax.jws.WebService;

@WebService
public interface HelloWorld {

		public String sayHi(String text);
}
