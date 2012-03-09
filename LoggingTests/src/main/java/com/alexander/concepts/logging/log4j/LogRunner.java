package com.alexander.concepts.logging.log4j;

import com.alexander.concepts.logging.log4j.database.Log4JDatabaseSequential;

public class LogRunner {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Log4JSequential seq = new Log4JSequential();
		seq.log(10);
		try {
			Log4JDatabaseSequential data = new Log4JDatabaseSequential();
			data.log(10);
		} catch (Exception e){
			e.printStackTrace();
		}
	}

}
