package com.automation.training.tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;

import org.testng.annotations.Test;

import com.automation.training.pages.ESPNHomePage;
import com.automation.training.pages.LoginPage;
import com.automation.training.pages.SignUpPage;

public class ESPNTest extends BaseTests{
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
	@Test
	public void testESPNLogOut(){
		ESPNHomePage home = getESPNHomePage();
		LoginPage loginPage = home.goToLoginPage();
	    home = loginPage.logIn("melipia9@prueba.com", "prueba123");
		assertEquals("Melissa", home.checkUserName());
		home= home.logOut();
		assertFalse("Melissa".contentEquals(home.checkUserName()), "The log out wasn't successful");
	
		
	}
	
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
