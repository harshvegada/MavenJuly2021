package com.technocredits.orghrm.testscripts;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.technocredits.orghrm.base.PredefinedActions;
import com.technocredits.orghrm.pages.DashboardPage;

public class DashboardTest extends TestBase{

	@BeforeClass
	public void setUp() {
		super.setup();
	}
	
	@Test
	public void verfiyWidgetsTest() {
		
		System.out.println("VERFIY - Dashboard page title should be Dashboard");
		DashboardPage dashboardPage = new DashboardPage();
		String expectedDashboardPageHeaderTitle = "Dashboard";
		String actualDashboardPageHeaderTitle = dashboardPage.getPageHeaderTile();
		softAsset.assertEquals(actualDashboardPageHeaderTitle, expectedDashboardPageHeaderTitle);
		
		String expectedDashboardPageTitle = "Dashboard";
		String actualDashboardPageTitle = dashboardPage.getPageTitle();
		softAsset.assertEquals(actualDashboardPageTitle, expectedDashboardPageTitle);
		
		System.out.println("VERIFY - total 12 widget's are disply on Dashboard page");
		int totalWidgets = dashboardPage.getTotalWidgets();
		softAsset.assertEquals(totalWidgets, 12);
		softAsset.assertAll();
		
		System.out.println("STEP - Get all widgets name");
		List<String> expectedList = new ArrayList<String>();
		expectedList.add("Quick Access");
		expectedList.add("Buzz Latest Posts");
		expectedList.add("Employee Job Details");
		expectedList.add("My Actions");
		expectedList.add("Headcount by Location");
		expectedList.add("Employees on Leave Today");
		expectedList.add("Time At Work");
		expectedList.add("Performance Quick Feedback");
		expectedList.add("Annual basic payment by Location");
		expectedList.add("Latest Documents");
		expectedList.add("Latest News");
		expectedList.add("Yearly New Hires");

		List<String> actualWidgetsList = dashboardPage.getAllWidgetsText();
		System.out.println("VERIFY - widget names");
		Assert.assertTrue(actualWidgetsList.equals(expectedList));
	}
	
	@AfterMethod
	public void afterMethod(ITestResult result) throws IOException {
		if (result.getStatus() == ITestResult.FAILURE) {
			PredefinedActions.captureScreenshot(result.getMethod().getMethodName());
		}
	}
	
	@AfterClass
	public void tearDown() {
		
		super.teardown();
	}
}
