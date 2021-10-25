package hibernate.demo.manytomany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateCourseAndStudents {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SessionFactory sessionFactory = new Configuration().configure("hibernate.manytomany.xml")
				.addAnnotatedClass(Student.class).addAnnotatedClass(Instructor.class).addAnnotatedClass(Course.class)
				.addAnnotatedClass(InstructorDetail.class).buildSessionFactory();

		Session session = sessionFactory.getCurrentSession();
		try {
			session.beginTransaction();
			Course c1 = new Course("Java");
			session.save(c1);
			Course c2 = new Course("Python");
			session.save(c2);
			Course c3 = new Course("C++");
			session.save(c3);
			Student s1 = new Student("Akashdeep", "Bhattacharya", "beingakscool@gmail.com");
			session.save(s1);
			Student s2 = new Student("Akash", "Bhattacharya", "ab@gmail.com");
			session.save(s2);
			c1.add(s1);
			c1.add(s2);
			c2.add(s2);
			c3.add(s1);
			
		} finally {
			// TODO: handle finally clause
			sessionFactory.close();
		}

	}

}
