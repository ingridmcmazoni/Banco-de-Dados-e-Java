package dao;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class JDBCUtil {
	private final static String JDBC_CLASS = "com.mysql.jdbc.Driver";
	private final static String JDBC_URL = "jdbc:mysql://localhost:3306/biblioteca";
	private final static String JDBC_USERID = "root";
	private final static String JDBC_PASSWORD = "123456";
	private static Connection con;
	private static JDBCUtil jdbcutil;
	
	private JDBCUtil() { 		
	}
	public static Connection getConnection() throws SQLException {
		if (con == null) {
			try {
				Class.forName( JDBC_CLASS );
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		if (con == null || (con != null && !con.isValid(3))) { 
			con = DriverManager.getConnection(JDBC_URL, JDBC_USERID, JDBC_PASSWORD);
		}
		return con;
	}


	
	public static JDBCUtil getInstance() { 
		if (jdbcutil == null) { 
			jdbcutil = new JDBCUtil();
		}
		return jdbcutil;
	}
	
	public static void fechaConexao(){
		try {
			if(con!=null) 
				con.close();
			con =null;
		} 
		catch(Exception e) {
			e.printStackTrace();
		}
		}
		
}
