package com.HRM.qa.TestBase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.HRM.qa.util.TestUtility;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	public static FileInputStream ip;
	
	public TestBase() {
		prop=new Properties();
		try {
			ip=new FileInputStream("F:\\java_selenium_practice\\OrangeHRMTest\\src\\main\\java\\com\\HRM\\qa\\config\\config.properties");
			try {
				prop.load(ip);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}	
		public static void initialize() {
			String Browser=prop.getProperty("browser");
			if(Browser.equals("chrome")) {
				System.setProperty("webdriver.chrome.driver", "C:\\selenium wedriver\\chromedriver.exe");
				driver=new ChromeDriver();
			}
			else {
				System.setProperty("webdriver.gecko.driver", "C:\\Users\\PC\\Downloads\\geckodriver.exe");
				driver=new FirefoxDriver();
				
			}
			driver.manage().window().maximize();
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(TestUtility.PageLoad_timeout));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TestUtility.Implicit_timeout));
			driver.manage().deleteAllCookies();
			driver.get(prop.getProperty("url"));
		}
				
	}
