package com.alexander.concepts.logging.log4j;

import java.net.URL;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class Log4JSequential {

	private static final String PROPERTIES = "log4j.properties";
	private static final Logger LOGGER = Logger.getLogger(Log4JSequential.class);
			
	public Log4JSequential(){
		URL configURL = Log4JSequential.class.getResource(PROPERTIES);
		PropertyConfigurator.configure(configURL);
	}
	
	public void log(int logMessages){
		for (int i = 0; i < logMessages; i++){
			LOGGER.debug("Test message");
		}
	}
	
	//add abstract class for logging.
}
