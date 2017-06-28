package edu.tecnilogica.main;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import edu.tecnilogica.entity.Departments;

public class SelectNamedQuery2 {
	public static void main(String[] args) {
		EntityManagerFactory emf = null;
		try {

			emf = JPAFactory.getEntityManagerFactory();
			EntityManager em = emf.createEntityManager();
			EntityTransaction tx = null;
			try {
				tx = em.getTransaction();
				tx.begin();
				TypedQuery<Departments> query = em.createNamedQuery("Departments.todos", Departments.class);

				List<Departments> lista = query.getResultList();
				for (Departments dep : lista) {
					System.out.println("ID: " + dep.getDepartmentId());
					System.out.println("Nombre: " + dep.getDepartmentName());
				}

				tx.commit();

			} catch (Exception e) {
				tx.rollback();
				e.printStackTrace();
			} finally {
				em.close();
			}

		} catch (Throwable t) {
			t.printStackTrace();
		} finally {
			emf.close();
		}
	}

}