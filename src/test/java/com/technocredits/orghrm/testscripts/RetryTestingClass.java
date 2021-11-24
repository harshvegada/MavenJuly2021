package com.technocredits.orghrm.testscripts;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RetryTestingClass {

	static int cnt = 0;

	@Test
	public void m1() {
		System.out.println("Retry " + cnt++);
		Assert.fail();
	}
}
