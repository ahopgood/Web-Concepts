package com.alexander.concepts.hibernate.hibernatedemo.h2.annotated;

import java.net.URL;
import java.util.Date;

import org.apache.log4j.PropertyConfigurator;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.alexander.concepts.hibernate.hibernatedemo.AnnotatedEvent;
import com.alexander.concepts.hibernate.hibernatedemo.Constants;

public class AnnotatedHibernateMappingDemoRunner {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		PropertyConfigurator.configure("log4j.properties");
		URL configFileResourcePathURL = AnnotatedHibernateMappingDemoRunner.class.getResource(Constants.HIBERNATE_CONFIG_FILENAME);
		
		SessionFactory sessionFactory = new Configuration().
				configure(configFileResourcePathURL).
				buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(new AnnotatedEvent("Our very first annotated event!", new Date()));
		session.save(new AnnotatedEvent("A follow up annotated event", new Date()));
		session.getTransaction().commit();
		session.close();
	}
}
