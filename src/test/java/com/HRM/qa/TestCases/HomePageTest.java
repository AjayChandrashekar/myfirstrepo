package com.HRM.qa.TestCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.HRM.qa.TestBase.TestBase;
import com.HRM.qa.pages.HomePage;
import com.HRM.qa.pages.LoginPage;

public class HomePageTest extends TestBase{
	HomePage home;
	LoginPage login;
	public HomePageTest() {
		super();
		
	}
	
	@BeforeMethod
	public void SetUp() {
		initialize();
		login=new LoginPage();
		home=login.ValidateLogin(prop.getProperty("username"), prop.getProperty("Password"));
				
	}
	
	@Test
	public void clickpim() {
		home.clickpimlink();
		String url=driver.getCurrentUrl();
		Assert.assertEquals(url, "https://opensource-demo.orangehrmlive.com/web/index.php/pim/viewEmployeeList");
	}
	
	@AfterMethod
	public void TearDown() {
		driver.quit();
	}
	

}
