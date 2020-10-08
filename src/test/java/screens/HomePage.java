package screens;

import static io.appium.java_client.pagefactory.LocatorGroupStrategy.ALL_POSSIBLE;
import static java.lang.String.format;

import java.util.Calendar;
import java.util.List;

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
public class HomePage extends BaseScreen {

	/**
	 * Constructor method.
	 * 
	 * 
	 * @param driver : AndroidDriver
	 */
	public HomePage(AndroidDriver<AndroidElement> pDriver) {
		super(pDriver);
	}

	// Locators

	 String[] monthNames= {"enero", "febrero", "marzo", "abril", "mayo", "junio", "julio", "agosto", "septiembre", "octubre", "noviembre", "diciembre"};
	 String day1 = "";
	 String day2 = "";
	 String month1 = "";
	 String month2 = "";
	 String destinationPlace = "";
	 // AndroidElements
	@HowToUseLocators(androidAutomation = ALL_POSSIBLE)
	@AndroidFindBy(id = "com.trivago:id/fragmentHomeExpandedDealformSearchTextView")
	private AndroidElement searchHotelsButton;
	
	@AndroidFindBy(id = "com.trivago:id/activityCookieConsentContentAcceptButton")
	private List<AndroidElement> accept;
	
	@AndroidFindBy(id = "com.trivago:id/fragmentHomeExpandedDealformDestinationTextView")
	private AndroidElement destination;
	
	@AndroidFindBy(id = "com.trivago:id/fragmentHotelSearchResultsExpandedDealformDestinationTextView")
	private AndroidElement finalDestination;

	@AndroidFindBy(id = "com.trivago:id/fragmentHotelSearchResultsExpandedDealformCalendarTextView")
	private AndroidElement dates;
	
	@AndroidFindBy(id = "com.trivago:id/activitySearchDestinationSearchEditText")
	private AndroidElement destinationInput;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"r, Colombia,\")")
	private AndroidElement selectCartagena;
	
	@AndroidFindBy(id = "com.trivago:id/activityDatesSelectionCalendarPickerView")
	private List<AndroidElement> calendar;

	@AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"Seleccionar fechas\")")
	private AndroidElement selectDate;
	

	
	@AndroidFindBy(xpath = "//*[@selected='true']")
	private List <AndroidElement> daySelected;
	
	
	@AndroidFindBy(id = "com.trivago:id/activityDatesSelectionCalendarApplyTextView")
	private AndroidElement confirmDate;
	
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

	public HomePage checkPrincipalPage() {
		CustomWait.waitAndroidElementVisibility(driver,searchHotelsButton, 200);
		return this;
	}
	
	public NavigationBarPage goToNavigationBar() {
		return new NavigationBarPage(driver);
	}
	
	public boolean checkDataPrivacityInvisible() {
		return isPresent(accept);
	}
	
	public boolean checkDataCalendarVisible() {
		return isPresent(calendar);
	}
	
	public boolean checkConfirm() {
		return isEnabled(confirmDate);
	} 
	public HomePage typeDestination(String place, String country) {
		destinationPlace = place;
		String destinationPlace = format("new UiSelector().textContains(\"%s\")", " " +country+",");
		clickOn(destination);
		CustomWait.waitAndroidElementVisibility(driver,destinationInput, 80);
		sendKey(destinationInput, place);
		CustomWait.waitInSeconds(6);
		AndroidElement destioantionPlaceElement = findElementByUISelector(destinationPlace);
		CustomWait.waitAndroidElementVisibility(driver,destioantionPlaceElement, 100);
		clickOn(destioantionPlaceElement);
		CustomWait.waitAndroidElementVisibility(driver,selectDate, 40);
		clickOn(daySelected.get(0));
		return this;
	}
	
	public HomePage selectDate(String startMonth, String startDay, String finalMonth, String finalDay, String year) {
		day1=startDay;
		day2= finalDay;
		month1= startMonth;
		month2= startMonth;
		if (startMonth.contentEquals(finalMonth)) {	
			Logger.info("Initial month is the same that the final month");
	        String nextMonth = nextMonth(startMonth.toLowerCase())+ " de "+ year;
			scrollToText(nextMonth);
			clickOn(findElementByUISelector(format("new UiSelector().textContains(\"%s\")", startDay)));
			clickOn(findElementByUISelector(format("new UiSelector().textContains(\"%s\")", startDay)));
			clickOn(findElementByUISelector(format("new UiSelector().textContains(\"%s\")", finalDay)));
		}
		else {
			scrollToText(nextMonth(startMonth.toLowerCase())+ " de "+ year);
			clickOn(findElementByUISelector(format("new UiSelector().textContains(\"%s\")", startDay)));
			clickOn(findElementByUISelector(format("new UiSelector().textContains(\"%s\")", startDay)));
			scrollToText(nextMonth(finalMonth.toLowerCase())+ "de"+ year);
			clickOn(findElementByUISelector(format("new UiSelector().textContains(\"%s\")", finalDay)));
		}
		
		CustomWait.waitAndroidElementVisibility(driver,selectDate, 200);
		clickOn(confirmDate);
		return this;
	}
	
	public boolean checkDestinstionAndDate() {
		CustomWait.waitAndroidElementVisibility(driver,finalDestination, 60);
		return getText(finalDestination).contains("Cartagena")&&getText(dates).contains(day1)&&getText(dates).contains(day2);
	}
	
	public String nextMonth(String month) {
		String nextMonth = "enero";
		for (int i = 0; i < monthNames.length; i++) {
			if (month.equals(monthNames[i]) && !"diciembre".equals(monthNames[i])){
				nextMonth= monthNames[i+1];
			}
		}
		Logger.info("Alert Message: " + nextMonth);
		return nextMonth;
		
	}
}