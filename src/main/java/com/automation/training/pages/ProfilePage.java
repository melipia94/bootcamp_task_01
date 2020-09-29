package com.automation.training.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class ProfilePage extends BasePage {

	public ProfilePage(WebDriver driver) {
		super(driver);
	}
	public By idFrameBy =  By.id("disneyid-iframe");
	public By loadBy =  By.className("loading-indicator");
	public By bodyIframaBy =  By.cssSelector("div[class='content ng-scope']");;
	public By emailBy = By.name("email");
	public By deleteAccountBy = By.cssSelector("#cancel-account");
	public By confirmDeleteBy = By.cssSelector("button[class='btn btn-primary ng-isolate-scope']");
	
	@FindBy(css = "#cancel-account")
	private WebElement cancelAccount;
	
	@FindBy(name = "email")
	private WebElement emailElement;
	
	@FindBy(css = "button[class='btn btn-primary ng-scope ng-isolate-scope']")
	private WebElement confirmInformation;
	
	@FindBy(css = "button[class='btn btn-primary ng-isolate-scope']")
	private WebElement confirmDelete;
	
	@FindBy(id = "disneyid-iframe")
	private WebElement iframeLogin;
	
	
	public ESPNHomePage deleteAccount(){
		waitForElementPresent(idFrameBy, 900);
		waitForElementInvisible(loadBy, 5000);
		switchToFrame(iframeLogin);
		waitForElementInvisible(loadBy, 900);
		waitForElementClickable(emailElement, 900);
		waitForElementPresent(deleteAccountBy , 900);
		scrollDown();
		waitForElementClickable(cancelAccount, 900);	
		click(cancelAccount);
		waitForElementInvisible(deleteAccountBy, 900);
		waitForElementClickable(confirmDelete, 900);
		click(confirmDelete);
		waitForElementInvisible(confirmDeleteBy, 800);
		waitForElementInvisible(bodyIframaBy , 800);
		switchToParentFrame();
		return new ESPNHomePage(getDriver());
	}


	

}
