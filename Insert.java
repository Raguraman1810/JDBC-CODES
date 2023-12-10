package com;

import java.sql.*;


public class Insert {
	public static void main(String[] args) {
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/student_db","root","root");
		
		Statement s = c.createStatement();
		
		s.executeUpdate("insert into student values (2,'prethika',97.2,6381091298,24,'female')");
		
		System.out.println("data inserted");
		
		
		}
		catch(ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			
		}
	}

}
