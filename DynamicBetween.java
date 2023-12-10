package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class DynamicBetween {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the mark1");
		double mark1 = sc.nextDouble();
		System.out.println("Enter the mark2");
		double mark2 = sc.nextDouble();
		
		System.out.println("Enter the mark 1");
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_db","root","root");
			
			PreparedStatement ps = c.prepareStatement("select name,mark,age from student where mark between ? and ? order by mark");
			
			ps.setDouble(1, mark1);
			ps.setDouble(2, mark2);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				System.out.println("Nmae:"+ rs.getString(1));
				System.out.println("Mark"+rs.getDouble(2));
				System.out.println("Age"+rs.getInt(3));
				System.out.println("***********************************************************");
			}
			
		}catch(ClassNotFoundException |SQLException e) {
			e.printStackTrace();
		}
		
	}

}
