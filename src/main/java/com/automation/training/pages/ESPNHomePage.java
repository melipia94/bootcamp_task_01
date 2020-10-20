package com.automation.training.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ESPNHomePage extends BasePage  {

	public ESPNHomePage(WebDriver driver, String url) {
		super(driver, url);
	
		
	}
	
	public ESPNHomePage(WebDriver driver) {
		super(driver);
	
	}
	
	public By logOutBy = By.cssSelector("#global-user-trigger + div.global-user .account-management li a[onclick]");
	public By profileBy = By.cssSelector("#global-user-trigger + div.global-user .account-management li a[tref]");
	@FindBy(id = "global-user-trigger")
	private WebElement initialButton;

	@FindBy(css = "#global-user-trigger + div.global-user .account-management li a[data-affiliatename]")
	private WebElement login;
	

	@FindBy(css = "#global-user-trigger + div.global-user .account-management li.display-user span")
	private WebElement userName;
	
	@FindBy(css = "#global-user-trigger + div.global-user .account-management li a[onclick]")
	private WebElement logOut;
	
	@FindBy(css = "#global-user-trigger + div.global-user .account-management li a[tref]")
	private WebElement profile;

	public LoginPage goToLoginPage() {
		waitForElementClickable(initialButton, 400);
		click(initialButton);
		waitForElementClickable(login, 400);
		click(login);
		return new LoginPage(getDriver());
	}

	public ESPNHomePage logOut() {
		waitForElementClickable(initialButton, 400);
		click(initialButton);
		waitForElementClickable(logOut, 400);
		click(logOut);
		waitForElementInvisible(logOutBy, 400);
		return this;
	}
	
	public ProfilePage goToProfile() {
		waitForElementClickable(initialButton, 400);
		click(initialButton);
		waitForElementClickable(profile, 400);
		click(profile);
		waitForElementInvisible(profileBy, 400);
		return new ProfilePage(getDriver());
	}
	
	public String checkUserName() {
		waitForElementClickable(initialButton, 600);
		click(initialButton);
		waitForElementClickable(initialButton, 400);
		String user= "";
		try {
			highlightElement(userName);
			user= getText(userName).split("!")[0];
		}
		catch(Exception e){}
		return user;
	}
	

}
