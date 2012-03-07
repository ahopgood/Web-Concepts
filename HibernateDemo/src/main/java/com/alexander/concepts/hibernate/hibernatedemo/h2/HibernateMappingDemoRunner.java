package com.alexander.concepts.hibernate.hibernatedemo.h2;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.alexander.concepts.hibernate.hibernatedemo.Constants;
import com.alexander.concepts.hibernate.hibernatedemo.Event;

public class HibernateMappingDemoRunner {

	private static Logger log = Logger.getLogger(HibernateMappingDemoRunner.class);
	/**
	 * @param args
	 */
	public static void main(String[] args) throws URISyntaxException {
		PropertyConfigurator.configure("log4j.properties");
		URL configFileResourcePathURL = HibernateMappingDemoRunner.class.getResource(Constants.HIBERNATE_CONFIG_FILENAME);
		
		SessionFactory sessionFactory = new Configuration().
				configure(configFileResourcePathURL).
				buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(new Event("Our very first event!", new Date()));
		session.save(new Event("A follow up event", new Date()));
		session.getTransaction().commit();
		session.close();
		
		
		session = sessionFactory.openSession();
		session.beginTransaction();
		List result = session.createQuery("from Event").list();
		for (Event event : (List<Event>) result){
			System.out.println( "Event ("+event.getDate() + ") : " + event.getTitle() );
		}
		session.getTransaction().commit();
		session.close();
	}

}
