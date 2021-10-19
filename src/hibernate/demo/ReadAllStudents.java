package hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hibernate.demo.entity.Student;

public class ReadAllStudents {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			session.beginTransaction();
			@SuppressWarnings("unchecked")
			List<Student> st = session.createQuery("from Student").getResultList();
			if(st!=null)
				{
					for(Student s : st)
						System.out.println(s);
				}
			else
				System.out.println("No Object Found");
			
		} finally {
			// TODO: handle finally clause
			factory.close();
		}
	}

}
