package com.hibernatecrud.test;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernatecrud.domain.Employee;

public class TestUpdateEmployees {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure().addAnnotatedClass(Employee.class)
				.buildSessionFactory();

		Session session = factory.getCurrentSession();

		int employeeIdToUpdate = 1;
		
		session.beginTransaction();

		// Fetching the object first then updating
		Employee fetchedEmployee1 = session.get(Employee.class, employeeIdToUpdate);
		System.out.println(fetchedEmployee1);
		fetchedEmployee1.setCompany("company1Updated");
		System.out.println(fetchedEmployee1);
		
		// Updating directly
		session.createQuery("update Employee e set company='company2Updated' where e.firstName='Kevin'").executeUpdate();
		
		session.getTransaction().commit();
		
		factory.close();

	}

}
