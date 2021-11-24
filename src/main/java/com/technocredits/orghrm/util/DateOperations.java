package com.technocredits.orghrm.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateOperations {

	public static String getTimeStamp() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("ddMMyyyymmss");
		Date date = new Date();
		String timestamp = dateFormat.format(date);
		return timestamp;
	}
}
