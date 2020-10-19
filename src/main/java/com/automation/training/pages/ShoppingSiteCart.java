package com.automation.training.pages;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.automation.training.utils.Utils;

public class ShoppingSiteCart extends BasePage  {

	
	public ShoppingSiteCart(WebDriver driver) {
		super(driver);
		
	}

	private static final String NAME = "name";
	private static final String PRICE = "regular_price";
	private static final String PRODUCT_QUANTITY = "product_quantity";
	
	@FindBy(css = "td[class='product-name']")
	private WebElement productName;
	
	@FindBy(className = "entry-title")
	private WebElement cartTitle;
	
	@FindBy(css = "input[class='input-text qty text']")
	private WebElement productQuantity;
	
	@FindBy(css = "td[class='product-price'] span[class='woocommerce-Price-amount amount']")
	private WebElement price;

	public String verifyURL() {
		waitForElementVisible(cartTitle, 10);
		return getCurrentURL();
	}
	
	public boolean verifyProduct() {
		String name = Utils.getJsonDataProvider(NAME);
		waitForElementVisible(productName, 10);
		return getText(productName).contentEquals(name);
	}
	
	public boolean verifyPriceAndCount() {
		String priceValue = Utils.getJsonDataProvider(PRICE);
		waitForElementVisible(productName, 10);
		String productQuantityValue = Utils.getJsonDataProvider(PRODUCT_QUANTITY);
		return  getText(price).equals("$"+ priceValue)&&getAttribute(productQuantity, "value").equals(productQuantityValue);
	}
	
	
}
