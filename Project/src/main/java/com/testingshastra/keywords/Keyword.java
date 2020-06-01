package com.testingshastra.keywords;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Keyword {
	public static void openBrowser(String browsername) {
		switch (browsername) {
		case "Chrome":
			WebDriverManager.chromedriver().setup();
			Const.driver = new ChromeDriver();
		}
	}

	public static void openURL(String url) {
		Const.driver.get(url);
	}

	public static WebElement getWebElement(String locatortype, String locatorvalue) {
		WebElement element = null;
		switch (locatortype) {
		case "XPATH":
			element=Const.driver.findElement(By.xpath(locatorvalue));
			break;
		case "CSS":
			element=Const.driver.findElement(By.cssSelector(locatorvalue));
			break;
		case "PARTIAL_LINKTEXT":
			element=Const.driver.findElement(By.partialLinkText(locatorvalue));
			break;
		case "ID":
			element=Const.driver.findElement(By.id(locatorvalue));
			break;
		case "CLASSNAME":
			element=Const.driver.findElement(By.className(locatorvalue));
			break;
		case "LINK_TEXT":
			element=Const.driver.findElement(By.linkText(locatorvalue));
		default:
			System.err.println("Invalid locatorType" + locatortype
					+ ("Expected CSS,XPATH,PARTIAL_LINKTEXT,LINKTEXT,CLASS_NAME,ID"));
			break;
		}
		return element;
	}

	public static void clickOnElement(String locatortype, String locatorvalue) {
		getWebElement(locatortype, locatorvalue).click();
	}

	public static void quit() {
		Const.driver.quit();
	}

	public static void closeallBrowsers() {
		Const.driver.close();
	}

}
