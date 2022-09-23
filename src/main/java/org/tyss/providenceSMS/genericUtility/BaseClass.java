package org.tyss.providenceSMS.genericUtility;

import org.openqa.selenium.WebDriver;
import org.providenceSMS.objectRepository.AddExamTimetablePage;
import org.providenceSMS.objectRepository.AddStudentPage;
import org.providenceSMS.objectRepository.AddSubjectRoutingPage;
import org.providenceSMS.objectRepository.AddTeacherPage;
import org.providenceSMS.objectRepository.AllTeacherPage;
import org.providenceSMS.objectRepository.ClassroomPage;
import org.providenceSMS.objectRepository.CommonPage;
import org.providenceSMS.objectRepository.CreateEventPage;
import org.providenceSMS.objectRepository.ExamTimetablePage;
import org.providenceSMS.objectRepository.GradePage;
import org.providenceSMS.objectRepository.MyPettyCashHistoryPage;
import org.providenceSMS.objectRepository.MySonsExamTimetablePage;
import org.providenceSMS.objectRepository.ParentHomePage;
import org.providenceSMS.objectRepository.PettyCashHistoryPage;
import org.providenceSMS.objectRepository.StudentPaymentInvoicePage;
import org.providenceSMS.objectRepository.SubjectPage;
import org.providenceSMS.objectRepository.SubjectsPopUp;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class BaseClass {
	protected WebDriver driver;
	protected WebDriverUtility webdriver;
	protected PropertyFileUtility property;
	protected JavaUtility javaUtility;
	public ExcelUtility excel;
	protected CommonPage commonPage;
	protected AddTeacherPage addTeacherAction;
	protected ParentHomePage parenthomePage;
	protected AllTeacherPage allTeacherPage;
	protected AddExamTimetablePage  addExam ;
	protected ExamTimetablePage examTimetable;
	protected AddSubjectRoutingPage addSubjectRoutingPage;
	protected MySonsExamTimetablePage mySonsExamTimetable;
	protected MyPettyCashHistoryPage myPettyCash;
	protected PettyCashHistoryPage pettyCash;
	protected AddStudentPage addStudent;
	protected SubjectsPopUp subjectTable;
	protected StudentPaymentInvoicePage invoicePopup;
	protected CreateEventPage createEvent;
	public static WebDriver sdriver;
	public static JavaUtility sjavaUtility;
	protected ClassroomPage classroomPage;
	protected GradePage gradePage;
	protected SubjectPage subjectPage;
	
	@BeforeClass
	public void classSetup() {
		
		webdriver = new WebDriverUtility();
		property = new PropertyFileUtility();
		javaUtility = new JavaUtility();
		sjavaUtility = javaUtility;
	
		excel = new ExcelUtility();
		
		excel.initializeExcel(AutoConstant.EXCEL_PATH);
		property.initializePropertyFile(AutoConstant.PROPERTY_FILE_PATH);

		String browser = property.getDataFromPropertyFile("browser");
		String path = property.getDataFromPropertyFile("url");

		String time = property.getDataFromPropertyFile("timeout");
		long timeouts = (Long) (javaUtility.convertStringToAnyData(time, DataType.LONG));
		driver = webdriver.openBrowserAndApplication(browser, timeouts, path);
		sdriver = driver;
		commonPage = new CommonPage(driver);
		
	}

	@BeforeMethod
	public void methodSetup() {
		
		addTeacherAction = new AddTeacherPage(driver);
		parenthomePage = new ParentHomePage(driver);
		allTeacherPage =new AllTeacherPage(driver);
		addExam = new AddExamTimetablePage(driver);
		addSubjectRoutingPage = new AddSubjectRoutingPage(driver);
		examTimetable = new ExamTimetablePage(driver);
		mySonsExamTimetable = new MySonsExamTimetablePage(driver);
		myPettyCash = new MyPettyCashHistoryPage(driver);
		pettyCash = new PettyCashHistoryPage(driver);
		addStudent = new AddStudentPage(driver);
		subjectTable = new SubjectsPopUp(driver);
		invoicePopup = new StudentPaymentInvoicePage(driver);
		createEvent = new CreateEventPage(driver);
		classroomPage = new ClassroomPage(driver);
		gradePage = new GradePage(driver);
		subjectPage = new SubjectPage(driver);
	}
	
	@AfterClass
	public void classTeardown() {
		excel.closeExcelWorkbook();
		webdriver.closeDriver();
	}
	

}
