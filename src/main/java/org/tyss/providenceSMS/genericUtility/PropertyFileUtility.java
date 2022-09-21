package org.tyss.providenceSMS.genericUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * This class consists of the actions performed on Property file
 * @author sncsr
 *
 */

public class PropertyFileUtility {
	Properties property ;
	/**
	 * This method is used to initialize Property file
	 * @param propertyPath
	 */
	
	public void initializePropertyFile(String propertyPath) {
		FileInputStream fisProperty = null;
		
		try {
			fisProperty = new FileInputStream(propertyPath);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		property = new Properties();
		
		try {
			property.load(fisProperty);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * This method consists of the code to fetch data from Property file
	 * @param propertyPath
	 * @param key
	 * @return
	 */
	
	public String getDataFromPropertyFile(String key) {
		
		return property.getProperty(key).trim();
	}

}
