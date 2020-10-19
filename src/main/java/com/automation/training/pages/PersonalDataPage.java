package com.automation.training.pages;


import java.util.Map;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.automation.training.utils.Utils;

public class PersonalDataPage extends BasePage  {

	public PersonalDataPage(WebDriver driver) {
		super(driver);
		
	}

	private static final String FIRST_NAME = "firstName";
	private static final String LAST_NAME = "lastName";
	private static final String EMAIL = "email";
	private static final String PHONE= "phone";
	private static final String CC_TYPE = "CCType";
	private static final String CC_NUMBER = "CCNumber";
	private static final String CC_MONTH = "CCMonth";
	private static final String CC_YEAR = "CCYear";
	private static final String CC_CVC = "CCCVC";
	private static final String PLACE = "place";
	@FindBy(id = "bp_travel_purpose_leasure")
	private WebElement selectTravel;

	@FindBy(id = "lastname")
	private WebElement lastName;
	
	@FindBy(id = "firstname")
	private WebElement firstName;
	
	@FindBy(id = "email")
	private WebElement email;
	
	@FindBy(id = "email_confirm")
	private WebElement emailConfirm;
	
	@FindBy(id = "notstayer_false")
	private WebElement iAmTheMainGuest;
	
	@FindBy(id = "modal-default-title")
	private WebElement modal;
	
	@FindBy(id = "phone")
	private WebElement phone;
	
	@FindBy(id = "cc_name")
	private WebElement namePymenth;
	
	@FindBy(id = "cc_type")
	private WebElement CCType;
	
	@FindBy(id = "cc_number")
	private WebElement CCNumber;
	
	@FindBy(id = "cc_month")
	private WebElement CCMonth;
	
	@FindBy(id = "ccYear")
	private WebElement CCYear;
	
	@FindBy(id = "cc_cvc")
	private WebElement CCCVC;
	
	
	
	@FindBy(css = "div[class='bui-inline-container bui-inline-container--align'] button")
	private WebElement closeModal;
	
	@FindBy(className = "bui-checkbox__label")
	private WebElement dontShowAgain;
	
	@FindBy(css = "button[name='book']")
	private WebElement followLastData;
	
	@FindBy(css = "div[class='bui-group bui-spacer--large'] div[class='bui-group__item'] button[name='book']")
	private WebElement confirmReservation;
	
	@FindBy(css = "h1[class='bui-f-font-display_two bui-spacer--small']")
	private WebElement hotelName;
	
	@FindBy(css = "div[class='book-form-field field_name_full_name'] div[class='book-form-field-value']")
	private WebElement nameAndLastName; 
	
	@FindBy(css = "ins[class='personal_details_reassurance_email_text']")
	private WebElement emailConfirmation2; 
	
	@FindBy(css = "div[class='bui-inline-container__main'] span[class='hotel-address-text-address']")
	private WebElement hotelInformationCity;
	
	public PersonalDataPage putPersonalInformation() {
		waitForElementVisible(selectTravel, 10);
		hardClick(selectTravel);
		String firstNameValue = Utils.getJsonDataProvider(FIRST_NAME);
		String lastNameValue = Utils.getJsonDataProvider(LAST_NAME);
		String emailValue = Utils.getJsonDataProvider(EMAIL);
		sendKeysValue(firstName, firstNameValue);
		sendKeysValue(lastName, lastNameValue);
		sendKeysValue(email, emailValue);
		sendKeysValue(emailConfirm, emailValue);
		hardClick(iAmTheMainGuest);
		scrollToElement(followLastData);
		click(followLastData);
		return this;
	}
	
	public void closeModal() {
		waitForElementPresent(By.id("modal-default-title"),70);
		waitForElementVisible(modal,10);
		hardClick(dontShowAgain);
		click(closeModal);
	}
	
	public boolean checkTheHotelName(){
		closeModal();
		waitForElementVisible(hotelName, 10);
		Map<String, String > hotelInformation = SleepPage.getterhotelInformation();
		return hotelInformation.get("hotelName").equals(getText(hotelName));
	}
	public boolean checkNameAndLastName(){
		String firstNameValue = Utils.getJsonDataProvider(FIRST_NAME);
		String lastNameValue = Utils.getJsonDataProvider(LAST_NAME);
		return getText(nameAndLastName).contains(firstNameValue) && getText(nameAndLastName).contains(lastNameValue);
	}
	
	public boolean checkEmail(){
		String emailValue = Utils.getJsonDataProvider(EMAIL);
		return getText(emailConfirmation2).equals(emailValue);
	}
	
	public boolean checkTheHotelCity(){
		String placeValue = Utils.getJsonDataProvider(PLACE);
		return getText(hotelInformationCity).contains(placeValue);
	}
	
	public boolean checkPersonPymenth(){
		String firstNameValue = Utils.getJsonDataProvider(FIRST_NAME);
		String lastNameValue = Utils.getJsonDataProvider(LAST_NAME);
		return getAttribute(namePymenth, "value").equals(firstNameValue+" "+lastNameValue);
	}
	public PersonalDataPage completeTheInformation(){
		String phoneNumber = Utils.getJsonDataProvider(PHONE);
		String CCTypeValue =Utils.getJsonDataProvider(CC_TYPE);
		String CCNumberValue =Utils.getJsonDataProvider(CC_NUMBER);
		String CCMonthValue =Utils.getJsonDataProvider(CC_MONTH);
		String CCYearValue =Utils.getJsonDataProvider(CC_YEAR);
		String CCCVCValue =Utils.getJsonDataProvider(CC_CVC);
		sendKeysValue(phone, phoneNumber);
		selectByVisibleText(CCType, CCTypeValue);
		sendKeysValue(CCNumber, CCNumberValue);
		selectByVisibleText(CCMonth, CCMonthValue);
		selectByVisibleText(CCYear, CCYearValue);
		sendKeysValue(CCCVC, CCCVCValue);
		return this;
	}
}
