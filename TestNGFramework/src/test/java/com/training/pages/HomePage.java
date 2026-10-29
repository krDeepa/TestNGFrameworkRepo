package com.training.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.training.base.BasePage;

public class HomePage extends BasePage {
	
	public HomePage(WebDriver driver) {
		super(driver);
		//this.driver=driver;
		//PageFactory.initElements(driver, this);
	}
		
	@FindBy(linkText="Home")
	WebElement homeTab;
	
	@FindBy(id="name")
	WebElement firstName;
	
	@FindBy(id="lname")
	WebElement lastName;
	
	@FindBy(xpath="//input[@id='postaladdress']")
	WebElement postalAdd;
	
	@FindBy(id="personaladdress")
	WebElement personalAdd;
	
	@FindBy(xpath="//input[@value='female']")
	WebElement gender;
	
	@FindBy(id="city")
	WebElement city;
	
	@FindBy(id="course")
	WebElement course;
	
	@FindBy(xpath="//select[@id='district']")
	WebElement district;
	
	@FindBy(xpath="//select[@name='state']")
	WebElement state;
	
	@FindBy(id="pincode")
	WebElement pincode;
	
	@FindBy(id="emailid")
	WebElement emailid;
	
	@FindBy(className="bootbutton")
	WebElement submit;
	
	
	public void gotoHomeTab() {
		waitForElement(homeTab, 4);
		homeTab.click();			
	}
	public void enterName() {
		firstName.sendKeys("Deepa");
	}
	public void enterFatherName() {
		lastName.sendKeys("K R");
	}
	public void enterPostalAdd() {
		postalAdd.sendKeys("USA");
	}
	public void enterPersonalAdd() {
		personalAdd.sendKeys("USA");
	}
	public void optGender() {
		gender.click();
	}
	public void selectCity() {
		Select cityDropdown=new Select(city); 
		cityDropdown.selectByVisibleText("NEW DELHI");
	}
	public void selectCourse() {
		Select courseDropdown=new Select(course);
		courseDropdown.selectByValue("mba");		
	}
	public void selectDistrict() {
		Select districtDropdown=new Select(district);
		districtDropdown.selectByIndex(1);	
	}
	public void selectState() {
		Select stateDropdown=new Select(state);
		stateDropdown.selectByIndex(3);
	}
	
	public void enterPincode() {
		pincode.sendKeys("122345");
	}
	public void enterEmailid() {
		emailid.sendKeys("deepa@dkr.com");
	}	
	
	public void clickOnSubmit()  {
		waitForElement(submit, 5);
		submit.click();
	}
	
	
	
	
}
