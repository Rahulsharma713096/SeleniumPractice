package Practice;

import org.openqa.selenium.WebDriver;

import BrowserConnection.Connector;

public class FillPracticePage {

	public static void main(String[] args) {
		WebDriver driver = Connector.getChromeConnection();
		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
	}

}
