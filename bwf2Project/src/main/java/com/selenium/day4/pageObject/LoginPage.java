package com.selenium.day4.pageObject;


import java.sql.Driver;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.Assertion;

public class LoginPage {
	private WebDriver driver;
	@FindBy(name="username")
	private WebElement username;
	@FindBy(name="password")
	private WebElement password;
	@FindBy(name="submit")
	private WebElement submit;	
	@FindBy(xpath="//div[contains(@class,'boxCenterList')]/div/p[1]")
	private WebElement login_success_text;

	public LoginPage(WebDriver driver) {
		this.driver=driver;//当这个类也要用到driver时，在这个类中声明一个WebDriver类
		PageFactory.initElements(driver, this);
	}
	public void input_username(String name) {
		username.sendKeys(name);
	}
	public void input_pwd(String pwd) {
		password.sendKeys(pwd);
	}
	public void click_submit_btn() {
		submit.click();
	}
	public void assert_result_text(String expectedResult) {
		Assert.assertEquals(expectedResult,login_success_text.getText());
	}
	public void assert_alert_text(String expectedResult) {
	    Alert  alert=driver.switchTo().alert();	    
		Assert.assertTrue(alert.getText().contains(expectedResult));
		System.out.println(alert.getText());
		alert.accept();
	}
	


}
