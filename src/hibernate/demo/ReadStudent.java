package hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hibernate.demo.entity.Student;

public class ReadStudent {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			session.beginTransaction();
			Student stu = session.get(Student.class,4);
			if(stu!=null)
				System.out.println(stu.toString());
			else
				System.out.println("No Object Found");
			
		} finally {
			// TODO: handle finally clause
			factory.close();
		}
	}

}
