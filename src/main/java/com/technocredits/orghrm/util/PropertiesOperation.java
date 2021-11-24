package com.technocredits.orghrm.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import com.technocredits.orghrm.constants.ConstantPath;

public class PropertiesOperation {
	private Properties prop;
	
	public PropertiesOperation(String fileName) throws IOException {
		File file = new File(ConstantPath.PROP_BASE_LOCATION+fileName+".properties"); //./src/test/resources/loginPageLocator.properties
		FileInputStream inputStream = new FileInputStream(file);
		prop = new Properties();
		prop.load(inputStream);
	}
	
	
	public String getValue(String key) {
		String value = prop.getProperty(key);
		return value;
	}
}
