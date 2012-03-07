package com.alexander.concepts.hibernate.hibernatedemo.mysql.annotated;

import java.net.URL;
import java.util.Date;
import java.util.List;

import org.apache.log4j.PropertyConfigurator;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.alexander.concepts.hibernate.hibernatedemo.AnnotatedEvent;
import com.alexander.concepts.hibernate.hibernatedemo.Constants;

public class MysqlAnnotatedHibernateRunnerDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		PropertyConfigurator.configure("log4j.properties");
		System.out.println("Log Test Baby");
		URL configFileResourcePathURL = MysqlAnnotatedHibernateRunnerDemo.class.getResource(Constants.HIBERNATE_CONFIG_FILENAME);
		
		SessionFactory sessionFactory = new Configuration().
				configure(configFileResourcePathURL).
				buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(new AnnotatedEvent("Our very first event!", new Date()));
		session.save(new AnnotatedEvent("A follow up event", new Date()));
		session.getTransaction().commit();
		session.close();
		
		
		session = sessionFactory.openSession();
		session.beginTransaction();
		List result = session.createQuery("from AnnotatedEvent").list();
		for (AnnotatedEvent event : (List<AnnotatedEvent>) result){
			System.out.println( "Event ("+event.getDate() + ") : " + event.getTitle() );
		}
		session.getTransaction().commit();
		session.close();
	}
}
