package com.automation.training.tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import com.automation.training.pages.ESPNHomePage;
import com.automation.training.pages.LoginPage;


public class ESPNTestsLogIn extends BaseTests{
	
	
	@Test
	public void testESPNLogin(){
		ESPNHomePage home = getESPNHomePage();
		LoginPage loginPage = home.goToLoginPage();
	    home = loginPage.logIn("melipia9@prueba.com", "prueba123");
		assertEquals("Melissa", home.checkUserName());
	}
	
	@Test
	public void testESPNLoginFailedEmail(){
		ESPNHomePage home = getESPNHomePage();
		LoginPage loginPage = home.goToLoginPage().logInFail("melipi@prueba.com", "prueba123");
		assertEquals("The credentials you entered are incorrect.\n" 
				+ "Reminder: Passwords are case sensitive.", loginPage.checkMessage());
	}
	
	@Test
	public void testESPNLoginFailedPassword(){
		ESPNHomePage home = getESPNHomePage();
		LoginPage loginPage = home.goToLoginPage().logInFail("melipia9@prueba.com", "prueba");
		assertEquals("The credentials you entered are incorrect.\n" 
				+ "Reminder: Passwords are case sensitive.", loginPage.checkMessage());
	}
}
