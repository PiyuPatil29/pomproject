package com.testingshastra.tests;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.testingshastra.keywords.Const;
import com.testingshastra.keywords.Keyword;
import com.testingshastra.utilities.Propertiesfile;

public class HomePageSmokeTest {
	@Test
	public void verifyAll() {
		Keyword.openBrowser("Chrome");
		Keyword.openURL("http://www.testingshastra.com/");
		// Keyword.clickOnElement("XPATH", "//a[contains(text(),'Home')]");
		Keyword.clickOnElement("XPATH", "//a[@class='sf-with-ul']");
		String[] parts = Propertiesfile.getLocator("home.sunNavItem");

	}

	@Test(enabled =false)
	public void verifyMenuItems() {
		String[] expectedsubItems = { "HOME", "COURSES", "ASSIGNMENTS", "CONTACT US", "DOWNLOADS" };
		List<WebElement> subItems = (List<WebElement>) Const.driver.findElements(By.cssSelector("#primary-menu>li"));
		ArrayList<String> actualsubitem = new ArrayList<String>();
		Iterator<WebElement> itr = subItems.iterator();
		while (itr.hasNext()) {
			actualsubitem.add(itr.next().getText());
		}
		boolean isEqual = actualsubitem.containsAll(Arrays.asList(expectedsubItems));
		Assert.assertTrue(isEqual);

	}
}
