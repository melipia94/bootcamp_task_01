package com.automation.training.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.automation.training.utils.WaitEnum;

public class LoginPage extends BasePage {

	public LoginPage(WebDriver driver) {
		super(driver);
	}
	public By idFrameBy = By.id("disneyid-iframe");
	
	@FindBy(id = "disneyid-iframe")
	private WebElement iframeLogin;
	
	@FindBy(css = "a[class='btn btn-secondary ng-isolate-scope']")
	private WebElement signUpButton;
	
	
	public SignUpPage selectSignUp(){
		waitForElementPresent(idFrameBy, WaitEnum.LONG);
		switchToFrame(iframeLogin);
		waitForElementClickable(signUpButton,WaitEnum.LONG);
		click(signUpButton);
		return new SignUpPage(getDriver());
	}

}
