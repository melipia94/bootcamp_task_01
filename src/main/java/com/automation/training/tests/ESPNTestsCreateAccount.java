package com.automation.training.tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import com.automation.training.pages.ESPNHomePage;
import com.automation.training.pages.LoginPage;
import com.automation.training.pages.SignUpPage;


public class ESPNTestsCreateAccount extends BaseTests{
	
	@Test
	public void testESPNCrearAccountSuccessful(){
		ESPNHomePage home = getESPNHomePage();
		LoginPage loginPage = home.goToLoginPage();
	    SignUpPage signUpPage = loginPage.selectSignUp().putTheInformation("Melissa", "Pineda","melipia105@prueba.com", "prueba123" );
		home = signUpPage.confirmInformation();
		assertEquals("Melissa", home.checkUserName());
	}
	
	@Test
	public void testESPNCrearAccountEmailFailed(){
		ESPNHomePage home = getESPNHomePage();
		LoginPage loginPage = home.goToLoginPage();
	    SignUpPage signUpPage = loginPage.selectSignUp().putTheInformation("Melissa", "Pineda","melipia55@");
		assertEquals("Please enter a valid email address.", signUpPage.checkErrorMessageEmail());
	}
	
	@Test
	public void testESPNCrearAccountPasswordShort(){
		ESPNHomePage home = getESPNHomePage();
		LoginPage loginPage = home.goToLoginPage();
	    SignUpPage signUpPage = loginPage.selectSignUp().putTheInformation("Melissa", "Pineda","melipia55@pruebas.com", "12");
		assertEquals("The password is too short.", signUpPage.checkErrorMessagePassword());
	}

	
}
