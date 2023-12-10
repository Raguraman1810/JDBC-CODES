package com;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class DynamicInsert {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the id:");
		int id=sc.nextInt();
		System.out.println("Enter the name:");
		String name=sc.next();
		System.out.println("Enter the marks:");
		double marks=sc.nextDouble();
		System.out.println("Enter the mobile no:");
		long mobile=sc.nextLong();
		System.out.println("Enter the age:");
		int age=sc.nextInt();
		System.out.println("Enter the gender:");
		String gender=sc.next();
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection c= DriverManager.getConnection("jdbc:mysql://localhost:3306/student_db","root","root");
			
			PreparedStatement ps=c.prepareStatement("insert into student values (?,?,?,?,?,?)");
			
			ps.setInt(1, id);
			ps.setString(2, name);
			ps.setDouble(3,marks);
			ps.setLong(4,mobile);
			ps.setInt(5, age);
			ps.setString(6, gender);
			
			ps.executeUpdate();
			
			System.out.println("data inserted");
			
		}catch(ClassNotFoundException | SQLException e) {
		       e.printStackTrace();
		}
	}

}
