package com.automation.training.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class SignUpPage extends BasePage {

	public SignUpPage(WebDriver driver) {
		super(driver);
	}
	public String idFrame= "disneyid-iframe";
	public By idFrameBy = By.name("lastName");
	public By messageCredentialsBy = By.cssSelector("div[notify='create.error.email'] div div");
	
	@FindBy(name = "firstName")
	private WebElement firstName;
	
	@FindBy(name = "lastName")
	private WebElement lastNameElement;
	
	@FindBy(name = "email")
	private WebElement emailElement;
	
	@FindBy(name = "newPassword")
	private WebElement newPassword;
	
	@FindBy(css = "a[class='btn btn-secondary ng-isolate-scope']")
	private WebElement signUpButton;
	
	@FindBy(css = " button[class='btn btn-primary ng-scope ng-isolate-scope']")
	private WebElement confirmInformation;
	
	@FindBy(id = "disneyid-iframe")
	private WebElement iframeLogin;
	
	@FindBy(css = "div[notify='create.error.email'] div div")
	private WebElement messageCredentials;
	
	@FindBy(css = "div[notify='create.error.newPassword'] div div")
	private WebElement messageCredentialsPassword;
	
	
	public SignUpPage putTheInformation(String name, String lastName, String email, String password){
		waitForElementClickable(firstName, 400);
		sendKeysValue(firstName, name);
		sendKeysValue(lastNameElement, lastName);
		sendKeysValue(emailElement, email);
		sendKeysValue(newPassword, password);
		return this;
	}
	
	public SignUpPage putTheInformation(String name, String lastName, String email){
		waitForElementClickable(firstName, 400);
		sendKeysValue(firstName, name);
		sendKeysValue(lastNameElement, lastName);
		sendKeysValue(emailElement, email);
		click(newPassword);
		waitForElementPresent(messageCredentialsBy, 900);
		return this;
	}

	public ESPNHomePage confirmInformation() {
		waitForElementClickable(confirmInformation, 400);
		click(confirmInformation);
		waitForElementInvisible(idFrameBy, 200);
		switchToParentFrame();
		return new ESPNHomePage(getDriver());
		
	}

	public String checkErrorMessageEmail() {
		waitForElementClickable(messageCredentials, 900);
		String error= getText(messageCredentials);
		return error;
		
	}
	public String checkErrorMessagePassword() {
		waitForElementClickable(confirmInformation, 800);
		click(confirmInformation);
		waitForElementClickable(messageCredentialsPassword, 900);
		String error= getText(messageCredentialsPassword);
		return error;
		
	}
	

}
