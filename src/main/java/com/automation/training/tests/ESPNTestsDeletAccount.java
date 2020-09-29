package com.automation.training.tests;

import static org.testng.Assert.assertEquals;


import org.testng.annotations.Test;

import com.automation.training.pages.ESPNHomePage;
import com.automation.training.pages.LoginPage;



public class ESPNTestsDeletAccount extends BaseTests{
	

	@Test
	public void testESPNDelete(){
		ESPNHomePage home = getESPNHomePage();
		LoginPage loginPage = home.goToLoginPage();
	    home = loginPage.logIn("melipia103@prueba.com", "prueba123");
		assertEquals("Melissa", home.checkUserName());
		loginPage = home.goToProfile().deleteAccount().goToLoginPage().logInFail("melipia103@prueba.com", "prueba123");
		assertEquals("Account Deactivated", loginPage.checkLogInFail());
	
		
	}
}
