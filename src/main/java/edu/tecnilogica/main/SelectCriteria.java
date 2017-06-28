package edu.tecnilogica.main;

//CRITERIA DE JPA

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import edu.tecnilogica.entity.Regions;

public class SelectCriteria {

	public static void main(String[] args) {
		EntityManagerFactory emf = null;
		try {

			emf = JPAFactory.getEntityManagerFactory();
			EntityManager em = emf.createEntityManager();
			EntityTransaction tx = null;
			try { // TRANSACCION
				tx = em.getTransaction();
				tx.begin();
				CriteriaBuilder cb = em.getCriteriaBuilder();

				CriteriaQuery<String> cq = cb.createQuery(String.class);
				Root<Regions> root = cq.from(Regions.class);
				cq.select(root.get("regionName").as(String.class));

				TypedQuery<String> tq = em.createQuery(cq);
				List<String> listaNR = tq.getResultList();
				
				for (String name : listaNR) {
					System.out.println("Nombre: "+name);
				}

				tx.commit();

			} catch (Exception e) {
				tx.rollback();
				e.printStackTrace();
			} finally {
				em.close(); // lanza excepcion que se puede controlar
			}

		} catch (Throwable t) {
			t.printStackTrace();
		} finally {
			emf.close();
		}
	}

}