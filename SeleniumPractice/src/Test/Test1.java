package Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import BrowserConnection.Connector;
import ScreenShotAndLogs.LogsText;
import ScreenShotAndLogs.ScreenShots;

public class Test1 {
	@org.testng.annotations.Test
	public static void Test() {
		// TODO Auto-generated method stub
		WebDriver driver = Connector.getChromeConnection();

		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
		ScreenShots.getScreenShot(driver);
		WebElement e1 = driver.findElement(By.id("checkBoxOption1"));
		ScreenShots.getWebElemntScreenShot(e1);
		e1.click();
		ScreenShots.getWebElemntScreenShot(e1);
		LogsText.CreateLogFile("Ist Logs \n" + e1.getText() + "\n   Created by : Rahul Sharma");

		driver.quit();
	}

}
