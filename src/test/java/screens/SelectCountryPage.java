package screens;

import static io.appium.java_client.pagefactory.LocatorGroupStrategy.ALL_POSSIBLE;

import org.pmw.tinylog.Logger;
import static java.lang.String.format;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.HowToUseLocators;
import util.CustomWait;
import util.screens.BaseScreen;

/**
 * Description:
 *
 */
public class SelectCountryPage extends BaseScreen {

	/**
	 * Constructor method.
	 * 
	 * 
	 * @param driver : AndroidDriver
	 */
	public SelectCountryPage(AndroidDriver<AndroidElement> pDriver) {
		super(pDriver);
	}

	// Locators
	private static final String FIRST_LOCATOR = "com.trivago:id";

	// AndroidElements
	@HowToUseLocators(androidAutomation = ALL_POSSIBLE)
	@AndroidFindBy(id = FIRST_LOCATOR + "/activityPlatformSelectionWelcomeTextView")
	private AndroidElement welcome;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"Colombia\")")
	private AndroidElement selectColombia;

	@AndroidFindBy(id = FIRST_LOCATOR + "/activityPlatformSelectionConfirmButton")
	private AndroidElement confirm;

	/**
	 * Returns a SecondScreen after to do something.
	 * 
	 * 
	 * @return SecondScreen
	 */
	public DataPrivacityPage returnSecondScreen() {
		// code
		return new DataPrivacityPage(driver);
	}

	/**
	 * Click on button.
	 * 
	 */
	public SelectCountryPage selectCountryPage(String country) {
		String lenguageElement = format("new UiSelector().textContains(\"%s\")", country);
		CustomWait.waitAndroidElementVisibility(driver,welcome, 300);
		Logger.info("Alert Message: " + welcome.getText());
		clickOn(welcome);
		scrollToText(country);
		scrollAtions();
		CustomWait.waitInSeconds(5);
		clickOn(findElementByUISelector(lenguageElement));
		return this;
	}
	
	
	public DataPrivacityPage confirmCountry() {

		CustomWait.waitAndroidElementVisibility(driver,confirm, 60);
		clickOn(confirm);
		return new DataPrivacityPage(driver);
	}
	
}