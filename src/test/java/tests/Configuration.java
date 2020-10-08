package tests;

import org.junit.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import screens.SelectCountryPage;
import screens.ConfigurationPage;
import util.tests.BaseMobileTest;

public class Configuration extends BaseMobileTest {

	/**
	 * Verify the change on the app configration
	 * 
	 * @author AnyOne
	 * 
	 */
	@Parameters({ "country" })
//	@Test(groups = { "someGroup" })
	@Test()
	public void dataPrivacityTest(String country) {
		SelectCountryPage selectCountry = returnFirstScreen();
		ConfigurationPage configurationPage = selectCountry.selectCountryPage(country).confirmCountry().acceptConditions().checkPrincipalPage().
				goToNavigationBar().goToConfiguration();
		Assert.assertTrue(configurationPage.checkTheConfigurationPage());
		configurationPage.goToDataPrivacityConfiguration().changeDataPrivacityConfiguration().goToDataPrivacityConfiguration();
		Assert.assertNotEquals(configurationPage.getInitialConfiguration(), configurationPage.putFinalConfiguration());
		
	}

}
