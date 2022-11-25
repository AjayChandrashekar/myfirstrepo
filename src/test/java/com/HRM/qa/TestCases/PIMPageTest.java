package com.HRM.qa.TestCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.HRM.qa.TestBase.TestBase;
import com.HRM.qa.pages.HomePage;
import com.HRM.qa.pages.LoginPage;
import com.HRM.qa.pages.PIMPage;

public class PIMPageTest extends TestBase{
	
	LoginPage login;
	HomePage home;
	PIMPage pim;
	public PIMPageTest() {
		super();
	}
	
	@BeforeMethod
	public void SetUp() {
		initialize();
		login=new LoginPage();
		home=login.ValidateLogin(prop.getProperty("username"), prop.getProperty("Password"));
		pim=home.clickpimlink();
	}
	
	@Test
	public void validateaddemppage() {
		pim.clickaddbtn();
		String url=driver.getCurrentUrl();
		Assert.assertEquals(url, "https://opensource-demo.orangehrmlive.com/web/index.php/pim/addEmployee");
	}
	
	
	@AfterMethod
	public void TearDown() {
		driver.quit();
	}

}
