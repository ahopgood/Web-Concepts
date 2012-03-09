package com.alexander.concepts.webservices.cxf.spring.client;

import java.net.URL;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.alexander.concepts.webservices.cxf.spring.service.HelloWorld;

public class Client {
	/**
	 * Deploy the war to tomcat first to make sure the service is up.
	 * Then run this in a seperate VM. 
	 */
	
	private final static String contextResource = "cxf-servlet.xml";
	
	private ApplicationContext context;
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		URL contextURL = Client.class.getResource(contextResource);
		Client client = new Client();
		client.setApplicationContext(new FileSystemXmlApplicationContext(contextURL.toString()));
		client.runWebService("Alex");
	}
	
	public Client(){

	}

	public void setApplicationContext(ApplicationContext context){
		this.context = context;
	}
	
	public void runWebService(String name){
		HelloWorld client = (HelloWorld)context.getBean("helloClient");
		System.out.println(client.sayHi(name));
	}
}
