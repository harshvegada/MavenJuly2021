package com.technocredits.orghrm.pages;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.technocredits.orghrm.base.PredefinedActions;

public class PIM_AddEmployeePage extends PredefinedActions{
	
	public String getEmployeeId() {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement employeeId = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='employeeId']")));
		return employeeId.getAttribute("value");
	}
	
	public PIM_AddEmployeePage setEmpFirstName(String fname) {
		driver.findElement(By.xpath("//input[@id='first-name-box']")).sendKeys(fname);
		return this;
	}
	
	public PIM_AddEmployeePage setEmpMiddleName(String mname) {
		driver.findElement(By.xpath("//input[@id='middle-name-box']")).sendKeys(mname);
		return this;
	}
	
	public PIM_AddEmployeePage setEmpLastName(String lname) {
		driver.findElement(By.xpath("//input[@id='last-name-box']")).sendKeys(lname);
		return this;
	}
	
	public PIM_AddEmployeePage setEmployeeLocation(String location) {
		driver.findElement(By.xpath("//i[text()='arrow_drop_down']")).click();
		driver.findElement(By.xpath("//span[text()='"+location+"']//parent::a")).click();
		return this;
	}
	
	public PIM_AddEmployeePage clickOnNext() {
		driver.findElement(By.xpath("//button[text()='Next']")).click();
		return this;
	}

	public void addEmployeeInfo(String fname, String mname, String lname, String location) {
		setEmpFirstName(fname);
		setEmpMiddleName(mname);
		setEmpLastName(lname);
		setEmployeeLocation(location);
	}
	
	public PIM_AddEmployeePage setHobbies(String hobbies) {
		WebDriverWait wait = new WebDriverWait(driver,15);
		WebElement hobbiesElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='5']")));
		
		//JavascriptExecutor js = (JavascriptExecutor)driver;
		//js.executeScript("arguments[0].scrollIntoView(true)", hobbiesElement);
		hobbiesElement.sendKeys(hobbies);
		return this;
	}
	
	public PIM_AddEmployeePage setWorkShift(String shiftValue) {
		WebDriverWait wait = new WebDriverWait(driver, 30); // 500 ms
		WebElement workShiftElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='work_shift_id_inputfileddiv']//span[@class='caret']//following-sibling::input")));
		workShiftElement.click();
		
		/*try {
			driver.findElement(By.xpath("//div[@id='work_shift_id_inputfileddiv']//span[@class='caret']//following-sibling::input")).click();
		}catch(StaleElementReferenceException staleException) {
			driver.findElement(By.xpath("//div[@id='work_shift_id_inputfileddiv']//span[@class='caret']//following-sibling::input")).click();
		}*/
		
		/*int count = 1;
		while(count <=5) {
			try {
				driver.findElement(By.xpath("//div[@id='work_shift_id_inputfileddiv']//span[@class='caret']//following-sibling::input")).click();
				break;
			}catch(StaleElementReferenceException staleException) {
				driver.findElement(By.xpath("//div[@id='work_shift_id_inputfileddiv']//span[@class='caret']//following-sibling::input")).click();
			}
			count++;
		}*/
		//WebElement e = driver.findElement(
				//By.xpath("//ul[contains(@class,'dropdown-content select-dropdown')]//span[text()='"+shiftValue+"']"));
		/*while(!e.isDisplayed()) {
			e = driver.findElement(
					By.xpath("//ul[contains(@class,'dropdown-content select-dropdown')]//span[text()='"+shiftValue+"']"));
		}*/
		//wait.until(ExpectedConditions.visibilityOf(e));
		WebElement e = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[contains(@class,'dropdown-content select-dropdown')]//span[text()='"+shiftValue+"']")));
		e.click();
		return this;
	}
	
	//TODO - Sun, 20 Sep 2015
	public PIM_AddEmployeePage setEffectiveFrom(String date) {
		date = date.split("\\.")[0];
		driver.findElement(By.xpath("//label[text()='Effective From']/following-sibling::span//i")).click();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement effectiveFromElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='add_employee_effective_date']//following-sibling::span[1]//div[text()='"+date+"'][contains(@class,'--infocus')]")));
		effectiveFromElement.click();
		return this;
	}
	
	public PIM_AddEmployeePage setRegion(String region) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement regionDropDown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[text()='Region']/preceding-sibling::div/input")));
		// scrolling
		regionDropDown.click();
		
		WebElement regionElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='"+region+"']")));
		regionElement.click();
		return this;
	}
	
	public PIM_AddEmployeePage setFte(String fteInput) {
		if(fteInput.equals("1.0"))
			fteInput = "1";
		driver.findElement(By.xpath("//div[@id='10_inputfileddiv']//span[@class='caret']//following-sibling::input"))
				.click();
		WebElement e = getElement("XPATH", "//div[@id='10_inputfileddiv']//span[text()='" + fteInput + "']", true);
		clickOnElement(e);
		//driver.findElement(By.xpath("//div[@id='10_inputfileddiv']//span[text()='" + fteInput + "']")).click();
		return this;
	}

	public PIM_AddEmployeePage setTemporaryDepartment(String tempDept) {
		//WebElement e = driver.findElement(By.xpath("//div[@id='11_inputfileddiv']//span[@class='caret']//following-sibling::input"));
		//WebElement e = getElement("XPATH", "//div[@id='11_inputfileddiv']//span[@class='caret']//following-sibling::input", false);
		clickOnElement(getElement("XPATH", "//div[@id='11_inputfileddiv']//span[@class='caret']//following-sibling::input", false));
		//WebElement fteElement = getElement("XPATH", "//div[@id='11_inputfileddiv']//span[text()='" + tempDept + "']", true);
		clickOnElement(getElement("XPATH", "//div[@id='11_inputfileddiv']//span[text()='" + tempDept + "']", true));
		return this;
	}
	
	public PIM_AddEmployeePage clickOnSave() {
		driver.findElement(By.xpath("//button[text()='Save']")).click();
		return this;
	}
	
	public boolean isSuccessfullySaved() {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='toast-message']")));
			return true;
		}catch(NoSuchElementException | StaleElementReferenceException e) {
			return false;
		}
	}
	
	public void waitTillSuccessfulMessageIsInvisible() {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='toast-message']")));
	}
	
	public boolean isUsernameTitleDisplayed() {
		//span[@id='pim.navbar.employeeName']
		WebDriverWait wait = new WebDriverWait(driver, 30);
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@id='pim.navbar.employeeName']")));
			return true;
		}catch(TimeoutException te) {
			return false;
		}
	}
}
