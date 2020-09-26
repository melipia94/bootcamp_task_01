package com.automation.training.tests;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.automation.training.pages.ArticlePage;
import com.automation.training.pages.ESPNHomePage;
import com.automation.training.pages.LoginPage;
import com.automation.training.pages.SignUpPage;


public class ESPNTests extends BaseTests{
	

	@Test
	public void testESPNLogin(){
		ESPNHomePage home = getESPNHomePage();
		LoginPage loginPage = home.goToLoginPage();
	    SignUpPage signUpPage = loginPage.selectSignUp().putTheInformation("Melissa", "Pineda","melipia15@prueba.com", "prueba123" );
		home = signUpPage.confirmInformation();
		assertEquals("Melissa", home.checkUserName());
	}

}
