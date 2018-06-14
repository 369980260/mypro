package com.selenium.day4.utils;

import java.io.File;
import java.io.IOException;
import java.sql.Driver;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriverService;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.GeckoDriverService;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.service.DriverService;

public class DriverUtils {
	private static DriverService service;
	private static String browser = null;
	private static WebDriver driver = null;
	public static void initService() {
//		browser = System.getProperty("browser.type", "firefox");
		 Config config=new Config("config.properties");
		 browser=config.getConfig("browser.type");
		 String driverFile=config.getConfig("driver");
		if ("firefox".equalsIgnoreCase(browser)) {
			service = new GeckoDriverService.Builder().usingDriverExecutable(new File(driverFile))
					.usingAnyFreePort().build();// c:/driver/geckodriver.exe
		} else if ("chrome".equalsIgnoreCase(browser)) {
			service = new ChromeDriverService.Builder().usingDriverExecutable(new File(driverFile))// c:/driver/chromedriver.exe
					.usingAnyFreePort().build();
		} else if ("ie".equalsIgnoreCase(browser)) {
			service = new InternetExplorerDriverService.Builder()
					.usingDriverExecutable(new File(driverFile))// c:/driver/IEDriverServer.exe
					.usingAnyFreePort().build();
		} else {
			throw new RuntimeException("未支持浏览器的类型！");
		}
		try {
			service.start();

		} catch (IOException e) {
			// TODO Auto-generated catch block

			e.printStackTrace();
		}
	}

	public static WebDriver getDriver() {
		if ("firefox".equalsIgnoreCase(browser)) {
			driver = new RemoteWebDriver(service.getUrl(), DesiredCapabilities.firefox());
		} else if ("chrome".equalsIgnoreCase(browser)) {
			driver = new RemoteWebDriver(service.getUrl(), DesiredCapabilities.chrome());
		} else if ("ie".equalsIgnoreCase(browser)) {
			driver = new RemoteWebDriver(service.getUrl(), DesiredCapabilities.internetExplorer());
		}
		return driver;
	}

	public static void quitDriver() {
		driver.quit();
	}

	public static void stopService() {
		service.stop();
	}

}
