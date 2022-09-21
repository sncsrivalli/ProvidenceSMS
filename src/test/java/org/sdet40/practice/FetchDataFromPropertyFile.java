package org.sdet40.practice;

import java.io.FileInputStream;
import java.io.FileOutputStream;
//import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class FetchDataFromPropertyFile {

	public static void main(String[] args) throws IOException {
		FileInputStream fis = new FileInputStream("./src/test/resources/commonData.properties");
		Properties property = new Properties();
		property.load(fis);
		String url = property.getProperty("url").trim();
		String adminLogin = property.getProperty("Admin_Login").trim();
		String adminPassword = property.getProperty("Admin_password").trim();
		System.out.println(url);
		System.out.println(adminLogin);
		System.out.println(adminPassword);
		
		//property.setProperty("url1","http://rmgtestingserver");
		property.put("url2","http://localhost:8081");
		FileOutputStream fos = new FileOutputStream("./src/test/resources/commonData.properties");
		property.store(fos,"url updated successfully");
	}

}
