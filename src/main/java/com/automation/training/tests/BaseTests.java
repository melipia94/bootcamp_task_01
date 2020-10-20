package com.automation.training.tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.automation.training.Driver;
import com.automation.training.pages.BasePage;
import com.automation.training.pages.ESPNHomePage;


public class BaseTests  {
	
	Driver driver;
	
	private String url;
	
	
	@BeforeMethod(alwaysRun=true)
	@Parameters({"browser"})
	public void beforeSuite(String browser) {
		driver = new Driver(browser);
	
	
	}
	
	@Parameters({"url"})
	@BeforeMethod(alwaysRun=true)
	public void SetUrl(String url) {
		this.url = url;
	}
	
	public String getURL() {
		return url;
	}
	
	@AfterMethod(alwaysRun=true)
	public void afterMethod() {
		BasePage.dispose();
	}

	public WebDriver getDriver() {
		return driver.getDriver();
	}
}
