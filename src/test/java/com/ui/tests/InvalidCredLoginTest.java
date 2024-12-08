package com.ui.tests;

import static org.testng.Assert.assertEquals;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.utility.LoggerUtility;

@Listeners({ com.ui.listeners.TestListener.class })
public class InvalidCredLoginTest extends TestBase {

	Logger logger = LoggerUtility.getLogger(this.getClass());
	private static final String INVALID_EMAIL_ADDRESS = "haidar111@gmail.com";
	private static final String INVALID_PASSWORD = "2hdehebe";

	@Test(description = "Verify if the proper error message is shown for the user when they enter invalid credentials ",
			groups = {"e2e", "sanity", "smoke" })
	public void InvalidloginTest() {
		assertEquals(homePage.goToLoginPage().doLoginWithInvalidCredentials(INVALID_EMAIL_ADDRESS, INVALID_PASSWORD)
				.getErrorMessage(), "Authentication failed.");
	}
}
