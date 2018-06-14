package com.selenium.day4.dataProvider;

import org.testng.annotations.DataProvider;

public class EcshopDataFactory {
	@DataProvider(name="loginTestData")
	public static Object[][] loginTestData(){
//		return new Object[][] {
//			new Object[] {"zhangsan","12345678","登录成功"},
//			new Object[] {"lisi","12345678","用户名或密码错误"},
//			new Object[] {"","12345678","用户名不能为空"},
//			new Object[] {"lisi","","登录密码不能为空"}
//		};
		return ReadExcel.readDataFromExcel("ecshopTestCase.xlsx", "loginTestCase");
	}
	@DataProvider(name="regTestData")
	public static Object[][] regTestData(){
		return ReadExcel.readDataFromExcel("ecshopTestCase.xlsx", "regTestCase");
	}

}