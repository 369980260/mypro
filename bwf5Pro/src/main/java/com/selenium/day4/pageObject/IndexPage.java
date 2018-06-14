package com.selenium.day4.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class IndexPage {
	@FindBy(partialLinkText = "请登录")
	private WebElement loginLink;
	@FindBy(partialLinkText= "免费注册")
	private WebElement regLink;
	public IndexPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	public void click_login_link() {
		loginLink.click();
	}
	public void click_reg_link() {
		regLink.click();
	}
}
