package com;
import java.sql.*;
public class Delete {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection c= DriverManager.getConnection("jdbc:mysql://localhost:3306/student_db","root","root");
			
			Statement s=c.createStatement();
			
			s.executeUpdate("delete from student where id=3");
			
			System.out.println("data deleted");
	
	}catch(ClassNotFoundException |SQLException e) {
		e.printStackTrace();
	}
		
	}
}