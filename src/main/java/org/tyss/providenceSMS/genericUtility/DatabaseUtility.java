package org.tyss.providenceSMS.genericUtility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.jdbc.Driver;
/**
 * This class consists of all the actions of database
 * @author sncsr
 *
 */

public class DatabaseUtility {
	
	private Connection connection;
	
	/**
	 * This method is used to open the database connection
	 * @param dburl
	 * @param dbName
	 * @param dbPassword
	 * @throws SQLException
	 */
	public void openDatabaseConnection(String dburl,String dbName,String dbPassword) throws SQLException{
		
		Driver dbdriver = new Driver();
		
			DriverManager.registerDriver(dbdriver);
			connection = DriverManager.getConnection(dburl,dbName,dbPassword);
		
	}
	
	/**
	 * This method is used to fetch the data from database
	 * @param query
	 * @param columnName
	 * @return
	 * @throws SQLException
	 */
	public List<String> getDataFromDatabase(String query,String columnName) throws SQLException {
		
		Statement statement = connection.createStatement();
		ResultSet result = statement.executeQuery(query);
		List<String> list = new ArrayList<>();
		while(result.next()) {
			list.add(result.getString(columnName));
		}
		return list;
	}
	
	/**
	 * This method is used to close the database connection
	 * @throws SQLException
	 */
	public void closeDatabase() throws SQLException {
		connection.close();
	}

}
