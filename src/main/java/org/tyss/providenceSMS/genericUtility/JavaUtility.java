package org.tyss.providenceSMS.genericUtility;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
/**
 * This class consists of all the reusable java actions
 * @author sncsr
 *
 */

public class JavaUtility {
	/**
	 * This method is used to generate random number
	 * @param limit
	 * @return
	 */
	
	public int getRandomNumber(int limit) {
		
		return new Random().nextInt(limit);
	}

	public Object convertStringToAnyData(String data, DataType strategy) {
		Object obj = null;
		if(strategy.toString().equalsIgnoreCase("long"))
		{
			obj= Long.parseLong(data);
		}
		else if(strategy.toString().equalsIgnoreCase("int"))
		{
			obj= Integer.parseInt(data);
		}
		else if(strategy.toString().equalsIgnoreCase("double"))
		{
			obj= Double.parseDouble(data);
		}
		return obj;
	}
	
	/**
	 * This method is used to perform ROBOT class actions
	 * @throws AWTException 
	 */
	public void robotClass()  {
		Robot r=null;
		try {
			r = new Robot();
		} catch (AWTException e) {
			e.printStackTrace();
		}
		
		r.keyPress(KeyEvent.VK_ESCAPE);
		r.keyRelease(KeyEvent.VK_ESCAPE);
		
	}
	/**
	 * This method is used to get current time
	 * @return
	 */
	public String currentTime() {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("dd_MM_yyyy_hh_mm_sss");
		String actualDate = sdf.format(date);
		return actualDate;
	}
}
