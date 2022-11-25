package com.HRM.qa.TestCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.HRM.qa.TestBase.TestBase;
import com.HRM.qa.pages.AddEmpPage;
import com.HRM.qa.pages.HomePage;
import com.HRM.qa.pages.LoginPage;
import com.HRM.qa.pages.PIMPage;
import com.HRM.qa.util.TestUtility;


public class AddEmpPageTest extends TestBase{
	
	
	LoginPage login;
	HomePage home;
	PIMPage pim;
	AddEmpPage add;
	public AddEmpPageTest() {
		super();
	}
	
	@BeforeMethod
	public void SetUp() {
		initialize();
		login =new LoginPage();
		home=login.ValidateLogin(prop.getProperty("username"), prop.getProperty("Password"));
		pim=home.clickpimlink();
		add=pim.clickaddbtn();
	}
	
	@DataProvider
	public Object[][] getdata() {
		
		Object data[][]=TestUtility.GetTestData("Emp_data");
		return data;
	}
	
	
	
	
	@Test(dataProvider ="getdata")
	public void Addemp(String firstname,String lastname) throws Exception {
		boolean value=add.AddNewEmp(firstname, lastname);
		System.out.println(firstname+" "+lastname);
		
		Assert.assertTrue(value);
		
	}
	
	@AfterMethod
	public void TearDown() {
		driver.quit();
	}

}
