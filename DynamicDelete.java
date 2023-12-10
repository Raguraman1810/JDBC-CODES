package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class DynamicDelete {
	static Scanner sc= new Scanner(System.in);
	public static void main(String[] args) {
		
		System.out.println("Enter the id:");
		int id=sc.nextInt();
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection c= DriverManager.getConnection("jdbc:mysql://localhost:3306/student_db","root","root");
			
			PreparedStatement ps= c.prepareStatement("delete from student where id=?");
			
			ps.setInt(1,id);
			
			ps.executeUpdate();
			
			System.out.println("Deleted");

      }catch(ClassNotFoundException  |  SQLException e) {
	      e.printStackTrace();
       }
	}
}
