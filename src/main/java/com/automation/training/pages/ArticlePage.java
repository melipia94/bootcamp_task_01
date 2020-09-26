package com.automation.training.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ArticlePage extends BasePage{
	
	public ArticlePage(WebDriver driver) {
		super(driver);
	}

	@FindBy(id="firstHeading")
	private WebElement pageTitle;
	

	@FindBy(id="searchInput")
	private WebElement search;
	
	@FindBy(id="searchButton")
	private WebElement searchButton;
	
	@FindBy(linkText="Privacy policy")
	private WebElement privacyLink;
	
	public String getPageTitle() throws InterruptedException {
		highLightElement(pageTitle);
		Thread.sleep(1000);
		return pageTitle.getText();
	}
	public ArticlePage searchInArticle(String searchInput) {
		search.sendKeys(searchInput);
		searchButton.click();
		return new ArticlePage(getDriver());
	}
	public void highLightElement(WebElement element) {
		((JavascriptExecutor)driver).executeScript("arguments[0].style.border='3px solid red'", element);
		
	}
}
