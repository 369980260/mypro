package com.selenium.day4.utils;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class TestBase {
	public WebDriver driver;

	@BeforeSuite
	public void beforeSuite() {
		System.setProperty("browser.type", "chrome");
		DriverUtils1.initService();

	}

	@BeforeMethod
	public void beforeMethod() {
		driver = DriverUtils1.getDriver();
	}

	@AfterMethod
	public void afterMethod() {
		DriverUtils1.quitDriver();
	}

	@AfterSuite
	public void afterSuite() {
		DriverUtils1.stopService();
	}

	// public static void splitStr(String str) {
	// String[] split_str=str.split(",");
	//
	//
	// }

}
