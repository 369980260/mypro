package com.selenium.day5.log4j;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TestLog4j {
	private static final Logger logger = LogManager.getLogger();

	public static void main(String[] args) {
		//报错提示信息
//		logger.info("helloword");//logging only errors to the console),errors级别比info要高
		//改成这样就可以打印出来了
		logger.error("helloword");//logging only errors to the console),errors级别比info要高
		//有了日志文件log4j2.xml，存放在/src/main/resources下， 就可以写成info,不需要是error了
	}

}
