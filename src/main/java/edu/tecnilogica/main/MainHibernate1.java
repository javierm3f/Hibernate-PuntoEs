package edu.tecnilogica.main;

import java.math.BigDecimal;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import edu.tecnilogica.entity.Regions;

public class MainHibernate1 {

	public static void main(String[] args) {
		SessionFactory sf = null;
		try {

			sf = HibernateFactory.getSessionFactory();
			Session sesion = sf.openSession();
			Transaction tx = null;
			try { // TRANSACCION
				tx = sesion.beginTransaction();
				Regions rg = sesion.get(Regions.class, new BigDecimal(1));

				System.out.println("Región ID = " + rg.getRegionId());
				System.out.println("Región nombre = " + rg.getRegionName());

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
