package com.automation.training.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.automation.training.utils.Utils;

public class ShoppingSitePage extends BasePage  {

	
	public ShoppingSitePage(WebDriver driver) {
		super(driver);
		
	}
	
	public ShoppingSitePage(WebDriver driver, String url) {
		super(driver, Utils.getUserProperty(url)+Utils.getJsonDataProvider(NAME));
		
	}


	
	private static final String NAME = "name";
	private static final String PRICE = "regular_price";
	private static final String DESCRIPTION = "description";
	private static final String PRODUCT_QUANTITY = "product_quantity";
	
	
	@FindBy(name = "add-to-cart")
	private WebElement addToCard;
	
	@FindBy(css = "h1[class='product_title entry-title']")
	private WebElement productTitle;

	@FindBy(css = "div[class='summary entry-summary'] p span")
	private WebElement price;
	
	@FindBy(css = "#tab-description p")
	private WebElement description;
	
	@FindBy(css = ".quantity input")
	private WebElement productQuantity;
	
	@FindBy(css = "a[class='cart-contents']")
	private WebElement cartContents;
	
	@FindBy(css = ".cart-contents span[class='count']")
	private WebElement cartCount;
	

	
	public boolean productInformation() {
		waitForElementVisible(addToCard, 10);
		waitForElementVisible(productTitle, 10);
		String name = Utils.getJsonDataProvider(NAME);
    	String priceValue = Utils.getJsonDataProvider(PRICE);
    	String descriptionValue = Utils.getJsonDataProvider(DESCRIPTION);
		boolean productInformation = getText(productTitle).equals(name)&&  getText(price).equals("$"+ priceValue)&& getText(description).equals(descriptionValue);
		return productInformation;
	}
	
	public boolean verifyCartBefore() {
		return getText(cartCount).equals("0 items");
	}
	
	public boolean verifyCartAfter() {
		waitForElementVisible(cartCount, 40);
		String productQuantityValue = Utils.getJsonDataProvider(PRODUCT_QUANTITY);
		return getText(cartCount).equals(productQuantityValue+" items");
	}
	
	public boolean verifyQuantityAfter() {
		String productQuantityValue = Utils.getJsonDataProvider(PRODUCT_QUANTITY);
		return getAttribute(productQuantity, "value").equals(productQuantityValue);
	}
	
	public ShoppingSitePage addProducts() {
		String productQuantityValue = Utils.getJsonDataProvider(PRODUCT_QUANTITY);
		cleanField(productQuantity);
		sendKeysValue(productQuantity, productQuantityValue);
		click(addToCard);
		return this;
	}
	public ShoppingSiteCart goToCart() {
		click(cartContents);
		return new ShoppingSiteCart(driver);
	}
	
	
}
