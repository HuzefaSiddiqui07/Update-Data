package com.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Std_Main {

	public static void main(String[] args) {

		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory sessionFactory = cfg.buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		// pass the class name and id for updating record
		Student student = (Student) session.get(Student.class, 14);
		student.setName("Raghav");
		student.setCity("Nashik");
		session.update(student);
		session.getTransaction().commit();
		session.close();
		sessionFactory.close();
		System.out.println("Record updated successfully.");

	}

}
