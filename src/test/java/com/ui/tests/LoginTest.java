package com.ui.tests;

import static com.constants.Browser.*;
import com.ui.pages.HomePage;
import com.ui.pages.LoginPage;
import com.ui.pages.MyAccountPage;

public class LoginTest {
	
	public static void main(String[] args) { 
		HomePage homePage = new HomePage(CHROME,true);
		LoginPage loginPage = homePage.goToLoginPage();
		MyAccountPage myAccountPage = loginPage.doLoginWith("siwepet635@evasud.com", "password");
		System.out.print(myAccountPage.getUserName());
	}
}
