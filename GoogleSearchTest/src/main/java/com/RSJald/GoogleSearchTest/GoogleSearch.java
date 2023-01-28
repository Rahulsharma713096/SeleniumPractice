package com.RSJald.GoogleSearchTest;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import driverconnection.ConnectionBrowser;

public class GoogleSearch {
	public WebDriver getSearch(String value) {
		System.out.println("Search value ="+value);
		WebDriver driver = null;
		try {
			driver = new ConnectionBrowser().getConnection();
		} catch (IOException e) {
			driver = null;
			e.printStackTrace();
		}
		// Enter search box value
		driver.findElement(By.cssSelector(
				"body > div.L3eUgb > div.o3j99.ikrT4e.om7nvf > form > div:nth-child(1) > div.A8SBwf > div.RNNXgb > div > div.a4bIc > input"))
				.sendKeys(value);
		// Click Enter button from keyboard to search
		WebElement fElemnet = driver.findElement(By.cssSelector(
				"body > div.L3eUgb > div.o3j99.ikrT4e.om7nvf > form > div:nth-child(1) > div.A8SBwf > div.RNNXgb > div > div.a4bIc > input"));
		new Actions(driver).moveToElement(fElemnet).keyDown(Keys.ENTER).build().perform();

		return driver;

	}

	public String getAllWebLink(WebDriver driver) {
		String data = "All link Avaliable on WebPage \n";
		List<WebElement> listOfSearch = driver.findElements(By.tagName("a"));
		List<String> collect = listOfSearch.stream().map(WebElement::getText).collect(Collectors.toList());
		data += String.join("\n >", collect);
		return data;
	}

}
