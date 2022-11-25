package com.HRM.qa.pages;

//import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.HRM.qa.TestBase.TestBase;

public class LoginPage extends TestBase{

	@FindBy(name="username")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//button[text()=' Login ']")
	WebElement loginbtn;
	
	@FindBy(xpath="//p[text()='Forgot your password? ']")
	WebElement forgotpwd;
	
	@FindBy(xpath="//img[@alt='company-branding']")
	WebElement HRMLogo;
	

	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String ValidateTitle() {
		return driver.getTitle();
	}
	
	public boolean ValidateLogo() {
		return HRMLogo.isDisplayed();
	}
	
	public HomePage ValidateLogin(String un,String pwd) {
		username.sendKeys(un);
		password.sendKeys(pwd);
		loginbtn.click();
		
		return new HomePage();
		
	}
		
	
}
