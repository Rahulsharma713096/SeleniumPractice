package driverconnection;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class ConnectionBrowser {

	public WebDriver getConnection() throws IOException {
		WebDriver driver;
		FileReader reader = new FileReader(
				System.getProperty("user.dir") + "\\src\\main\\java\\configFiles\\cofig.properties");
		Properties p = new Properties();
		p.load(reader);
		String browser = p.getProperty("browser");
		switch (browser) {
		case "chrome":
			driver = new ChromeDriver();
			break;
		case "edge":
			driver = new EdgeDriver();
			break;
		case "firefox":
			driver = new FirefoxDriver();
			break;
		case "ie":
			driver = new InternetExplorerDriver();
			break;
		default:
			driver = new ChromeDriver();

		}
		System.out.println(p.getProperty("browser"));
		System.out.println(p.getProperty("url"));
		driver.manage().window().maximize();
		driver.get(p.getProperty("url"));
		return driver;

	}

	public void closeDriver(WebDriver driver) {
		driver.close();
	}

	public void quitDriver(WebDriver driver) {
		driver.quit();
	}

}
