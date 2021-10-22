package hibernate.demo.onetoone.uni;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MainApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SessionFactory sessionFactory = new Configuration().configure("hibernate.onetooneuni.xml").addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class).buildSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		try {
			session.beginTransaction();
			InstructorDetail obj = new InstructorDetail("hello@youtube.com", "coding");
			Instructor i = new Instructor("Akashdeep", "Bhattacharya", "beingakscool@gmail.com", obj);
			session.save(i);
			session.getTransaction().commit();
		} finally {
			// TODO: handle finally clause
			sessionFactory.close();
		}

	}

}
