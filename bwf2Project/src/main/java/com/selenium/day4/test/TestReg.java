package com.selenium.day4.test;

import org.testng.annotations.Test;

import com.selenium.day4.utils.TestBase;
import com.selenium.day4.dataProvider.EcshopDataFactory;
import com.selenium.day4.pageObject.IndexPage;
import com.selenium.day4.pageObject.RegPage;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;

public class TestReg extends TestBase {

	@Test(dataProviderClass = EcshopDataFactory.class, dataProvider = "regTestData")
	public void test(String content,String expectedResult) {
		driver.get("http://localhost:5555/ecshop");
		IndexPage indexPage = new IndexPage(driver);
		indexPage.click_reg_link();			
		RegPage regPage=new RegPage(driver);
		regPage.register(content);
		regPage.assert_all_input_text(expectedResult);
	
	}
	
	

}
