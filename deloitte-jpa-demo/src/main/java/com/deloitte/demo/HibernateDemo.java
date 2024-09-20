package com.deloitte.demo;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class HibernateDemo {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Employee.class)
				.buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {

			session.beginTransaction();

			//Hibernate Query Language for querying the DB instead of sql query
		
			List<Employee> employees = session.createQuery("from Employee",Employee.class).getResultList();

			for (Employee emp : employees) {
				System.out.println(emp);
			}
			
			// createQuery method for select * from query in mysql
			
			/*  for crud ops
			find - returns only one object 
			save 
			update 
			remove
			 */
			
			
			// factory - create session - do ops - commit - close factory
			session.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			factory.close();
		}
	}
}