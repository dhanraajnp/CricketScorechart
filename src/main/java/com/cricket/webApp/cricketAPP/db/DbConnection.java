package com.cricket.webApp.cricketAPP.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DbConnection {
	
	private static Connection con;
	private static Statement stmt;
	public static Statement connect_mySQL(String dataBase){
		
		try {
			Class.forName("com.mysql.jdbc.Driver");  
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/"+dataBase+"","root","root"); 
			stmt =con.createStatement(); 
			System.out.println("DB:Connection is success");
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println("Fail : "+e.getLocalizedMessage());
		}
		return stmt;
	}
	
	public static void close_MySQL() {
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.err.println(e.getLocalizedMessage());
			e.printStackTrace();
		}
		
	}
}
