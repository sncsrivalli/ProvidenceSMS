package org.sdet40.practice;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BasicConfigurationPracticeTest {
	
	@BeforeSuite
	public void suite1Setup() {
		System.out.println("suite1");
	}
	
	@BeforeTest
	public void beforeTestSetup() {
		System.out.println("Before Test");
	}
	
	@BeforeClass
	public void classSetup() {
		System.out.println("Before class");
	}
	
	@BeforeMethod
	public void methodSetup() {
		System.out.println("Before Method");
	}
	
	@Test
	public void test1() {
		System.out.println("Test1");
	}
	
	@Test
	public void test2() {
		System.out.println("Test2");
	}
	
	@AfterSuite
	public void suite1Teardown() {
		System.out.println("suite1");
	}
	
	@AfterTest
	public void beforeTeardown() {
		System.out.println("After Test");
	}
	
	@AfterClass
	public void classTeardown() {
		System.out.println("After class");
	}
	
	@AfterMethod
	public void methodTeardown() {
		System.out.println("After Method");
	}
}
