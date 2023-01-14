package Assignment.Udemy;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import BrowserConnection.Connector;

public class Assignment4WindowHandlingAssignment {

	public static void main(String[] args) {
		WebDriver driver = Connector.getChromeConnection();
		driver.get("https://the-internet.herokuapp.com/");

		// Open Multiple Windows link

		driver.findElement(By.linkText("Multiple Windows")).click();

		driver.findElement(By.linkText("Click Here")).click();

		Set<String> windowHandles = driver.getWindowHandles();
		Iterator<String> iterator = windowHandles.iterator();
		String parentId = iterator.next();
		String childId = iterator.next();
		// Switch Child window
		driver.switchTo().window(childId);
		String windoe2Text = driver.findElement(By.cssSelector("div.example h3")).getText();
		System.out.println(windoe2Text);
		// Switch Window to Parent
		driver.switchTo().window(parentId);
		String windoe1Text = driver.findElement(By.cssSelector("div.example h3")).getText();

		System.out.println(windoe1Text);

		driver.quit();

	}

}
