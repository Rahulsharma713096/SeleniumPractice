package com.RSJald.GoogleSearchTest;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import ScreenShotAndLogs.LogsText;
import ScreenShotAndLogs.ScreenShots;
import driverconnection.ConnectionBrowser;

/**
 * Unit test for simple App.
 */
public class AppTest {
	@Test
	public void searchResult() {
		WebDriver driver = new GoogleSearch().getSearch("Learn Selenium");
		ScreenShots.getScreenShot(driver);
		String value = new GoogleSearch().getAllWebLink(driver);
		LogsText.CreateLogFile(value);
		new ConnectionBrowser().quitDriver(driver);

	}

	@Test
	public void searchResult1() {
		WebDriver driver = new GoogleSearch().getSearch("Learn Java");
		ScreenShots.getScreenShot(driver);
		String value = new GoogleSearch().getAllWebLink(driver);
		LogsText.CreateLogFile(value);
		new ConnectionBrowser().quitDriver(driver);

	}

	@Test
	public void searchResult2() {
		WebDriver driver = new GoogleSearch().getSearch("Learn TestNG");
		ScreenShots.getScreenShot(driver);
		String value = new GoogleSearch().getAllWebLink(driver);
		LogsText.CreateLogFile(value);
		new ConnectionBrowser().quitDriver(driver);
	}
}
