package com.hibernatecrud.test;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernatecrud.domain.Employee;

public class TestRetrieveEmployees {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure().addAnnotatedClass(Employee.class)
				.buildSessionFactory();

		Session session = factory.getCurrentSession();

		int employeeIdToFetch = 1;
		
		session.beginTransaction();

		Employee fetchedEmployee1 = session.get(Employee.class, employeeIdToFetch);
		System.out.println(fetchedEmployee1);
		
		List<Employee> fetchedEmployee2 = session.createQuery("from Employee e where e.company = 'company2'" ).getResultList();
		System.out.println(fetchedEmployee2.get(0));
		
		session.getTransaction().commit();
		
		factory.close();

	}

}
