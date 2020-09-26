package com.automation.training.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.automation.training.utils.WaitEnum;

public class SignUpPage extends BasePage {

	public SignUpPage(WebDriver driver) {
		super(driver);
	}
	public String idFrame= "disneyid-iframe";
	public By idFrameBy = By.name("lastName");
	
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
	
	public SignUpPage putTheInformation(String name, String lastName, String email, String password){
		waitForElementClickable(firstName, WaitEnum.LONG);
		sendKeysValue(firstName, name);
		sendKeysValue(lastNameElement, lastName);
		sendKeysValue(emailElement, email);
		sendKeysValue(newPassword, password);
		return this;
	}

	public ESPNHomePage confirmInformation() {
		waitForElementClickable(confirmInformation, WaitEnum.LONG);
		click(confirmInformation);
		waitForElementInvisible(idFrameBy, WaitEnum.LONG);
		switchToParentFrame();

		int ventanas = driver.getWindowHandles().size();
		//driver.getWindowHandles();
	
		return new ESPNHomePage(getDriver());
		
	}
	

}
