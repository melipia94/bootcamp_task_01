package com.automation.training.tests;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.pmw.tinylog.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.automation.training.Driver;
import com.automation.training.pages.BasePage;
import com.automation.training.pages.BookingHomePage;
import com.automation.training.utils.Utils;



public class BaseTests  {
	
	Driver driver;
	
	private BookingHomePage bookingHome;
	
	
	@BeforeMethod(alwaysRun=true)
	
	public void beforeSuite(){
		driver = new Driver(Utils.getUserProperty("browser"));
	}

	
	@AfterMethod(alwaysRun=true)
	public void afterSuite() {
		BasePage.dispose();
	}

	public WebDriver getDriver() {
		return driver.getDriver();
	}
}
