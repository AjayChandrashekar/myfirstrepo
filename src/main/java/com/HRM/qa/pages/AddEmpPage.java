package com.HRM.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.HRM.qa.TestBase.TestBase;

public class AddEmpPage extends TestBase{

	@FindBy(name = "firstName")
	WebElement emp_fname;
	
	@FindBy(name="lastName")
	WebElement emp_lname;
	
	@FindBy(xpath = "//button[@type='submit']")
	WebElement savebtn;
	
	public AddEmpPage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean AddNewEmp(String fname,String lname) throws Exception {
		emp_fname.sendKeys(fname);
		emp_lname.sendKeys(lname);
		savebtn.click();
		Thread.sleep(10000);
		String text=driver.findElement(By.xpath("(//h6)[2]")).getText();
		System.out.println(text);
		if(text.equals(fname+" "+lname)) {
			return true;
		}
		else {
			return false;
		}
		
	}
	
}
