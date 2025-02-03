package JDBC_Connection;

import java.sql.*;

public class Demo {
	private static final String PASSWORD = "Kumar@sql_7";
	private static final String USERNAME = "root";
	private static final String JDBC_MYSQL_LOCALHOST = "jdbc:mysql://localhost:3306/new";

	public static void main(String[] args) throws SQLException {
		
		Connection con1 = Demo.Connection_Object();
		System.out.println("JDBC Connection");
		// Connection object creating 
		Connection con = Connection_Object();
		Statement stmt = con.createStatement();
		ResultSet res = stmt.executeQuery("Select * from mynewdatabase");
		System.out.println(res);
		System.out.println("JDBC Connection Obtained");
		dmlJdbcdemo(con);
		System.out.println("Done");
	}
	private static void dmlJdbcdemo(Connection con) throws SQLException {
		// Get Statement
		Statement stmt = con.createStatement();
		// stmt.execute("create table sai(id int, name varchar(25))");
		// Insert Data
		int noOfRows = stmt.executeUpdate("insert into mynewdatabase values('Kumar',45)");
		System.out.println(noOfRows);
		// Update
		int noOfRowsUpdate = stmt.executeUpdate("update mynewdatabase set myname = 'Lakshman Kumar' where roll=22");
		System.out.println(noOfRowsUpdate + " Rows Updated");
		// Delete
		int noOfRowsDelete = stmt.executeUpdate("delete from mynewdatabase where roll=4");
		System.out.println(noOfRowsDelete + " rows deleted");
	}
	// This method is same for all Users
	public static Connection Connection_Object() throws SQLException {
		Connection con = DriverManager.getConnection(JDBC_MYSQL_LOCALHOST, USERNAME, PASSWORD);
		return con;
	}
}
