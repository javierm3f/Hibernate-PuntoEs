package edu.tecnilogica.main;

import java.math.BigDecimal;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import edu.tecnilogica.entity.Regions;

public class MainHibernate2 {

	public static void main(String[] args) {
		SessionFactory sf = null;
		try {

			sf = HibernateFactory.getSessionFactory();
			Session sesion = sf.openSession();
			Transaction tx = null;
			try { // TRANSACCION
				Regions rg = new Regions(); // TRANSIENT
				rg.setRegionId(new BigDecimal(33));
				rg.setRegionName("Chiquitistan");
				tx = sesion.beginTransaction();

				sesion.save(rg); // PERSISTENT

				rg.setRegionName("Cuenca");

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
