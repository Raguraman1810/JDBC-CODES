package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class DynamicSelect {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Enter the name");
		String name = sc.next();
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_db","root","root");
			
			PreparedStatement ps = c.prepareStatement("select name,mobile,mark from student where name = ?");
			
			ps.setString(1, name);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				System.out.println("name:"+rs.getString(1));
				System.out.println("mobile:"+rs.getLong(2));
				System.out.println("mark:"+rs.getInt(3));
				System.out.println("************************************************************");
			}
					
		}catch(ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
	}

}
