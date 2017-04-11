package com.hibernatecrud.test;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernatecrud.domain.Employee;

public class TestDeleteEmployees {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure().addAnnotatedClass(Employee.class)
				.buildSessionFactory();

		Session session = factory.getCurrentSession();

		int employeeIdToDelete = 1;

		session.beginTransaction();

		session.createQuery("delete from Employee e where e.id = :id").setParameter("id", employeeIdToDelete)
				.executeUpdate();

		// Can also do the following deletion
//		Employee fetchedEmployee1 = session.get(Employee.class, employeeIdToDelete);
//		session.delete(fetchedEmployee1);

		session.getTransaction().commit();

		factory.close();

	}

}
