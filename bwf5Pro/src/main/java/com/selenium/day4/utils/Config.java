package com.selenium.day4.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;



public class Config {
	private Properties pro;	

	public Config(String fileName) {
		pro=new Properties();
		InputStream in=this.getClass().getClassLoader().getResourceAsStream(fileName);
	    try {
			pro.load(in);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	   
	}
    public String getConfig(String key) {
    	return pro.getProperty(key);
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
          Config config=new Config("config.properties");
          System.out.println(config.getConfig("browser.type"));
	}

}
