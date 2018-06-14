package com.selenium.day4.pageObject;

import java.sql.Driver;
import java.util.ArrayList;
import java.util.List;

import org.apache.xml.utils.res.IntArrayWrapper;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.Assertion;

public class RegPage {
	private WebDriver driver;
	@FindBy(name = "username")
	private WebElement username;
	@FindBy(name = "email")
	private WebElement email;
	@FindBy(name = "password")
	private WebElement password;
	@FindBy(name = "confirm_password")
	private WebElement confirm_password;
	@FindBy(name = "extend_field5")
	private WebElement phone;
	@FindBy(name = "Submit")
	private WebElement submit;
	@FindBy(xpath = "//div[contains(@class,'boxCenterList')]/div/p[1]")
	private WebElement login_success_text;

	public RegPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void input_username(String name) {
		username.sendKeys(name);
	}

	public void input_pwd(String pwd) {
		password.sendKeys(pwd);
	}

	public void input_repwd(String repwd) {
		confirm_password.sendKeys(repwd);
	}

	public void input_email(String emailStr) {
		email.sendKeys(emailStr);
	}

	public void input_phone(String phoneStr) {
		phone.sendKeys(phoneStr);
	}

	public void click_submit_btn() {
		submit.click();
	}

	public void register(String content) {
		String[] content_arr = content.split(",");
		input_username(content_arr[0]);
		input_email(content_arr[1]);
		input_pwd(content_arr[2]);
		input_repwd(content_arr[3]);
		input_phone(content_arr[4]);
		// System.out.println("text:"+username.findElement(By.xpath("../span")).getText());
		click_submit_btn();
	}

	public void assert_result_text(String expectedResult) {
		Assert.assertEquals(expectedResult, login_success_text.getText());
	}

	public void assert_alert_text(String expectedResult) {
		Alert alert = driver.switchTo().alert();
		Assert.assertTrue(alert.getText().contains(expectedResult));
		// System.out.println(alert.getText());
		alert.accept();
	}

	public void assert_input_text(int index, String expectedResult) {
		List<WebElement> list = new ArrayList<WebElement>();
		list.add(username);
		list.add(email);
		list.add(password);
		list.add(confirm_password);
		String actual = list.get(index).findElement(By.xpath("../span")).getText();
		// System.out.println(":::::"+actual);
		Assert.assertTrue(actual.contains(expectedResult.trim()));
	}

	public void assert_all_input_text(String expectedResults) {
		String[] expectedResultArr = expectedResults.split(",");
		for (int i = 0; i < expectedResultArr.length; i++) {
			assert_input_text(i, expectedResultArr[i]);
		}
	}

}
