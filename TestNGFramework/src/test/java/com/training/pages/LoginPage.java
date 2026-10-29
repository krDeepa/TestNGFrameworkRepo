package com.training.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.training.base.BasePage;

public class LoginPage extends BasePage{
	
	 
	public LoginPage(WebDriver driver) {
		super(driver);
		//this.driver=driver;
	    //1. Initialize fields of the current class instance using the driver
		//PageFactory.initElements(driver,this);
		// 2. Instantiate a page class and initialize its elements
		//LoginPage page = PageFactory.initElements(driver, LoginPage.class);
	}
	/*
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
		loginButton.click();
	}*/

	public void handleAlert() {
		//Thread.sleep(1000);
		driver.switchTo().alert().accept();		
	}

}
