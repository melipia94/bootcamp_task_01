package com.automation.training.pages;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.automation.training.utils.WaitEnum;

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
	
	public static void click(WebElement element) {
		System.out.println("entre al clic");
	      element.click();
	}
	public static void hardClick(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", element);
	}
	public void waitForElementClickable(WebElement element,WaitEnum time) {
		WebDriverWait wait = new WebDriverWait(driver,120);
        wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	public void waitForElementPresent(By element, WaitEnum time) {
		WebDriverWait wait = new WebDriverWait(driver,120);
		System.out.println("esperando iframe");
        wait.until(ExpectedConditions.presenceOfElementLocated(element));
	}
	
	public void waitForElementInvisible(By element, WaitEnum time) {
		WebDriverWait wait = new WebDriverWait(driver,120);
		System.out.println("esperando iframe");
        wait.until(ExpectedConditions.invisibilityOfElementLocated(element));
	}
	public void switchToFrame(WebElement idFrame) {
		System.out.println("entre al swtch");
		driver.switchTo().frame(idFrame);
	}
	public void sendKeysValue(WebElement element, String value) {
		element.sendKeys(value);
	}
	public void switchToParentFrame() {
		System.out.println("entre al swtch");
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
}
