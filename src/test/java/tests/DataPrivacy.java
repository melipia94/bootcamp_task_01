package tests;

import org.junit.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import screens.SelectCountryPage;
import screens.DataPrivacityPage;
import screens.HomePage;
import util.tests.BaseMobileTest;

public class DataPrivacy extends BaseMobileTest {

	/**
	 * Verify accept the data provacity
	 * 
	 * @author AnyOne
	 * 
	 */
	@Parameters({ "country"})
//	@Test(groups = { "someGroup" })
	@Test()
	public void dataPrivacityTest(String country) {
		SelectCountryPage selectCountry = returnFirstScreen();
		DataPrivacityPage dataPrivacity= selectCountry.selectCountryPage(country).confirmCountry();
		Assert.assertEquals(dataPrivacity.checkTile(), "Privacidad de datos");		
		Assert.assertEquals(dataPrivacity.checkText()[0], "Creemos que mereces la mejor experiencia posible cuando usas trivago.");		
		Assert.assertEquals(dataPrivacity.checkText()[1], "Por ello, nosotros y los sitios web de nuestros socios externos compartimos y recopilamos datos, y usamos cookies y otras tecnologías para funcionamiento del sitio, seguimiento, análisis y publicidad personalizada dentro y fuera de trivago.");		
		Assert.assertEquals(dataPrivacity.checkText()[2], "Si estás de acuerdo, confirma tu consentimiento haciendo clic en “Aceptar todo” o personaliza tus preferencias en la configuración de privacidad de tus datos.");
		HomePage homePage = dataPrivacity.acceptConditions().checkPrincipalPage();
		Assert.assertFalse(homePage.checkDataPrivacityInvisible());
		
		
	}

}
