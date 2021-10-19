package hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hibernate.demo.entity.Student;

public class CreateStudent {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			Student stu = new Student("Akashdeep", "Bhattacharya", "beingakscool@gmail.com");
			session.beginTransaction();
			session.save(stu);
			session.getTransaction().commit();
			
		} finally {
			// TODO: handle finally clause
			factory.close();
		}
	}

}
