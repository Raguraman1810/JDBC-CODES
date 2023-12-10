package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class StaticSelect {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_db","root","root");
			
			Statement s = c.createStatement();
			
			ResultSet rs = s.executeQuery("select name,mark,mobile from student where name='ragu'");
			
			while(rs.next()) {
				System.out.println("name:"+ rs.getString(1));
				System.out.println("marks:"+ rs.getDouble(2));
				System.out.println("mobile:"+ rs.getLong(3));
				System.out.println("*******************************************************************");
			}
			
		}catch(ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

}
