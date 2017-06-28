package edu.tecnilogica.services;

import org.hibernate.HibernateException;
import org.hibernate.event.spi.LoadEvent;
import org.hibernate.event.spi.LoadEventListener;
//Listener
public class MyLoadListener implements LoadEventListener {

	public void onLoad(LoadEvent event, LoadType type) throws HibernateException {
		System.out.println("LOAD --> " + event.getEntityClassName() + " cargado.");
	}

}
