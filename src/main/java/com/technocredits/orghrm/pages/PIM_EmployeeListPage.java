package com.technocredits.orghrm.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.technocredits.orghrm.base.PredefinedActions;
import com.technocredits.orghrm.pojo.Employee;

public class PIM_EmployeeListPage extends PredefinedActions{

	public PIM_EmployeeListPage clickOnFilter() {
		driver.findElement(By.xpath("//li[@data-tooltip='Filter']")).click();
		return this;		
	}

	public PIM_EmployeeListPage setEmpIdInQuickSerch(String empId) {
		return setEmpNameInQuickSerch(empId);
	}
	
	public PIM_EmployeeListPage setEmpNameInQuickSerch(String empName) {
		WebDriverWait wait=new WebDriverWait(driver,40);
		WebElement quickSerch=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='employee_name_quick_filter_employee_list_value']")));
		quickSerch.sendKeys(empName);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		return this;
	}
	
	private void waitTillSuggestionBoxAppear() {
		System.out.println("wait until the list get populated and then click quick search");
		WebDriverWait wait=new WebDriverWait(driver,15);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='employee_name_quick_filter_employee_list_dropdown']/div[@class='angucomplete-row']")));
	}
	
	public PIM_EmployeeListPage clickOnQuickSearch(boolean isWaitRequired) {
		
		WebDriverWait wait=new WebDriverWait(driver,15);
		if(isWaitRequired)
			waitTillSuggestionBoxAppear();
		
		WebElement quickSerch=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//i[@id='quick_search_icon']")));
		quickSerch.click();
		return this;
	}
	
	/*public List<Employee> getListOfEmployee(){
		
	}*/
	
	public Employee getEmployeeDetailsById(boolean isEmployeeExpected) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		if(isEmployeeExpected)
			wait.until(ExpectedConditions.numberOfElementsToBe(By.xpath("//table[@id='employeeListTable']/tbody/tr"), 1));
		return getListOfEmployee().get(0);
	}
	
	
	public List<Employee> getListOfEmployee(){
		WebDriverWait wait = new WebDriverWait(driver, 10);
		//wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@id='linear-progress']/div[@id='loading-bar']/div")));
		int totalRows = driver.findElements(By.xpath("//table[@id='employeeListTable']/tbody/tr")).size();
		
		List<Employee> listOfEmployee = new ArrayList<Employee>();
		try {
			for(int rowIndex=1; rowIndex<=totalRows; rowIndex++) {
				System.out.println("Row Iteration -> " + rowIndex);
				Employee e1 = new Employee();
				e1.setEmpid(driver.findElement(By.xpath("//table[@id='employeeListTable']/tbody/tr["+rowIndex+"]/td[2]")).getText());
				e1.setName(driver.findElement(By.xpath("//table[@id='employeeListTable']/tbody/tr["+rowIndex+"]/td[3]")).getText());	
				e1.setJobTitle(driver.findElement(By.xpath("//table[@id='employeeListTable']/tbody/tr["+rowIndex+"]/td[4]")).getText());
				e1.setStatus(driver.findElement(By.xpath("//table[@id='employeeListTable']/tbody/tr["+rowIndex+"]/td[5]")).getText());
				e1.setSubUnit(driver.findElement(By.xpath("//table[@id='employeeListTable']/tbody/tr["+rowIndex+"]/td[6]")).getText());
				e1.setCostCenter(driver.findElement(By.xpath("//table[@id='employeeListTable']/tbody/tr["+rowIndex+"]/td[7]")).getText());
				e1.setLocation(driver.findElement(By.xpath("//table[@id='employeeListTable']/tbody/tr["+rowIndex+"]/td[8]")).getText());
				e1.setSupervisor(driver.findElement(By.xpath("//table[@id='employeeListTable']/tbody/tr["+rowIndex+"]/td[9]")).getText());
				listOfEmployee.add(e1);
			}
		}
		catch(Exception e) {
			
		}
		return listOfEmployee;
	}
}