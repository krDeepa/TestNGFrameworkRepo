package com.training.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import com.training.base.BasePage;

public class SwitchToPage extends BasePage {

	public SwitchToPage(WebDriver driver) {
		super(driver);
		
	}
	
	@FindBy(xpath="//button[contains(text(),'Switch')]")
	WebElement switchToTab;
	
	public void goToSwitchToTab() {
		waitForElement(switchToTab,2);
		Actions mouseAction=new Actions(driver);
		mouseAction.moveToElement(switchToTab).build().perform();		
	}
	

}
