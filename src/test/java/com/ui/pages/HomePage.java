package com.ui.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import com.constants.Browser;
import static com.constants.Env.*;
import com.utility.BrowserUtility;
import com.utility.JsonUtility;
import com.utility.LoggerUtility;

public final class HomePage extends BrowserUtility{

	private static final By SIGN_IN_LINK_LOCATOR = By.xpath("//a[contains(text(),'Sign in')]");
	Logger logger = LoggerUtility.getLogger(this.getClass());
	
	public HomePage(Browser browserName, boolean isHeadless) {
		super(browserName, isHeadless); // To call Parent class constructor from the child constructor
		goToWebsite(JsonUtility.readJosn(QA).getUrl());
	}
	
	public LoginPage goToLoginPage() {
		logger.info("Trying to perform click to go to Sign in Page");
		clickOn(SIGN_IN_LINK_LOCATOR);
		return new LoginPage(getDriver());
	}
}
