package com.automation.training.pages;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static java.lang.String.format;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.automation.training.utils.Utils;

public class SleepPage extends BasePage  {
	public SleepPage(WebDriver driver) {
		super(driver);
		
	}
	private static final String PLACE = "place";
	private static final String ADULTS = "adults";
	private static final String CHILDREN = "children";
	private static final String CHILDREN_AGE = "childAge";
	private static final String ROOMS = "rooms";
	
	public By recommendedBy = By.id("group_recommendation");
	private static Map <String, String> hotelInformation= new HashMap<String, String>();
	@FindBy(id = "ss")
	private WebElement whereAreYouGoing;


	@FindBy(className = "sb-searchbox__button")
	private WebElement searchPlace;

	@FindBy(css = "div[class='bui-calendar__main b-a11y-calendar-contrasts']")
	private WebElement calendar;
	
	@FindBy(css = "div[class='bui-calendar__control bui-calendar__control--next']")
	private WebElement nextMonth;
	
	@FindBy(className = "bui-calendar__month")
	private List<WebElement> monthElement;
 
	@FindBy(css = "div[data-placeholder='Fecha de salida']")
    private WebElement departureDate;
	
	@FindBy(name = "group_adults")
	private WebElement adultSelect;
	
	@FindBy(name = "group_children")
	private WebElement childrenSelect;
	
	@FindBy(name = "age")
	private WebElement childAge;
	
	@FindBy(name = "no_rooms")
	private WebElement rooms;
	
	@FindBy(css = "button[data-sb-id]")
	private WebElement searchHotels;
	
	@FindBy(id = "group_recommendation")
	private WebElement recommended;
	
	@FindBy(css = "a[data-id='class-5']")
	private WebElement fiveStars;
	
	@FindBy(css = "#hotellist_inner > div")
	private List<WebElement> hotelOptions;
	
	@FindBy(css = "#hotellist_inner > div:nth-child(3) div[class='sr_item_content sr_item_content_slider_wrapper '] h3 a span[data-et-click]")
	private WebElement hotelName;
	
	@FindBy(css = "#hotellist_inner > div:nth-child(3) div[class='sr_item_content sr_item_content_slider_wrapper '] div[class='bui-review-score__badge']")
	private WebElement hotelScore;
	
	@FindBy(css = "#hotellist_inner > div:nth-child(3) div[class='sr_item_content sr_item_content_slider_wrapper '] div[class='bui-price-display__value prco-inline-block-maker-helper']")
	private WebElement hotelPrice;
	
	@FindBy(css = "#hotellist_inner > div:nth-child(3) div[class='sr_item_content sr_item_content_slider_wrapper '] a[class='txp-cta bui-button bui-button--primary sr_cta_button']")
	private WebElement chooseRoom;
	
	@FindBy(css = ".hp_hotel_description_hightlights_wrapper > div[class='b-group-rec-block d_pd_hp_price_left_align'] div[class='bui-price-display__label ']")
	private WebElement hotelPeople2;
	
	@FindBy(css = ".hp_hotel_description_hightlights_wrapper > div[class='b-group-rec-block d_pd_hp_price_left_align'] div[class='bui-price-display__value prco-inline-block-maker-helper']")
	private WebElement hotelPrice2;
	
	@FindBy(css = ".hp_hotel_description_hightlights_wrapper > div[class='b-group-rec-block d_pd_hp_price_left_align'] span[class='bui-button__text']")
	private WebElement reservation;
	
	@FindBy(css = "#hprt-table tbody td[class='hprt-table-cell hprt-table-room-select   droom_seperator hprt-block--room-selected'] div select")
	private WebElement selectNumberRoom;
	
	@FindBy(css= ".hprt-reservation-cta")
	private WebElement confirmReservation;
	
	public SleepPage searchPlace ()  {
		String place = Utils.getJsonDataProvider(PLACE);
		waitForElementClickable(whereAreYouGoing, 10);
		sendKeysValue(whereAreYouGoing, place);
		click(searchPlace);
		waitForElementVisible(calendar, 10);
		return this;
    }
	public SleepPage selectDate() {
		String day1 = "span[aria-label='%s']";
		Map<String, String> dateMap1= Utils.getDate(30);
		selectMonth(dateMap1.get("month"),dateMap1.get("year"));
		String dateStart = dateMap1.get("day")+ " "+ dateMap1.get("month")+ " "+dateMap1.get("year");
		click(element(By.cssSelector(format(day1,dateStart))));
		waitForElementVisible(departureDate, 10);
		click(departureDate);
		Map<String, String> dateMap2= Utils.getDate(45);
		selectMonth(dateMap2.get("month"),dateMap2.get("year"));
		String dateEnd = dateMap2.get("day")+ " "+ dateMap2.get("month")+ " "+dateMap2.get("year");
		click(element(By.cssSelector(format(day1,dateEnd))));

		return this;
	}
	
	private SleepPage selectMonth(String month, String year) {
		String monthAndYear =month+" "+ year;
		boolean mounthPresent = false;
		while (!mounthPresent) {
			for (int i = 0; i < monthElement.size(); i++) {
				if(monthAndYear.equals(getText(monthElement.get(i)))) {
					mounthPresent = true;
					break;
				}	
			}
			if(!mounthPresent)click(nextMonth);
		}
		return this;
	}
	
	public SleepPage selectPeople() {
		String room = Utils.getJsonDataProvider(ROOMS);
		String adults = Utils.getJsonDataProvider(ADULTS);
		String children = Utils.getJsonDataProvider(CHILDREN);
		String childrenAge = Utils.getJsonDataProvider(CHILDREN_AGE);
		waitForElementVisible(adultSelect, 10);
		selectByVisibleText(adultSelect, adults);
		selectByVisibleText(childrenSelect, children);
		waitForElementVisible(childAge, 10);
		selectByVisibleText(childAge, childrenAge);
		selectByVisibleText(rooms, room);
		click(searchHotels);
		return this;
	}
	
	public SleepPage selectStars()  {
		waitForElementVisible(fiveStars, 10);
		scrollToElement(fiveStars);
		click(fiveStars);
		return this;
	}
	public boolean checkHotelsInformation() {
		boolean hotelInformationPresent= true;
		String hotelsName = "#hotellist_inner > div:nth-child(%s) div[class='sr_item_content sr_item_content_slider_wrapper '] h3 a span[data-et-click]";
		String hotelsScore= "#hotellist_inner > div:nth-child(%s) div[class='sr_item_content sr_item_content_slider_wrapper '] div[class='bui-review-score__badge']";
		String hotelsPrice = "#hotellist_inner > div:nth-child(%s) div[class='sr_item_content sr_item_content_slider_wrapper '] div[class='bui-price-display__value prco-inline-block-maker-helper']";
		waitForElementInvisible(By.cssSelector(".sr-usp-overlay__container > div"), 30);
		waitForElementPresent(By.cssSelector(format(hotelsPrice,1)), 10);

		for (int i = 0; i < hotelOptions.size(); i++) {
			if(i+1!=2) {
				scrollToElement(element(By.cssSelector(format(hotelsPrice,i+1))));
				if(!isDispleyed(element(By.cssSelector(format(hotelsName,i+1))))|!isDispleyed(element(By.cssSelector(format(hotelsScore,i+1))))|!isDispleyed(element(By.cssSelector(format(hotelsPrice,i+1))))) {
						hotelInformationPresent= false;
						break;
				}
				highlightElement(element(By.cssSelector(format(hotelsName,i+1))));
				highlightElement(element(By.cssSelector(format(hotelsPrice,i+1))));
				highlightElement(element(By.cssSelector(format(hotelsScore,i+1))));

			}
			
		
		}
		return hotelInformationPresent;
	}
	public SleepPage selectHotel() {
		scrollToElement(hotelName);
		waitForElementVisible(hotelName, 30);
		waitForElementVisible(hotelPrice, 30);
		hotelInformation.put("hotelName", getText(hotelName));
		hotelInformation.put("hotelScore", getText(hotelScore) );
		hotelInformation.put("hotelPrice", getText(hotelPrice) );
		click(chooseRoom);
		return this;
	}
	public boolean verifyHotelInformation() {
		swichToWindow();
		waitForElementPresent(recommendedBy, 10);
		scrollToElement(recommended);
		waitForElementVisible(recommended, 10);
		String people = getText(hotelPeople2);
		String price2= getText(hotelPrice2);
		boolean theSameInformation = people.contains("15 noches") && people.contains("1 niño") && people.contains("3 adultos") && hotelInformation.get("hotelPrice").equals(price2);
		return theSameInformation ;
	}
	
	public SleepPage doReservation() {
		click(reservation);
		return this;
	}
	public PersonalDataPage selectTheRoomNumber() {
		waitForElementVisible(selectNumberRoom, 10);
		waitForElementClickable(confirmReservation, 10);
		click(confirmReservation);
		return new PersonalDataPage(driver);
	}
	
	public static Map<String, String> getterhotelInformation() {
		return hotelInformation;
	}
}
