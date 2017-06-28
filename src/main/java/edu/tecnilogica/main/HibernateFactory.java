package edu.tecnilogica.main;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateFactory {

	private static SessionFactory factory;

	static {
		new HibernateFactory();
	}

	private HibernateFactory() {
		StandardServiceRegistry registry = null;

		try {
			registry = new StandardServiceRegistryBuilder().configure().build();//// applySettings(configuration.getProperties());
			factory = new MetadataSources(registry).buildMetadata().buildSessionFactory();// configuration.buildSessionFactory(builder.build());
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public static SessionFactory getSessionFactory() {
		return factory;
	}

}
