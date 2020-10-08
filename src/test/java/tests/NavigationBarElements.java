package tests;

import org.junit.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import screens.SelectCountryPage;
import screens.NavigationBarPage;
import util.tests.BaseMobileTest;

public class NavigationBarElements extends BaseMobileTest {

	/**
	 * Verify the app navigation bar elements
	 * 
	 * @author AnyOne
	 * 
	 */
	@Parameters({ "country"})
//	@Test(groups = { "someGroup" })
	@Test()
	public void dataPrivacityTest(String country) {
		SelectCountryPage selectCountry = returnFirstScreen();
		NavigationBarPage navigationBarPage = selectCountry.selectCountryPage(country).confirmCountry().acceptConditions().checkPrincipalPage().goToNavigationBar();
		Assert.assertTrue(navigationBarPage.checkNavigationBar());
		
		
	}

}
