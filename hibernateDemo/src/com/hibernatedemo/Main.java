package com.hibernatedemo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(City.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		try {
			session.beginTransaction();
			List<City> cities = session.createQuery("from City").getResultList();
			
			for(City city:cities) {
				System.out.println(city.getCityName());
			}
			
			/*// ---- Insert işlemi ---
			City city = new City();
			city.setCityName("Konya");
			city.setCountryId("42");
			city.setId(4242);
			session.save(city);*/
			// -------------
			
		// ----- UPDATE işlemi -----
		 City city = session.get(City.class, 2);
		 System.out.println(city.getCityName()+ ": Güncellendi");
		city.setCityName("ahba2");
		session.save(city);
			
			session.getTransaction().commit();
			System.out.println(city.getCityName()+ ": Yeni Adı");
			
		} finally {
			factory.close();
		}
			
	}

}
