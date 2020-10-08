package screens;

import org.pmw.tinylog.Logger;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import util.CustomWait;
import util.screens.BaseScreen;

/**
 * Object of SecondScreen.
 * 
 **/
public class DataPrivacityPage extends BaseScreen {

	/**
	 * Constructor method.
	 *
	 *
	 * @param androidDriver
	 *            : AndroidDriver
	 */
	public DataPrivacityPage(AndroidDriver<AndroidElement> pDriver) {
		super(pDriver);
	}

	// AndroidElements
	@AndroidFindBy(id = "com.trivago:id/activityCookieConsentContentTitleTextView")
	protected AndroidElement title;
	
	@AndroidFindBy(id = "com.trivago:id/activityCookieConsentContentBody1TextView")
	private AndroidElement body1;
	
	@AndroidFindBy(id = "com.trivago:id/activityCookieConsentContentBody2TextView")
	private AndroidElement body2;
	
	@AndroidFindBy(id = "com.trivago:id/activityCookieConsentContentBody3TextView")
    private AndroidElement body3;
	
	@AndroidFindBy(id = "com.trivago:id/activityCookieConsentContentAcceptButton")
	private AndroidElement accept;
	
	@AndroidFindBy(id = "com.trivago:id/fragmentHomeExpandedDealformSearchTextView")
	private AndroidElement searchHotelsButton;
	
	
	
	/**
	 * accept the data privacity conditions
	 * 
	 * 
	 * @param 
	 */
	public HomePage acceptConditions() {
		CustomWait.waitAndroidElementVisibility(driver, accept, 60);
		clickOn(accept);
		return new HomePage(driver);
	}
	
	/**
	 * check the title of the page
	 * 
	 * 
	 * @param 
	 */
	
	public String checkTile() {
		CustomWait.waitAndroidElementVisibility(driver, title, 60);
		String titleString = getText(title);
		return titleString;
	}
	/**
	 * check the texts of the page
	 * 
	 * 
	 * @param 
	 */
	public String[] checkText() {
		String[] titleString = {"", "", ""};
		titleString[0] = getText(body1);
		Logger.info("Alert Message: " + titleString[0]);
		titleString[1] = getText(body2);
		Logger.info("Alert Message: " + titleString[1]);
		titleString[2] = getText(body3);
		Logger.info("Alert Message: " + titleString[2]);
		return titleString;
	}

}
