package com.training.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.base.BaseTest;
import com.training.pages.HomePage;
import com.training.pages.LoginPage;
import com.training.pages.SwitchToPage;
import com.training.utilities.ScreenshotsImg;

public class SwitchToTest extends BaseTest{
	
	SwitchToPage switchToPage;
	ScreenshotsImg screenshot=new ScreenshotsImg();	
	
	@BeforeMethod
	public void gotoApplication() {
		driver=launchApplication();
		validLogin();
		//loginPage=new LoginPage(driver);		
		switchToPage=new SwitchToPage(driver);	
		
	}
	
	@Test
	public void clickOnSwitchToTab() {	
		
		methodName=Thread.currentThread().getStackTrace()[1].getMethodName();
		switchToPage.goToSwitchToTab();
		screenshot.captureScreenshot(driver,methodName);
	}	
	
	
	@AfterMethod
	public void teardown() {
		//screenshot= new ScreenshotsImg();		
		//screenshot.captureScreenshot(driver,methodName);	
		closeApplication();
	}
	
	

}
