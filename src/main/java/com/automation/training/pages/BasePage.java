package com.automation.training.pages;


import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public abstract class BasePage {

	protected static WebDriver driver;
	

	public BasePage(WebDriver pDriver) {
		PageFactory.initElements(pDriver, this);
		driver = pDriver;
	}

	protected WebDriver getDriver() {
		return driver;
	}

	public void dispose() {
		System.out.println("entre al dipose");
		if (driver != null) {
			driver.quit();
		}
	}
	public static  void getURL(String url) {
		driver.get(url);
	}
	
	public void click(WebElement element) {
	      element.click();
	}
	public void hardClick(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", element);
	}
	public void waitForElementClickable(WebElement element, int time) {
		WebDriverWait wait = new WebDriverWait(driver, time);
        wait.until(ExpectedConditions. elementToBeClickable(element));
	}
	public void waitForElementPresent(By element, int time) {
		WebDriverWait wait = new WebDriverWait(driver,time);
        wait.until(ExpectedConditions.presenceOfElementLocated(element));
	}
	public void waitForElementVisible(WebElement element, int time) {
		WebDriverWait wait = new WebDriverWait(driver,time);
        wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public void waitForElementInvisible(By element, int time) {
		WebDriverWait wait = new WebDriverWait(driver,time);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(element));
	}
	public void switchToFrame(WebElement idFrame) {
		driver.switchTo().frame(idFrame);
	}
	public void sendKeysValue(WebElement element, String value) {
		element.sendKeys(value);
	}
	public void switchToParentFrame() {
		driver.switchTo().defaultContent();
	}
	public String getText(WebElement element) {
		String text= element.getText();
		return text;
	}
	 public static void highlightElement(WebElement element) {
		 JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('style', arguments[1]);", element, "color: red; border: 2px solid yellow;");

	 }
	 public static void scrollDown() { 
		 JavascriptExecutor js = (JavascriptExecutor) driver;
		 js.executeScript("window.scrollBy(0,2000)"); 
	 }
	public void waitImplicite(int time) throws InterruptedException {
		
		TimeUnit.MILLISECONDS.sleep(4000);
	
		}
}
