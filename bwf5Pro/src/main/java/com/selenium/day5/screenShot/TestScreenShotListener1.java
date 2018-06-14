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




public class TestScreenShotListener1 extends TestListenerAdapter {
	@Override
	public void onTestFailure(ITestResult tr) {
		// TODO Auto-generated method stub
		try {
			Field field = tr.getTestClass().getRealClass().getField("driver");
			WebDriver driver = (WebDriver) field.get(tr.getInstance());
			File file=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);//也可以在RemoteWebDriver封装一下这个方法
			file.renameTo(new File("abc.png"));
			//文件名重新设置一下
			/*String className=tr.getTestClass().getName();
			String methodName=tr.getName();
			SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd_HH_mm_ss_SSS");
			String time=dateFormat.format(new Date());
			File file=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			file.renameTo(new File(className+"-"+methodName+"-"+time+".png"));*/
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
