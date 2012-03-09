package com.example.services;

import javax.jws.WebParam;
import javax.jws.WebService;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@WebService
public interface HelloWorld {

	//@WebParam is used to make sure that the parameter name is stored, instead of being named arg0 in the class file. 
	String sayHi(@WebParam(name="text") String text);
//	
//	String sayHiToUser(User user);
//	
//	@XmlJavaTypeAdapter(IntegerUserMapAdapter.class)
//	Map<Integer, User> getUsers();
}
