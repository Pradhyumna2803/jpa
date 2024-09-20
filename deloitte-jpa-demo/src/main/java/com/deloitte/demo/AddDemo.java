package com.deloitte.demo;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import java.util.*;
import java.util.List;

public class AddDemo {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Employee.class)
				.buildSessionFactory();

		Session session = factory.getCurrentSession();
		Scanner sc =new Scanner(System.in);
		
		try {
			System.out.println("Add a new employeee");
			System.out.println("Enter name ");
			String name = sc.nextLine();
			System.out.println("Enter salary ");
			double salary = sc.nextDouble();


			Employee newEmployee = new Employee(name,salary);
			
			session.beginTransaction();
			
			session.save(newEmployee);
			
			session.getTransaction().commit();
			System.out.println("Done.");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			factory.close();
		}
	}
}