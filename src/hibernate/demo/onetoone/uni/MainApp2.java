package hibernate.demo.onetoone.uni;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MainApp2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SessionFactory sessionFactory = new Configuration().configure("hibernate.onetooneuni.xml").addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class).buildSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		try {
			session.beginTransaction();
			InstructorDetail i = session.get(InstructorDetail.class, 1);
			System.out.println(i.getInstructor());
			session.delete(i.getInstructor());

			session.getTransaction().commit();
		} finally {
			// TODO: handle finally clause
			sessionFactory.close();
		}

	}

}
