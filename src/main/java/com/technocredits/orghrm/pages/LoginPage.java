package com.technocredits.orghrm.pages;

import java.io.IOException;
import org.openqa.selenium.WebElement;

import com.technocredits.orghrm.base.PredefinedActions;
import com.technocredits.orghrm.constants.ConstantPath;
import com.technocredits.orghrm.util.PropertiesOperation;

public class LoginPage extends PredefinedActions {
	private PropertiesOperation proOperation;
	static private LoginPage loginPage;
	
	private LoginPage() {
		try {
			proOperation = new PropertiesOperation(ConstantPath.LOGINPAGELOCATOR_PATH);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static LoginPage getObject() {
		if(loginPage == null)
			loginPage = new LoginPage();
		return loginPage;
	}
	
	public boolean isLogoDisplayed() {
		String logoLocator = proOperation.getValue("logo"); // [XPATH]:-//img
		WebElement element = getElement(logoLocator, false);
		return isElementDisplayed(element);
	}
	
	public boolean isLoginPanelDisplayed() {
		String logoLocator = proOperation.getValue("loginPanel");
		WebElement element = getElement(logoLocator, false);
		return isElementDisplayed(element);
	}
	
	public void enterCredentials(String username, String password) {
		enterUsername(username);
		enterPassword(password);
	}
	
	private void enterUsername(String username) {
		WebElement element = getElement(proOperation.getValue("username"), false);
		enterText(element, username);
	}
	
	private void enterPassword(String password) {
		WebElement element = getElement( proOperation.getValue("password"), false);
		enterText(element, password);
	}
	
	public MenuPage clickOnLoginButton() {
		WebElement element = getElement(proOperation.getValue("loginBtn"),false);
		clickOnElement(element);
		return new MenuPage();
	}
	
	public String getLoginErrorMessage() {
		WebElement e = getElement(proOperation.getValue("loginErrorMessage"), false);
		return e.getText();
	}
}
