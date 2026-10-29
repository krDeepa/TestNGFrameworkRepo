package com.training.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.base.BaseTest;
import com.training.pages.LoginPage;

public class LoginTest extends BaseTest{
	LoginPage loginPage;
	
	@BeforeMethod
	public void gotoApplication() {
		driver=launchApplication();
		loginPage=new LoginPage(driver);		
	}
	
	@Test
	public void validUserLogin() {
		//loginPage.enterUsername("admin123@gmail.com");
		//loginPage.enterPassword("admin123");			
		String user=propFile.readPropertiesFile("userName");
		loginPage.enterUsername(user);
		String pwd=propFile.readPropertiesFile("password");
		loginPage.enterPassword(pwd);
		loginPage.login();
		methodName=Thread.currentThread().getStackTrace()[1].getMethodName();
		screenshot.captureScreenshot(driver,methodName);
	}	
	
	@Test
	public void invalidLoginPwd() {
		loginPage.enterUsername("admin123@gmail.com");
		loginPage.enterPassword("admin");		
		loginPage.login();	
		methodName=Thread.currentThread().getStackTrace()[1].getMethodName();
		screenshot.captureScreenshot(driver,methodName);
	}
	@Test
	public void invalidLoginUser() {
		loginPage.enterUsername("a123@gmail.com");
		loginPage.enterPassword("admin123");
		loginPage.login();	
		methodName=Thread.currentThread().getStackTrace()[1].getMethodName();
		screenshot.captureScreenshot(driver,methodName);
	}
	@Test
	public void invalidLogin() {
		loginPage.enterUsername("a123@gmail.com");
		loginPage.enterPassword("ad123");
		loginPage.login();		
		methodName=Thread.currentThread().getStackTrace()[1].getMethodName();
		screenshot.captureScreenshot(driver,methodName);
	}
	@Test
	public void loginWithOnlyUsername() throws InterruptedException {
		methodName=Thread.currentThread().getStackTrace()[1].getMethodName();
		loginPage.enterUsername("admin123@gmail.com");		
		loginPage.login();			
		loginPage.handleAlert();
		screenshot.captureScreenshot(driver,methodName);			
	}
	@Test
	public void loginWithOnlyPwd() throws InterruptedException {
		methodName=Thread.currentThread().getStackTrace()[1].getMethodName();
		loginPage.enterPassword("admin123");		
		loginPage.login();			
		loginPage.handleAlert();
		screenshot.captureScreenshot(driver,methodName);			
	}
	
	@AfterMethod
	public void teardown() {
		closeApplication();
	}
	
	
}
