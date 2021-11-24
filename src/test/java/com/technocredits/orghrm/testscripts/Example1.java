package com.technocredits.orghrm.testscripts;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.technocredits.orghrm.util.ExcelOperations;

public class Example1 {

	@Test(dataProvider="LoginDataProvider")
	public void m1(String username, String password) {
		System.out.println(username);
		System.out.println(password);
	}
	
	@DataProvider(name="LoginDataProvider")
	public Object[][] getData() throws IOException {
		return ExcelOperations.getData("./testdata/login.xlsx", "data");
	}
	
	
}
