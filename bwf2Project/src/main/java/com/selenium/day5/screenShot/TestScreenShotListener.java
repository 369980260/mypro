package com.selenium.day5.screenShot;

import java.io.File;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.bcel.generic.NEW;
import org.apache.commons.collections4.bag.TreeBag;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import org.testng.annotations.Test;

import com.selenium.day4.utils.WrappedRemoteWebDriver;



public class TestScreenShotListener extends TestListenerAdapter {
	@Override
	public void onTestFailure(ITestResult tr) {
		// TODO Auto-generated method stub
		try {
			Field field = tr.getTestClass().getRealClass().getField("driver");
			WrappedRemoteWebDriver driver = (WrappedRemoteWebDriver) field.get(tr.getInstance());
			String className=tr.getTestClass().getName();
			String methodName=tr.getName();
			SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd_HH_mm_ss_SSS");
			String time=dateFormat.format(new Date());
			driver.takeScreenShot(className+"-"+methodName+"-"+time+".png");
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		super.onTestFailure(tr);
	}
}
