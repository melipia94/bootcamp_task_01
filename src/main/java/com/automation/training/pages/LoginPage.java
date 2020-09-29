package com.automation.training.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class LoginPage extends BasePage {

	public LoginPage(WebDriver driver) {
		super(driver);
	}
	public By idFrameBy = By.id("disneyid-iframe");
	public By errorBy = By.cssSelector("h2[class='title title-primary ng-isolate-scope']");
	public By userNameBy = By.cssSelector("input[placeholder='Username or Email Address']");
	public By messageCredentialsBy = By.cssSelector("div[ng-repeat='item in parsedItems']");

	
	@FindBy(id = "disneyid-iframe")
	private WebElement iframeLogin;
	
	@FindBy(css = "a[class='btn btn-secondary ng-isolate-scope']")
	private WebElement signUpButton;
	
	@FindBy(css = "input[placeholder='Username or Email Address']")
	private WebElement userInput;
	
	@FindBy(css = "input[placeholder='Password (case sensitive)']")
	private WebElement passwordInput;
	
	@FindBy(css = "button[class='btn btn-primary btn-submit ng-isolate-scope']")
	private WebElement logInButton;
	
	@FindBy(css = "h2[class='title title-primary ng-isolate-scope']")
	private WebElement errorMeesage;
	
	@FindBy(css = "div[ng-repeat='item in parsedItems']")
	private WebElement messageCredentials;
	
	
	public SignUpPage selectSignUp(){
		waitForElementPresent(idFrameBy, 800);
		switchToFrame(iframeLogin);
		waitForElementClickable(signUpButton, 800);
		click(signUpButton);
		return new SignUpPage(getDriver());
	}
	
	public ESPNHomePage logIn(String userNameValue, String passwordValue){
		waitForElementPresent(idFrameBy, 800);
		switchToFrame(iframeLogin);
		waitForElementClickable(signUpButton, 400);
		waitForElementClickable(userInput, 400);
		sendKeysValue(userInput, userNameValue);
		sendKeysValue(passwordInput,passwordValue );
		waitForElementClickable(logInButton, 800);
		click(logInButton);
		waitForElementInvisible(userNameBy, 900);
		switchToParentFrame();
		return new ESPNHomePage(getDriver());
	}
	
	
	public LoginPage logInFail(String userNameValue, String passwordValue){
		waitForElementPresent(idFrameBy, 400);
		switchToFrame(iframeLogin);
		waitForElementClickable(signUpButton, 400);
		sendKeysValue(userInput, userNameValue);
		sendKeysValue(passwordInput,passwordValue );
		waitForElementClickable(logInButton, 800);
		click(logInButton);
		return this;
	}

	
	public String checkLogInFail(){
		waitForElementPresent(errorBy, 800);
		String error= getText(errorMeesage);
		return error;
	}
	
	public String checkMessage(){
		waitForElementPresent(messageCredentialsBy, 800);
		String error= getText(messageCredentials);
		return error;
	}

}
