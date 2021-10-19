package hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hibernate.demo.entity.Student;

public class UpdateAllStudents {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			session.beginTransaction();
			session.createQuery("update Student set email = 'a@gmail.com' where id between 2 and 3" ).executeUpdate();
			session.getTransaction().commit();
			
		} finally {
			// TODO: handle finally clause
			factory.close();
		}
	}

}
