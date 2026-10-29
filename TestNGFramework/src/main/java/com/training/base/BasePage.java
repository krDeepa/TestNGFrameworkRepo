package com.training.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasePage {
	
	protected WebDriver driver;	
	public BasePage(WebDriver driver) {
		
		this.driver=driver;
	    //1. Initialize fields of the current class instance using the driver
		PageFactory.initElements(driver,this);
		// 2. Instantiate a page class and initialize its elements
		//LoginPage page = PageFactory.initElements(driver, LoginPage.class);
	}
	
	@FindBy(id="email_field")
	WebElement email;
	
	@FindBy(id="password_field")
	WebElement password;
	
	@FindBy(xpath="//button[text()='Login to Account']")
	WebElement loginButton;
	
	public void enterUsername(String user) {
		email.sendKeys(user);
	}
	public void enterPassword(String pwd) {
		password.sendKeys(pwd);
	}
	public void login() {
		waitForElement(loginButton,2);
		loginButton.click();
	}
	
	public void waitForElement(WebElement element,int time) {
		WebDriverWait wait=new WebDriverWait(driver, time);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	

}
