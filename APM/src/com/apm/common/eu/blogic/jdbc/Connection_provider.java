package com.apm.common.eu.blogic.jdbc;







import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Connection_provider {
public static Connection getconnection() throws SQLException
{
	Connection con=null;
	try {
		Class.forName("com.mysql.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/apm","root","mysql");
		System.out.println("done");
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	}
	return con;
}

public static void main(String[] args) throws SQLException {
	Connection_provider.getconnection();
	
}
}


