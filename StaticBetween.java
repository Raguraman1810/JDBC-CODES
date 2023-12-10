package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class StaticBetween {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_db","root","root");
			
			Statement s= c.createStatement();
			
			ResultSet rs = s.executeQuery("select * from student where mark between 97 and 99");
			
			
			while(rs.next()) {
				
				System.out.println("id:"+rs.getInt("id"));
				System.out.println("name:"+rs.getString("name"));
				System.out.println("mark:"+rs.getDouble("mark"));
				System.out.println("mobile:"+rs.getLong("mobile"));
				System.out.println("age:"+rs.getInt("age"));
				System.out.println("gender:"+rs.getString("gender"));
				System.out.println("*******************************************************************************************");
			}
			
			
		}catch(ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

}
