package com.alexander.concepts.logging.log4j.database;

import java.net.URL;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.alexander.concepts.logging.log4j.Log4JSequential;

public class Log4JDatabaseSequential {

	private static final String PROPERTIES = "log4jDatabase.properties";
	private static final Logger LOGGER = Logger.getLogger(Log4JDatabaseSequential.class);
	
	public Log4JDatabaseSequential(){
		URL configURL = Log4JDatabaseSequential.class.getResource(PROPERTIES);
		System.out.println(configURL);
		PropertyConfigurator.configure(configURL);
	}
	
	public void log(int logMessages){
		for (int i = 0; i < logMessages; i++){
			LOGGER.debug("Test message");
		}
	}
}
