package com.selenium.day5.reRunTest;

import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;


public class ReRunListener implements IInvokedMethodListener {

	@Override
	public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {
		// TODO Auto-generated method stub

	}

	@Override
	public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
		// TODO Auto-generated method stub
		IRetryAnalyzer retry=method.getTestMethod().getRetryAnalyzer();
		//如果设置 过重跑分析器的话，就不能再设置重跑分析器，否则每次会清零，会无限止的运行下去
		if(retry==null) {
		method.getTestMethod().setRetryAnalyzer(new RetryAnalysis());
		}
	}

}
