package org.sdet40.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class FetchDataFromDataBase {

	public static void main(String[] args) throws SQLException {
		Driver dbDriver = new Driver();
		
			DriverManager.registerDriver(dbDriver);
		
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/srivalli","root","root");
			try {
				Statement statement = connection.createStatement();
				ResultSet result = statement.executeQuery("select * from sdet_40;");
				while(result.next()) {
					System.out.println(result.getString("emp_name"));
				}
			}
			
		finally
		{
			connection.close();
			System.out.println("Connection closed successfully");
		}
		
	}

}
