package com.automation.training.tests;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.automation.training.MyDriver;
import com.automation.training.pages.BasePage;
import com.automation.training.pages.ESPNHomePage;


public class BaseTests  {
	
	MyDriver myDriver;
	
	private ESPNHomePage espnHome;
	
	
	@BeforeSuite(alwaysRun=true)
	@Parameters({"browser"})
	public void beforeSuite(String browser) {
		myDriver = new MyDriver(browser);
	
	
	}
	
	@BeforeClass(alwaysRun=true)
	@Parameters({"url"})
	public void beforeClass(String url) {
	    espnHome = new ESPNHomePage(myDriver.getDriver());
	    BasePage.getURL(url);
	 
		
	}
	
	@AfterSuite(alwaysRun=true)
	public void afterSuite() {
		espnHome.dispose();
	}

	public ESPNHomePage getESPNHomePage() {
		return espnHome;
	}
}
