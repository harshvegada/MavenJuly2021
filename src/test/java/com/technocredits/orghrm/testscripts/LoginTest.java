package com.technocredits.orghrm.testscripts;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.technocredits.orghrm.base.PredefinedActions;
import com.technocredits.orghrm.pages.LoginPage;

public class LoginTest {
	SoftAssert softAsset = new SoftAssert();
	@BeforeMethod
	public void setup() {
		PredefinedActions.start();
	}
	
	@Test
	public void loginTest() {
		System.out.println("VERIFY - Logo displayed on Login Page");
		LoginPage loginPage = LoginPage.getObject();
		boolean isLogoDisplayed = loginPage.isLogoDisplayed();
		softAsset.assertTrue(isLogoDisplayed, "Logo was not displayed on Login Page");
		
		System.out.println("VERIFY - Login Panel displayed on Login Page");
		boolean isLoginPanelDisplayed = loginPage.isLoginPanelDisplayed();		
		softAsset.assertTrue(isLoginPanelDisplayed, "LoginPanel was not displayed on Login Page");
		
		System.out.println("STEP - Enter Credentials");
		loginPage.enterCredentials("Admin", "0OGYrZ8kw@");
		softAsset.assertAll();
		
		System.out.println("Click on Login button");
		loginPage.clickOnLoginButton();
	}
	
	@Test
	public void loginTestWithoutPassword() {
		System.out.println("VERIFY - Logo displayed on Login Page");
		LoginPage loginPage = LoginPage.getObject();
		boolean isLogoDisplayed = loginPage.isLogoDisplayed();
		softAsset.assertTrue(isLogoDisplayed, "Logo was not displayed on Login Page");
		
		System.out.println("VERIFY - Login Panel displayed on Login Page");
		boolean isLoginPanelDisplayed = loginPage.isLoginPanelDisplayed();		
		softAsset.assertTrue(isLoginPanelDisplayed, "LoginPanel was not displayed on Login Page");
		
		System.out.println("STEP - Enter Credentials");
		loginPage.enterCredentials("Admin", "");
		softAsset.assertAll();
		
		System.out.println("Click on Login button");
		loginPage.clickOnLoginButton();
		
		String expectedErrorMessage = "Password cannot be empty";
		String actualErrorMessage = loginPage.getLoginErrorMessage();
		Assert.assertEquals(actualErrorMessage, expectedErrorMessage);
	}
	
	@AfterMethod
	public void teardown() {
		PredefinedActions.closeBrowser();
	}
}
