package edu.tecnilogica.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import edu.tecnilogica.entity.Employees;

public class MainJPA2 {

	public static void main(String[] args) {
		EntityManagerFactory emf = null;
		try {

			emf = JPAFactory.getEntityManagerFactory();
			EntityManager em = emf.createEntityManager();
			// se pasa de jpa a la api de hibernate (no se puede hacer al reves)
			SessionFactory sf = emf.unwrap(SessionFactory.class);
			Session s = sf.openSession();

			Transaction tx = null;
			try { // TRANSACCION
				tx = s.beginTransaction();
				Employees emp = em.find(Employees.class, 100);
				System.out.println("NOMBRE: " + emp.getFirstName() + " " + emp.getLastName());
				System.out.println("SALARIO: " + emp.getSalary());
				tx.commit();

			} catch (Exception e) {
				tx.rollback();
				e.printStackTrace();
			} finally {
				s.close(); // lanza excepcion que se puede controlar
			}

		} catch (Throwable t) {
			t.printStackTrace();
		} finally {
			emf.close();
		}
	}

}
