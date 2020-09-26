package com.automation.training.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.automation.training.tests.BaseTests;
import com.automation.training.utils.WaitEnum;

public class ESPNHomePage extends BasePage  {

	public ESPNHomePage(WebDriver driver) {
		super(driver);
		driver.getCurrentUrl();
		System.out.println(driver.getCurrentUrl());
		
	}

	@FindBy(id = "global-user-trigger")
	private WebElement initialButton;

	@FindBy(css = "#global-user-trigger + div.global-user .account-management li a[data-affiliatename]")
	private WebElement login;
	

	@FindBy(css = "#global-user-trigger + div.global-user .account-management li.display-user span")
	private WebElement userName;

	public LoginPage goToLoginPage() {
		waitForElementClickable(initialButton, WaitEnum.SHORT);
		click(initialButton);
		waitForElementClickable(login, WaitEnum.SHORT);
		click(login);
		return new LoginPage(getDriver());
	}
	public String checkUserName() {
		waitForElementClickable(initialButton, WaitEnum.SHORT);
		hardClick(initialButton);
		click(initialButton);
		waitForElementClickable(userName, WaitEnum.SHORT);
		highlightElement(userName);
		String user= getText(userName).split("!")[0];
		return user;
		
	}
}
