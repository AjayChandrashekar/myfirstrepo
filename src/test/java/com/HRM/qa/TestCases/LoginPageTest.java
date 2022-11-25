package com.HRM.qa.TestCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.HRM.qa.TestBase.TestBase;
import com.HRM.qa.pages.LoginPage;


public class LoginPageTest extends TestBase{
	LoginPage login;
	public LoginPageTest() {
		super();
	}
	
	@BeforeMethod
	public void SetUp() {
		initialize();
		login=new LoginPage();
	}
	
	@Test
	public void TitleTest() {
		String Title=login.ValidateTitle();
		Assert.assertEquals(Title, "OrangeHRM");
	}
	
	@Test
	public void LogoTest() {
		boolean logo=login.ValidateLogo();
		Assert.assertTrue(logo);
	}
	
	@Test
	public void logintest() {
		login.ValidateLogin(prop.getProperty("username"), prop.getProperty("Password"));
		String Cur_Url=driver.getCurrentUrl();
		Assert.assertEquals(Cur_Url, "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index");
	}
		
	@AfterMethod
	public void TearDown() {
		driver.quit();
	}

	
	
	
	
	

}
