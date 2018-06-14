package com.selenium.day4.test;

import org.testng.annotations.Test;

import com.selenium.day4.dataProvider.EcshopDataFactory;
import com.selenium.day4.utils.TestBase;
import com.selenium.day4.dataProvider.EcshopDataFactory;
import com.selenium.day4.pageObject.IndexPage;
import com.selenium.day4.pageObject.LoginPage;



public class TestLoginParam1 extends TestBase {

	@Test(dataProviderClass = EcshopDataFactory.class, dataProvider = "loginTestData")
	public void test(String username, String pwd, String expectedResult) {
		driver.get("http://localhost:5555/ecshop");
		IndexPage indexPage = new IndexPage(driver);
		indexPage.click_login_link();
		LoginPage loginPage = new LoginPage(driver);
		loginPage.input_username(username);
		loginPage.input_pwd(pwd);
		loginPage.click_submit_btn();
		// System.out.println(driver.getPageSource());

//		System.out.println(driver.getPageSource());
		if (username.equalsIgnoreCase("") || pwd.equalsIgnoreCase("")) {
			loginPage.assert_alert_text(expectedResult);
		} else {
			loginPage.assert_result_text(expectedResult);
		}
	}

}
