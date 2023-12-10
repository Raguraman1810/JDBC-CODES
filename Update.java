package com;
import java .sql.*;

public class Update {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection c= DriverManager.getConnection("jdbc:mysql://localhost:3306/student_db","root","root");
			
			Statement s=c.createStatement();
			
			s.executeUpdate("update student set mobile=6381579252 where id=1");
			System.out.println("Updated");
			
		}catch(ClassNotFoundException |SQLException e) {
			e.printStackTrace();
		}
	}

}
