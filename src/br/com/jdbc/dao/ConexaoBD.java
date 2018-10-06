package br.com.jdbc.dao;

import java.sql.Connection;
import java.sql.DriverManager;

//class conection
public class ConexaoBD {
	static String status="";
	public static Connection getConnection() {
		Connection conn = null;
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/uniasselvi","root","");
			
			if (conn == null) {
				System.out.println("33333333 ---->>  Conn está null");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("Class Conexão - Exception: "+ e.getMessage());
			
		}
		
		return conn;
	}
}
