package com.RSJald.GoogleSearchTest;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;

import ScreenShotAndLogs.LogsText;

//Incomplete  Handling not done yet
public class SearchFamousPlaces {

	public static void main(String[] args) {
		ChromeDriver drv = new ChromeDriver();
		drv.get("https://www.google.co.in/");
		try {
			new SearchFamousPlaces().getFamousPlaces(drv, 28, 77);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		drv.quit();
	}

	public void getFamousPlaces(ChromeDriver driver, int latitude, int longitude) throws MalformedURLException {
		String logs = "The urls \n";
		DevTools devTools = driver.getDevTools();
		devTools.createSession();
		Map<String, Object> cord = new HashMap<String, Object>();
		cord.put("latitude", latitude);
		cord.put("longitude", longitude);
		cord.put("accuracy", 1);
		driver.executeCdpCommand("Emulation.setGeolocationOverride", cord);
		driver.navigate().to(new URL("https://www.google.co.in/"));

		driver.findElement(By.name("q")).sendKeys("Famous Places Near me", Keys.ENTER);

		List<WebElement> findElements = driver.findElements(By.tagName("a"));
		for (WebElement we : findElements) {
			if (we.getText().contains("https"))
				logs += "\n" + we.getAttribute("href");

		}

		LogsText.CreateLogFile(logs);
		String log2 = "The famous Places \n";
		List<WebElement> findElements2 = driver.findElements(By.className("OSrXXb"));

		for (WebElement we : findElements2) {
			log2 += "\n" + we.getText();

		}
		LogsText.CreateLogFile(log2);
		driver.navigate().back();

	}
}
