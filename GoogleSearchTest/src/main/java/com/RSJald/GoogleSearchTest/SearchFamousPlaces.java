package com.RSJald.GoogleSearchTest;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
//Incomplete  Handling not done yet
public class SearchFamousPlaces {
//Search Famous Places for any Location with the help of ChrmoneDev Tools
	public void getLL(ChromeDriver driver, String place) {
		WebDriverWait wait = new WebDriverWait((WebDriver) driver, Duration.ofSeconds(50));
		try {
			driver.navigate().to(new URL("https://earth.google.com/web/"));
			wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("#icon"))));
			driver.findElement(By.cssSelector("#icon")).click();
			driver.findElement(By.id("omnibox-input")).sendKeys(place, Keys.ENTER);

			wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("pointer-coordinates"))));
			String cord = driver.findElement(By.id("pointer-coordinates")).getText();
			System.out.println(cord);
			driver.navigate().back();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		ChromeDriver drv = new ChromeDriver();
		drv.get("https://www.google.co.in/");
		new SearchFamousPlaces().getLL(drv, "NewYork");
		System.out.println(drv.getTitle());
		drv.quit();
	}

	public void getFamousPlaces(ChromeDriver driver, int latitude, int longitude) throws MalformedURLException {
		DevTools devTools = driver.getDevTools();
		devTools.createSession();
		Map<String, Object> cord = new HashMap<String, Object>();
		cord.put("latitude", latitude);
		cord.put("longitude", longitude);
		cord.put("accuracy", 85);
		driver.executeCdpCommand("Emulation.setGeolocationOverride", cord);
		driver.navigate().to(new URL("https://www.google.co.in/"));

		driver.findElement(By.name("q")).sendKeys("Loaction", Keys.ENTER);
		driver.findElements(By.cssSelector(".LGC")).get(0).click();

		driver.navigate().back();

	}
}
