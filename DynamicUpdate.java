package com;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;
public class DynamicUpdate {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the id:");
		int id=sc.nextInt();
		System.out.println("Enter the age:");
		int age =sc.nextInt();
		try {
            Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_db","root","root");
			
			PreparedStatement ps = c.prepareStatement("update student set age=? where id=?");
			
			ps.setInt(1, age);
			ps.setInt(2, id);
			
			ps.executeUpdate();
			
			System.out.println("Updated");
			
		}catch(ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

}
