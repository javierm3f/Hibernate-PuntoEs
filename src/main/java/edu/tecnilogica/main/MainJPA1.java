package edu.tecnilogica.main;

import java.math.BigDecimal;
import java.util.Iterator;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import edu.tecnilogica.entity.Countries;
import edu.tecnilogica.entity.Regions;

public class MainJPA1 {

	public static void main(String[] args) {
		EntityManagerFactory emf = null;
		try {

			emf = JPAFactory.getEntityManagerFactory();
			EntityManager em = emf.createEntityManager();
			EntityTransaction tx = null;
			try { // TRANSACCION
				tx = em.getTransaction();
				tx.begin();
				Regions rg = em.find(Regions.class, new BigDecimal(1));

				System.out.println("Región ID = " + rg.getRegionId());
				System.out.println("Región nombre = " + rg.getRegionName());

				System.out.println("PAISES:");
				Set<Countries> lista_paises = rg.getCountrieses();
				
				Iterator<Countries> it = lista_paises.iterator();
				Countries caux = null;
				while (it.hasNext()) {
					caux = it.next();
					System.out.println(caux.toString());
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
