package com.example.client;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.soap.SOAPBinding;

import com.example.services.HelloWorld;

public class Client {

	private static final QName SERVICE_NAME 
		= new QName("http://example.com/","HelloWorld");
	private static final QName PORT_NAME 
		= new QName("http://example.com/","HelloWorldPort");
	
	private Client(){
		
	}
	
	public static void main(String[] args) throws Exception {
		Service service = Service.create(SERVICE_NAME);
		//endpoint address
		String endpointAddress = "http://localhost:9000/helloWorld";
		//add a port to the service
		service.addPort(PORT_NAME, SOAPBinding.SOAP11HTTP_BINDING, endpointAddress);
		
		HelloWorld hw = service.getPort(HelloWorld.class);
		System.out.println(hw.sayHi("Alex"));
	}
}
