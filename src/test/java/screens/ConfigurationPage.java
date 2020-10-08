package screens;

import static io.appium.java_client.pagefactory.LocatorGroupStrategy.ALL_POSSIBLE;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.pmw.tinylog.Logger;
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
public class ConfigurationPage extends BaseScreen {


	/**
	 * Constructor method.
	 * 
	 * 
	 * @param driver : AndroidDriver
	 */
	public ConfigurationPage(AndroidDriver<AndroidElement> pDriver) {
		super(pDriver);
	}
	

	Map<String, Object>initialParams = new HashMap<String, Object>();
	Map<String, Object>finalParams = new HashMap<String, Object>();
	// AndroidElements
	@HowToUseLocators(androidAutomation = ALL_POSSIBLE)
	
	
	@AndroidFindBy(id = "com.trivago:id/fragmentSettingsManageMyDataTextView")
	private AndroidElement dataPrivacityConfiguration;
	
	@AndroidFindBy(id = "com.trivago:id/viewProfileNotLoggedInButtonTextView")
	private List<AndroidElement> createAccount;
	
	@AndroidFindBy(id = "com.trivago:id/viewProfileNotLoggedInButtonTextView")
	private AndroidElement createAccountElement;
	
	@AndroidFindBy(id = "com.trivago:id/activityDataManagerAppsFlyerCheckbox")
	private AndroidElement appsFlyer;
	
	@AndroidFindBy(id = "com.trivago:id/activityDataManagerFirebaseCheckbox")
	private AndroidElement firebase;
	
	@AndroidFindBy(id = "com.trivago:id/activityDataManagerFacebookCheckbox")
	private AndroidElement facebook;
	
	@AndroidFindBy(id = "com.trivago:id/activityDataManagerSaveButton")
	private AndroidElement save;
	
	@AndroidFindBy(accessibility = "Navegar hacia arriba")
	private AndroidElement back;
	
	/**
	 * Verify the page
	 * 
	 * 
	 * @param 
	 */
	
	public boolean checkTheConfigurationPage() {
		return isPresent(createAccount);
	}
	
	/**
	 * Return the data configuration page
	 * 
	 * 
	 * @param 
	 */
	
	public ConfigurationPage goToDataPrivacityConfiguration() {
		scrollToText("Configurar privacidad de datos");
		clickOn(dataPrivacityConfiguration);
		CustomWait.waitAndroidElementVisibility(driver, save, 30);
		return this;
		
	}

	/**
	 * Change the data configurations
	 * 
	 * 
	 * @param 
	 */
	public ConfigurationPage changeDataPrivacityConfiguration() {
		initialParams = putInitialConfiguration();
		clickOn(appsFlyer);
		clickOn(save);
		clickOn(back);
		CustomWait.waitAndroidElementVisibility(driver, createAccountElement, 30);
		return this;
	}

	/**
	 * save the initial configurations
	 * 
	 * 
	 * @param 
	 */
	public Map<String, Object> putInitialConfiguration() {
		Map<String, Object>initialParams = new HashMap<String,  Object>();
		initialParams.put("AppsFlyer",getAttribute(appsFlyer, "checked"));
		initialParams.put("firebase",getAttribute(firebase,"checked"));
		initialParams.put("facebook",getAttribute(facebook,"checked"));
	
		return initialParams;
	}
	
	/**
	 * save the final configurations
	 * 
	 * 
	 * @param 
	 */
	
	public Map<String, Object> putFinalConfiguration() {
		Map<String,Object>finalParams = new HashMap<String, Object>();
		finalParams.put("AppsFlyer",getAttribute(appsFlyer, "checked"));
		Logger.info("Alert Message: " +getAttribute(appsFlyer, "checked"));
		finalParams.put("firebase",getAttribute(firebase, "checked"));
		finalParams.put("facebook",getAttribute(facebook, "checked"));
		return finalParams;
	}
	
	/**
	 * return initial configurations
	 * 
	 * 
	 * @param 
	 */
	
	public Map<String, Object> getInitialConfiguration(){
		return initialParams;
	}
	

	
}