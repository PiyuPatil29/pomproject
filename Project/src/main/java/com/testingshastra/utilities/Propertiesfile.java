package com.testingshastra.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import com.testingshastra.keywords.Const;

public class Propertiesfile {
	public static String getProperty(String key) {
		String value = null;
		String path=System.getProperty("user.dir");
		System.out.println(path);
		try {
			Const.fis = new FileInputStream(path+"src\\main\\resources\\OR.properties");
			Const.prop = new Properties();
			Const.prop.load(Const.fis);
			value = Const.prop.getProperty(key);
		} catch (FileNotFoundException e) {
			System.out.println("unable to open ObjectRepository");
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return value;
	}
	public static String[] getLocator(String key) {
		String[] values= null;
		try {
			Const.fis=new FileInputStream("src\\main\\resources\\OR.properties");
			Const.prop=new Properties();
			Const.prop.load(Const.fis);
			String part = Const.prop.getProperty(key);
			values = part.split("##");
			System.out.println("Locator types " + values[0]);
			System.out.println("Locator value " + values[1]);
		} catch (IOException e) {
			System.out.println("unable to open ObjectRepository");
			e.printStackTrace();
		}
		return values;
	}
	public static void main(String[] args) {
		getLocator("home.sunNavItem");
	}
}



