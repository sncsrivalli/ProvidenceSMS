 package org.tyss.providenceSMS.genericUtility;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenerImplementation implements ITestListener {
	
	private ExtentReports reports;
	public static ExtentTest stest;
	private ExtentTest test;
	
	@Override//BT
	public void onStart(ITestContext context) {
		ExtentSparkReporter spark = new ExtentSparkReporter("./extentReport/extentreport.html");
		spark.config().setDocumentTitle("Document Title - ProvidenceSMS");
		spark.config().setReportName("Report Name - ProvidenceSMS");
		spark.config().setTheme(Theme.STANDARD);
		
		reports = new ExtentReports();
		reports.attachReporter(spark);
		reports.setSystemInfo("Author", "Srivalli");
		reports.setSystemInfo("OS", "Win 11");
		reports.setSystemInfo("Browser", "Chrome");
	}
	@Override//BM
	public void onTestStart(ITestResult result) {
		test = reports.createTest(result.getMethod().getMethodName());
		stest = test;
		
	}
	
	@Override//AM
	public void onTestSuccess(ITestResult result) {
		test.pass(result.getMethod().getMethodName()+"Pass");
	}
	
	@Override//AM
	public void onTestSkipped(ITestResult result) {
		test.skip(result.getMethod().getMethodName());
		test.fail(result.getThrowable());
	}
	
	@Override//AM
	public void onTestFailure(ITestResult result) {
		test.fail(result.getMethod().getMethodName()+"Fail");
		//System.out.println(Thread.currentThread().getId());
		//new WebDriverUtility().getScreenshot(BaseClass.sdriver,BaseClass.sjavaUtility,result.getMethod().getMethodName());
		new WebDriverUtility().getScreenshot(BaseClass.sdriver);
		
	}
	
	
	
	@Override//AT
	public void onFinish(ITestContext context) {
		reports.flush();
	}
	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}
}
