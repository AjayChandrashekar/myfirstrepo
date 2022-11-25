package com.HRM.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.HRM.qa.TestBase.TestBase;

public class HomePage extends TestBase{

	@FindBy(xpath = "//a[@class='oxd-main-menu-item']/../..//span[text()='PIM']")
	WebElement pim;
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public PIMPage clickpimlink() {
		pim.click();
		return new PIMPage();
	}
}
