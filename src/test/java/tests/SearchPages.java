package tests;

import org.junit.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import screens.SelectCountryPage;
import screens.HomePage;
import util.tests.BaseMobileTest;

public class SearchPages extends BaseMobileTest {

	/**
	 * Verify seach some placen and select the date
	 * 
	 * @author AnyOne
	 * 
	 */
	@Parameters({ "country", "destination", "initialMonth", "initialDay", "finalMonth","finalDay", "year" })
//	@Test(groups = { "someGroup" })
	@Test()
	public void dataPrivacityTest(String country, String destination, String initialMonth, String initialDay, String finalMonth, String finalDay, String year) {
		SelectCountryPage selectCountry = returnFirstScreen();
		HomePage homePage = selectCountry.selectCountryPage(country).confirmCountry().acceptConditions().checkPrincipalPage().typeDestination(destination, country);
		Assert.assertTrue(homePage.checkDataCalendarVisible());		
		Assert.assertFalse(homePage.checkConfirm());
		homePage.selectDate(initialMonth, initialDay, finalMonth, finalDay, year);
		Assert.assertTrue(homePage.checkDestinstionAndDate());
		
		
	}

}
