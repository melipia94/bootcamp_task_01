package com.automation.training.tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.automation.training.pages.BookingHomePage;
import com.automation.training.pages.PersonalDataPage;
import com.automation.training.pages.SleepPage;

public class BookingTest extends BaseTests{
	@Test
	public void testBookingReservation() {
		BookingHomePage bookingHomePage = new BookingHomePage(getDriver(), "URL_BOOKING");
		SleepPage bookingSleep = bookingHomePage.goToSleep().searchPlace().selectDate().selectPeople()
				.selectStars();
		Assert.assertTrue(bookingSleep .checkHotelsInformation());
		bookingSleep .selectHotel();
		Assert.assertTrue(bookingSleep.verifyHotelInformation(), "The information isn't the same");
		PersonalDataPage personalDataPage = bookingSleep.doReservation().selectTheRoomNumber().putPersonalInformation();
		Assert.assertTrue(personalDataPage.checkTheHotelName(), "The hotel name isn't the same");
		Assert.assertTrue(personalDataPage.checkTheHotelCity(), "The city isn't the same");
		Assert.assertTrue(personalDataPage.checkNameAndLastName(), "The name and the lastname aren't the same");
		Assert.assertTrue(personalDataPage.checkEmail(), "The email isn't the same");
		Assert.assertTrue(personalDataPage.checkPersonPymenth(), "The name in the payment isn't the same");

		personalDataPage.completeTheInformation();
	}
	
	
	
}
