package com.selenium.day4.utils;

import java.io.File;
import java.lang.reflect.Field;
import java.net.URL;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
/*
 * 重新包装RemoteWebDriver，继承RemoteWebDriver类重写findElement，findElements查找元素方法，实现元素查找时的日志记录
 * 
 */

public class WrappedRemoteWebDriver extends RemoteWebDriver {
	private static Logger logger = LogManager.getLogger();

	public WrappedRemoteWebDriver(URL remoteAddress, Capabilities capabilities) {
		super(remoteAddress, capabilities);
	}

	@Override
	protected WebElement findElement(String by, String using) {
		// TODO Auto-generated method stub
		WebElement element = null;
		try {
			element = super.findElement(by, using);
			logger.info("ͨ通过" + by + "方法找到" + using +"元素,已找到");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.info("ͨ通过"  + by + "方法找到" + using + "元素时发生异常，原因："  + e.getMessage());

			// e.printStackTrace();
		}
		return element;
	}

	@Override
	protected List<WebElement> findElements(String by, String using) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		List<WebElement> elements = null;
		try {
			elements = super.findElements(by, using);
			logger.info("ͨ通过" + by + "方法找到" + using + "元素,已找到" + elements.size() + "个");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.info("ͨ通过" + by + "方法找到" + using + "元素时发生异常，原因：" + e.getMessage());

		}
		return elements;
	}

	public void takeScreenShot(String fileName) {
		File screenShot = ((TakesScreenshot) this).getScreenshotAs(OutputType.FILE);
		File shotDir = new File("screenshots");
		if (!shotDir.exists() || !shotDir.isDirectory()) {
			logger.info("screenshots目录不存在，创建该目录！ ");
			shotDir.mkdirs();
		}
		File file = new File(shotDir, fileName);
		screenShot.renameTo(file);
		logger.info("截屏保存成功，保存在" + file.getAbsolutePath());
	}

}
