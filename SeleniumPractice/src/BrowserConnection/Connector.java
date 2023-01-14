package BrowserConnection;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Connector {
	public static WebDriver getChromeConnection() {
		// This is used for Selenium version 4.7.2 or more

		WebDriver driver = new ChromeDriver();

		return driver;
	}
	public static WebDriver getEdgeConnection() {
		// This is used for Selenium version 4.7.2 or more
		WebDriver d = new EdgeDriver();

		return d;
	}
}
