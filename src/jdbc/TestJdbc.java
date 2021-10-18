package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbc {

	public static void main(String[] args) {
		
		String url="jdbc:mysql://localhost:3306/student_tracker?useSSL=false&serverTimezone=UTC";
		String user="student";
		String password="student";
		try {
			@SuppressWarnings("unused")
			Connection myConn = DriverManager.getConnection(url, user, password);
			System.out.println("connection Succesful");
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
