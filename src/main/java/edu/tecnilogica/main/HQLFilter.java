package edu.tecnilogica.main;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import org.hibernate.Filter;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import edu.tecnilogica.entity.Employees;

public class HQLFilter {
	public static void main(String[] args) {
		SessionFactory sf = null;
		try {

			sf = HibernateFactory.getSessionFactory();
			Session sesion = sf.openSession();
			Transaction tx = null;
			try {
				tx = sesion.beginTransaction();

				Filter filtro = sesion.enableFilter("employeeFilter");
				filtro.setParameter("salary", 25000);

				Query query = sesion.createQuery("from Employees e");
				List<Employees> lista = query.list();
				for (Employees emp : lista) {
					System.out.println(emp.getFirstName() + " " + emp.getSalary());
				}
	
				tx.commit();

			} catch (Exception e) {
				tx.rollback();
				e.printStackTrace();
			} finally {
				sesion.close();
			}

		} catch (Throwable t) {
			t.printStackTrace();
		} finally {
			sf.close();
		}
	}

}
