package com.HRM.qa.util;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.HRM.qa.TestBase.TestBase;



public class WebEventListener extends TestBase implements ITestListener{

	public void onTestStart(ITestResult result) {
		System.out.println("Test starts now");
	}

	public void onTestSuccess(ITestResult result) {
		System.out.println("Test completed Successfully");
	}

	public void onTestFailure(ITestResult result) {
		try {
			TestUtility.takeScreenshotAtEndOfTest();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}

	public void onTestSkipped(ITestResult result) {
		System.out.println("Test skipped Due to"+result);
	}

	public void onStart(ITestContext context) {
		System.out.println("onStart");
		
	}

	public void onFinish(ITestContext context) {
		System.out.println("onFinish");
		
	}
	

}
