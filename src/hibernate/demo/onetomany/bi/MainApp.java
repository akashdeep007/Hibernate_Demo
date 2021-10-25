package hibernate.demo.onetomany.bi;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MainApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SessionFactory sessionFactory = new Configuration().configure("hibernate.onetomanybi.xml").addAnnotatedClass(Instructor.class).addAnnotatedClass(Course.class).addAnnotatedClass(InstructorDetail.class).buildSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		try {
			session.beginTransaction();
			Instructor i = session.get(Instructor.class, 1);
			System.out.println(i);
			session.getTransaction().commit();
		} finally {
			// TODO: handle finally clause
			sessionFactory.close();
		}

	}

}
