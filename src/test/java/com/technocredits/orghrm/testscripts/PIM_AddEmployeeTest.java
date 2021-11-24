package com.technocredits.orghrm.testscripts;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.technocredits.orghrm.constants.ConstantPath;
import com.technocredits.orghrm.pages.MenuPage;
import com.technocredits.orghrm.pages.PIM_AddEmployeePage;
import com.technocredits.orghrm.pages.PIM_EmployeeListPage;
import com.technocredits.orghrm.pojo.Employee;
import com.technocredits.orghrm.util.ExcelOperations;

public class PIM_AddEmployeeTest extends TestBase{

	private MenuPage menuPage;
	
	@BeforeMethod
	public void setUp() {
		menuPage = super.setup();
	}
	
	@Test
	public void verifyAddEmployeeTest() {
		menuPage.navigateTo("PIM->Add Employee");
		PIM_AddEmployeePage pim_AddEmployeePage = new PIM_AddEmployeePage();
		String empId = pim_AddEmployeePage.getEmployeeId();
		pim_AddEmployeePage
			.setEmpFirstName("Techno")
			.setEmpMiddleName("M")
			.setEmpLastName("Credits")
			.setEmployeeLocation("Australian Regional HQ")
			.clickOnNext()
			.setHobbies("Reading")
			.clickOnNext()
			.setWorkShift("Twilight")
			.setEffectiveFrom("12")
			.setRegion("Region-1")
			.setFte("0.5")
			.setTemporaryDepartment("Sub unit-3")
			.clickOnSave();
		
		boolean IstoastMessageVisible = pim_AddEmployeePage.isSuccessfullySaved();
		Assert.assertTrue(IstoastMessageVisible);
		boolean isUserNameDisplayed = pim_AddEmployeePage.isUsernameTitleDisplayed();
		Assert.assertTrue(isUserNameDisplayed);
		
		menuPage.navigateTo("Employee List");
		PIM_EmployeeListPage pim_EmployeeListPage = new PIM_EmployeeListPage();
	/*	List<Employee> listOfEmployee = pim_EmployeeListPage
			.setEmpNameInQuickSerch("Techno")
			.clickOnQuickSearch()
			.getListOfEmployee();
		
		boolean isEmployeeIdDisplayed = false;
		for(Employee e : listOfEmployee) {
			if(e.getEmpid().equals("0150")) {
				isEmployeeIdDisplayed = true;
				break;
			}
		}*/
		
		List<Employee> listOfEmployee = pim_EmployeeListPage
			.setEmpIdInQuickSerch(empId)
			.getListOfEmployee();
		Assert.assertEquals(listOfEmployee.get(0).getEmpid(), empId);
		Assert.assertTrue(listOfEmployee.size() == 1);
	}
	

	@Test(dataProvider="employeeDataProvider", enabled=false)
	public void verifyAddEmployeeDataDrivenTest(String firstname, String middlename, String lastname,
			String location, String hobbies, String workShift, String effectiveFrom,
			String region, String fte, String dept) {
		menuPage.navigateTo("PIM->Add Employee");
		PIM_AddEmployeePage pim_AddEmployeePage = new PIM_AddEmployeePage();
		String empId = pim_AddEmployeePage.getEmployeeId();
		pim_AddEmployeePage
			.setEmpFirstName(firstname)
			.setEmpMiddleName(middlename)
			.setEmpLastName(lastname)
			.setEmployeeLocation(location)
			.clickOnNext()
			.setHobbies(hobbies)
			.clickOnNext()
			.setWorkShift(workShift)
			.setEffectiveFrom(effectiveFrom)
			.setRegion(region)
			.setFte(fte)
			.setTemporaryDepartment(dept)
			.clickOnSave();
		
		boolean IstoastMessageVisible = pim_AddEmployeePage.isSuccessfullySaved();
		Assert.assertTrue(IstoastMessageVisible);
		boolean isUserNameDisplayed = pim_AddEmployeePage.isUsernameTitleDisplayed();
		Assert.assertTrue(isUserNameDisplayed);
		
		menuPage.navigateTo("Employee List");
		PIM_EmployeeListPage pim_EmployeeListPage = new PIM_EmployeeListPage();
		
		List<Employee> listOfEmployee = pim_EmployeeListPage
			.setEmpIdInQuickSerch(empId)
			.getListOfEmployee();
		Assert.assertEquals(listOfEmployee.get(0).getEmpid(), empId);
		Assert.assertTrue(listOfEmployee.size() == 1);
	}
	
	@DataProvider(name="employeeDataProvider")
	public Object[][] getEmployeeData() throws IOException {
		return ExcelOperations.getData(ConstantPath.TESTDATA+ConstantPath.EMPLOYEE_TESTDATA, "data");
	}
	
	@AfterMethod
	public void teardown() {
		super.teardown();
	}
}
