package com.selenium.day4.test;

import org.testng.annotations.Test;

import com.selenium.day4.utils.DriverUtils;
import com.selenium.day4.utils.TestBase;
import com.selenium.day4.pageObject.IndexPage;
import com.selenium.day4.pageObject.LoginPage;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;

import java.sql.Driver;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;

public class TestLoginFirst {

	@Test
	public void test() {
		System.setProperty("browser.type", "chrome");
		DriverUtils.initService();
		WebDriver driver = DriverUtils.getDriver();
		driver.get("http://localhost:5555/ecshop");
		IndexPage indexPage = new IndexPage(driver);
		indexPage.click_login_link();
		LoginPage loginPage = new LoginPage(driver);
		loginPage.input_username("zhangsan");
		loginPage.input_pwd("12345678");
		loginPage.click_submit_btn();
		// 当页面跳转比较快时，则用driver.getPageSource()来获取源代码，然后进行定位
		// System.out.println(driver.getPageSource());
		loginPage.assert_result_text("登录成功");
		DriverUtils.quitDriver();
		DriverUtils.stopService();
		//可以 封装一下
	}

}
