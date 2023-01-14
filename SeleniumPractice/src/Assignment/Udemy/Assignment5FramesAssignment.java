package Assignment.Udemy;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import BrowserConnection.Connector;

public class Assignment5FramesAssignment {

	public static void main(String[] args) {
		WebDriver driver = Connector.getChromeConnection();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		// Open URL
		driver.get("https://the-internet.herokuapp.com/");
		// open link Nested Frames
		driver.findElement(By.linkText("Nested Frames")).click();
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(0));
		// getMiddle Frame
		// driver.switchTo().frame(0);
		driver.switchTo().frame(1);
		System.out.println(driver.findElement(By.id("content")).getText());

	}

}
