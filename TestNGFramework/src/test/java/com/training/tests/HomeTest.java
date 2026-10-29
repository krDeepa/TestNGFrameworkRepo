package com.training.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.base.BaseTest;
import com.training.pages.HomePage;
import com.training.pages.LoginPage;
import com.training.utilities.ScreenshotsImg;

public class HomeTest extends BaseTest{
	
	LoginPage loginPage;
	HomePage homePage;
	//ScreenshotsImg screenshot=new ScreenshotsImg();
	
	
	@BeforeMethod
	public void gotoApplication() {
		driver=launchApplication();
		loginPage=new LoginPage(driver);		
		homePage=new HomePage(driver);	
	}
	
	@Test
	public void clickOnHomeTab() throws InterruptedException {
		validLogin();		
		//methodName="clickOnHomeTab";
		methodName=Thread.currentThread().getStackTrace()[1].getMethodName();
		homePage.gotoHomeTab();
		screenshot.captureScreenshot(driver,methodName);
	}
	
	@Test
	public void fillStudentForm() {		
		//methodName="fillStudentForm";
		methodName=Thread.currentThread().getStackTrace()[1].getMethodName();
		validLogin();
		homePage.gotoHomeTab();
		homePage.enterName();
		homePage.enterFatherName();
		homePage.enterPostalAdd();
		homePage.enterPersonalAdd();
		homePage.optGender();
		homePage.selectCity();
		homePage.selectCourse();
		homePage.selectDistrict();
		homePage.selectState();
		homePage.enterPincode();
		homePage.enterEmailid();	
		screenshot.captureScreenshot(driver,methodName);
		homePage.clickOnSubmit();
	}	
	
	@AfterMethod
	public void teardown() {
		//screenshot= new ScreenshotsImg();		
		//screenshot.captureScreenshot(driver,methodName);	
		closeApplication();
	}
	
	

}
