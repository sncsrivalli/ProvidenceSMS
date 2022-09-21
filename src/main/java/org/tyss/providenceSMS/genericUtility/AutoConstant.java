
package org.tyss.providenceSMS.genericUtility;
/**
 * This interface consists of all the external file paths
 * @author sncsr
 *
 */

public interface AutoConstant {

	String PROJECT_PATH = System.getProperty("user.dir");
	String EXCEL_PATH = PROJECT_PATH +"/src/test/resources/TestData.xlsx";
	String PROPERTY_FILE_PATH = PROJECT_PATH + "/src/test/resources/Credentials.properties";
	String PHOTO_PATH = PROJECT_PATH + "/src/test/resources/photo";
	String DB_URL ="jdbc:mysql://localhost:3306/srivalli";
}
