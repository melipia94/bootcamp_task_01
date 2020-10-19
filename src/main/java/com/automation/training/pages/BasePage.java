package com.automation.training.pages;


import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;


public abstract class BasePage {

	protected static WebDriver driver;
	

	public BasePage(WebDriver pDriver) {
		PageFactory.initElements(pDriver, this);
		driver = pDriver;
	}

	public BasePage(WebDriver pDriver, String URL) {
		PageFactory.initElements(pDriver, this);
		driver = pDriver;
		getURL(URL);
	}
	protected WebDriver getDriver() {
		return driver;
	}

	public static void dispose() {
		if (driver != null) {
			driver.quit();
		}
	}
	public static  void getURL(String url) {
		driver.get(url);
	}
	
	public static String getCurrentURL() {
		return driver.getCurrentUrl();
	}
	
	public void click(WebElement element) {
	      element.click();
	}
	
	public void selectByVisibleText(WebElement element, String text) {
		Select select = new Select(element); 
		select.selectByVisibleText(text);
	}
	
	public void selectByValue(WebElement element, String value) {
		Select select = new Select(element); 
		select.selectByValue(value);
	}
	public WebElement element(By element) {
		return driver.findElement(element);
	}
	public void hardClick(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", element);
	}
	
	public String getAttribute(WebElement element, String attribute) {
		return element.getAttribute(attribute);
	}
	
	public void waitForElementClickable(WebElement element, int time) {
		WebDriverWait wait = new WebDriverWait(driver, time);
        wait.until(ExpectedConditions. elementToBeClickable(element));
	}
	public void waitForElementPresent(By element, int time) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				  .withTimeout(Duration.ofSeconds(time))
				  .pollingEvery(Duration.ofSeconds(5))
				  .ignoring(NoSuchElementException.class);
		//WebDriverWait wait = new WebDriverWait(driver,time);
        wait.until(ExpectedConditions.presenceOfElementLocated(element));
	}
	public void waitForElementVisible(WebElement element, int time) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				  .withTimeout(Duration.ofSeconds(time))
				  .pollingEvery(Duration.ofSeconds(5))
				  .ignoring(NoSuchElementException.class);
		//WebDriverWait wait = new WebDriverWait(driver,time);
        wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public void waitForElementInvisible(By element, int time) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				  .withTimeout(Duration.ofSeconds(time))
				  .pollingEvery(Duration.ofSeconds(5))
				  .ignoring(NoSuchElementException.class);
		//WebDriverWait wait = new WebDriverWait(driver,time);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(element));
	}
	public void switchToFrame(WebElement idFrame) {
		driver.switchTo().frame(idFrame);
	}
	public boolean isDispleyed(WebElement element) {
		return element.isDisplayed();
	}
	public void sendKeysValue(WebElement element, String value) {
		element.sendKeys(value);
	}
	
	public void cleanField(WebElement element) {
		element.clear();
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
	 
	 public static void scrollToElement(WebElement element) { 
		 JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", element);
	 }
	public void swichToWindow() {
		for (String winHandle : driver.getWindowHandles()) {
		       driver.switchTo().window(winHandle); 
			}
	
		}
}
