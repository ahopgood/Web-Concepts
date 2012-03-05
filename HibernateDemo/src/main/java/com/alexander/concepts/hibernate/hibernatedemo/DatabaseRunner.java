package com.alexander.concepts.hibernate.hibernatedemo;

import java.util.Date;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DatabaseRunner {

	private static Logger log = Logger.getLogger(DatabaseRunner.class);
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		PropertyConfigurator.configure("log4j.properties");
		
		System.out.println("Log Test Baby");
		SessionFactory sessionFactory = new Configuration().
				configure().
				buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(new Event("Our very first event!", new Date()));
		session.save(new Event("A follow up event", new Date()));
		session.getTransaction().commit();
		session.close();
	}

}
