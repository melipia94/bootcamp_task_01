package com.automation.training.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.automation.training.utils.Utils;


public class BookingHomePage extends BasePage  {

	public BookingHomePage(WebDriver driver) {
		super(driver);
		
	}
	
	public BookingHomePage(WebDriver driver, String URL) {
		super(driver, Utils.getUserProperty(URL));
		
	}
	public By sleepBy = By.cssSelector("span[data-ga-track='click|Product Expansion|accommodation|booking (index)']");
	
	@FindBy(id = "ss")
	private WebElement whereAreYouGoing;

	@FindBy(css = "span[data-ga-track='click|Product Expansion|accommodation|booking (index)']")
	private WebElement sleep;
	

	public SleepPage goToSleep() {
		waitForElementPresent(sleepBy,10);
		waitForElementVisible(sleep, 10);
		click(sleep);
		return new SleepPage(driver);
	}
	

}
