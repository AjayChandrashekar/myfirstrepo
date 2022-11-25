package com.HRM.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.HRM.qa.TestBase.TestBase;

public class PIMPage extends TestBase{

	@FindBy(xpath = "//button[@class='oxd-button oxd-button--medium oxd-button--secondary']")
	WebElement addbtn;
	
	
	public PIMPage() {
		PageFactory.initElements(driver, this);
	}
	
	public AddEmpPage clickaddbtn() {
		addbtn.click();
		return new AddEmpPage();
	}
}
