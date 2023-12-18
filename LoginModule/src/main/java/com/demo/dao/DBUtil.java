package com.demo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	
	public DBUtil() {
		
	}
	
	public static Connection getCon(){
		Connection con=null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url="jdbc:oracle:thin:LAPTOP-QJ1OKKKP:1521:orcl";
			System.out.println("Driver Looaded");
			con=DriverManager.getConnection(url,"hr","tiger");
			System.out.println("Connection : "+con);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}
	
	public static Connection getCon(String driver,String url,String un,String pd){
		Connection con=null;
		
		try {
			Class.forName(driver);
			con=DriverManager.getConnection(url,"un","pd");
			System.out.println("Connection : "+con);
		} 
		catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}
	
	public static void main(String[] args) {
		Connection con=DBUtil.getCon();
		System.out.println(con);
	}
}