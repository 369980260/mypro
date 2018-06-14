package com.selenium.day5.reRunTest;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalysis implements IRetryAnalyzer {

	private static final int MAX=1;//最多重跑次数 2次，因为从0开始 
	private int count=0;//计数器从0开始 

	@Override
	public boolean retry(ITestResult result) {
		// TODO Auto-generated method stub
		if(count<MAX) {
			count++;
			return true;//return true表示要重跑的 false表示重跑停止
		}else {
			return false;
		}
		
	}
}
