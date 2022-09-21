package org.sdet40.practice;

import java.sql.Connection;
import java.sql.DriverManager;
//import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class ModifyDataFromDataBase {

	public static void main(String[] args) throws SQLException {
		Driver dbDriver = new Driver();
		
		DriverManager.registerDriver(dbDriver);
	
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/srivalli","root","root");
		try {
			Statement statement = connection.createStatement();
			int result = statement.executeUpdate("insert into ;");
			System.out.println(result + " Data Updated Successfully");
		}
		
	finally
	{
		connection.close();
		System.out.println("Connection closed successfully");
	}
	}

}
