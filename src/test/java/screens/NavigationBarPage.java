package screens;

import static io.appium.java_client.pagefactory.LocatorGroupStrategy.ALL_POSSIBLE;

import java.util.List;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.HowToUseLocators;
import util.screens.BaseScreen;

/**
 * Description:
 *
 */
public class NavigationBarPage extends BaseScreen {

	/**
	 * Constructor method.
	 * 
	 * 
	 * @param driver : AndroidDriver
	 */
	public NavigationBarPage(AndroidDriver<AndroidElement> pDriver) {
		super(pDriver);
	}



	// AndroidElements
	@HowToUseLocators(androidAutomation = ALL_POSSIBLE)
	@AndroidFindBy(id = "com.trivago:id/action_home")
	private List <AndroidElement> home;
	;
	
	@AndroidFindBy(id = "com.trivago:id/action_settings")
	private List <AndroidElement> configuration;
	
	@AndroidFindBy(id = "com.trivago:id/action_settings")
	private AndroidElement configurationElement;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"Sorpréndete\")")
	private List <AndroidElement> sorprised;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"Favoritos\")")
	private List <AndroidElement> favourites;
	
	@AndroidFindBy(id = "com.trivago:id/fragmentHomeExpandedDealformSearchTextView")
	private AndroidElement searchHotelsButton;
	
	

	
	/**
	 * Returns a SecondScreen after to do something.
	 * 
	 * 
	 * @return SecondScreen
	 */


	/**
	 * Click on button.
	 * 
	 */

	/**
	 * verify navigation bar app
	 * 
	 * 
	 * @param 
	 */
	
	public boolean checkNavigationBar() {
		return isPresent(home)&&isPresent(configuration)&&isPresent(sorprised)&&isPresent(favourites);
	}
	/**
	 * Return the configuration page
	 * 
	 * 
	 * @param 
	 */
	
	public ConfigurationPage goToConfiguration() {
		clickOn((AndroidElement) configurationElement);
		return new ConfigurationPage(driver);
	}



	
}