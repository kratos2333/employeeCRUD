package com.hibernatecrud.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernatecrud.domain.Employee;

public class TestCreateEmployees {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure().addAnnotatedClass(Employee.class).buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		Employee employee1 = new Employee("Jason", "Noble", "Company1");
		Employee employee2 = new Employee("Kevin", "Kwan", "Company2");
		
		session.beginTransaction();
		
		session.save(employee1);
		session.save(employee2);
		
		session.getTransaction().commit();
		factory.close();

	}

}
