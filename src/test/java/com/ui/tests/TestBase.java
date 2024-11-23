package com.ui.tests;

import static com.constants.Browser.CHROME;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.constants.Browser;
import com.ui.pages.HomePage;
import com.utility.BrowserUtility;
import com.utility.LoggerUtility;

public class TestBase {
	
	protected HomePage homePage;
	Logger logger = LoggerUtility.getLogger(this.getClass());
	
	@Parameters({"browser", "isHeadless"})
	@BeforeMethod(description = "Load the homepage of the website")
	public void setup(@Optional("chrome") String browser,
			           @Optional("true") boolean isHeadless) {
		logger.info("Load the homepage of the website");
		homePage = new HomePage(Browser.valueOf(browser.toUpperCase()),isHeadless);
	}

	public BrowserUtility getInatance() {
		return homePage;
	}
	
	@AfterMethod(description = "quiting the local browser sessions")
	public void closeLocalDriver() {
		BrowserUtility.tearDown();
	}
}
