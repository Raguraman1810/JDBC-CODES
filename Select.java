package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Select {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection c= DriverManager.getConnection("jdbc:mysql://localhost:3306/student_db","root","root");
			
			Statement s= c.createStatement();
			
			ResultSet rs = s.executeQuery("select * from student");
			
			while(rs.next()) {
				System.out.println("ID:" + rs.getInt(1));
				System.out.println("NAME:"+rs.getString(2));
				System.out.println("MARK :"+rs.getDouble(3));
				System.out.println("MOBILE:" + rs.getLong(4));
				System.out.println("AGE:"+ rs.getInt(5));
				System.out.println("GENDER:" + rs.getString(6));	
				System.out.println("*************************************************");
			}
			
			
		}catch(ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

}
