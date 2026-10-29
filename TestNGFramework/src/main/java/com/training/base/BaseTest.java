package com.training.base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.utilities.PropertiesFile;
import com.training.utilities.ScreenshotsImg;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	
	
	BasePage basePage;
	String link;	
	protected PropertiesFile propFile=new PropertiesFile();
	protected WebDriver driver;	
	protected String methodName;
	protected ScreenshotsImg screenshot=new ScreenshotsImg();
	
	public void explicitWait(WebElement element, int time) {
		WebDriverWait wait=new WebDriverWait(driver,time);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	public void fluentWait(WebElement element,int time) {
		FluentWait<WebDriver> wait=new FluentWait<WebDriver>(driver);
		wait.withTimeout(time,TimeUnit.SECONDS);
		wait.pollingEvery(200, TimeUnit.MILLISECONDS);
		wait.until(ExpectedConditions.elementToBeClickable(element));		
	}	
	
	public WebDriver launchApplication() {
		if(driver==null) {
			WebDriverManager.chromedriver().setup();
			ChromeOptions option=new ChromeOptions();
			option.addArguments("--incognito");		
			driver=new ChromeDriver(option);
			driver.manage().window().maximize();
			//String url="https://selenium-prd.firebaseapp.com/";
			//driver.get(url);
			
			String link=propFile.readPropertiesFile("url");
			System.out.println(link);
			driver.get(link);
			basePage=new BasePage(driver);
		}
		return driver;
	}
	
	public WebDriver validLogin() {
		
		String user=propFile.readPropertiesFile("userName");
		basePage.enterUsername(user);
		String pwd=propFile.readPropertiesFile("password");
		basePage.enterPassword(pwd);
		basePage.login();
		methodName=Thread.currentThread().getStackTrace()[1].getMethodName();
		screenshot.captureScreenshot(driver,methodName);
		return driver;
	}		
	
	public void closeApplication() {			
		driver.close();
		driver=null;
	}

}
