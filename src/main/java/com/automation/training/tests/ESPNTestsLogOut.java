package com.automation.training.tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;


import org.testng.annotations.Test;

import com.automation.training.pages.ESPNHomePage;
import com.automation.training.pages.LoginPage;



public class ESPNTestsLogOut extends BaseTests{
	

	@Test
	public void testESPNLogOut(){
		ESPNHomePage  home = new ESPNHomePage(getDriver(), getURL());
		LoginPage loginPage = home.goToLoginPage();
	    home = loginPage.logIn("melipia9@prueba.com", "prueba123");
		assertEquals("Melissa", home.checkUserName());
		home= home.logOut();
		assertFalse("Melissa".contentEquals(home.checkUserName()), "The log out wasn't successful");
	
		
	}
}
