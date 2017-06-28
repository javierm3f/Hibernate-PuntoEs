package edu.tecnilogica.main;

import java.math.BigDecimal;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import edu.tecnilogica.entity.Regions;

public class MainGetLoad {
	public static void main(String[] args) {
		SessionFactory sf = null;
		try {

			sf = HibernateFactory.getSessionFactory();
			Session sesion = sf.openSession();
			Transaction tx = null;
			try { // TRANSACCION
				tx = sesion.beginTransaction();
				// GET consulta la base de datos al ejecutarse
				// LOAD no accede a la base de datos en el momento de
				// ejecutarse. Crea un objeto en persistencia
				Regions rg = sesion.load(Regions.class, new BigDecimal(33));
				if (null != rg) {
					System.out.println("No nulo");
					System.out.println(rg.getRegionId());
					System.out.println(rg.getRegionName());
				} else {
					System.out.println("Nulo");
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