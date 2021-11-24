package com.technocredits.orghrm.testscripts;

import org.testng.asserts.SoftAssert;

import com.technocredits.orghrm.base.PredefinedActions;
import com.technocredits.orghrm.pages.LoginPage;
import com.technocredits.orghrm.pages.MenuPage;

public class TestBase {

	SoftAssert softAsset = new SoftAssert();
	
	public MenuPage setup() {
		System.out.println("STEP - Launch OrgHrm Application");
		PredefinedActions.start();
		LoginPage loginPage = LoginPage.getObject();
		loginPage.enterCredentials("Admin", "0OGYrZ8kw@");
		System.out.println("Click on Login button");
		return loginPage.clickOnLoginButton();
	}
	
	public void teardown() {
		PredefinedActions.closeBrowser();
	}

}
