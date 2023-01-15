package Assignment.Udemy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import BrowserConnection.Connector;

public class Assignment5FramesAssignmentMentor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = Connector.getChromeConnection();

		driver.get("https://the-internet.herokuapp.com/");
		driver.findElement(By.linkText("Nested Frames")).click();
		driver.switchTo().frame("frame-top");
		driver.switchTo().frame("frame-middle");

		System.out.println(driver.findElement(By.id("content")).getText());
	}

}
