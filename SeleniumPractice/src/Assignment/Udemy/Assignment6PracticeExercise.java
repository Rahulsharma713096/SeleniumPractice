package Assignment.Udemy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import BrowserConnection.Connector;

public class Assignment6PracticeExercise {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = Connector.getChromeConnection();

		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");

		Assignment6Practice(driver);

		System.out.println("*******END*******");
		driver.close();
	}

	private static void Assignment6Practice(WebDriver driver) {
		// TODO Auto-generated method stub
		// Check the box and select the
		WebElement element = driver.findElement(By.cssSelector("label[for='benz']"));
		element.findElement(By.id("checkBoxOption2")).click();
		String text = element.getText();
		// select the drop down from label
		Select dpdwn = new Select(driver.findElement(By.id("dropdown-class-example")));
		dpdwn.selectByVisibleText(text);
		// Enter the label text into text-box
		driver.findElement(By.id("name")).sendKeys(text);
		// click on alert button
		driver.findElement(By.id("alertbtn")).click();
		// Verify the alert button text
		String excepted = driver.switchTo().alert().getText().split(",")[0].split(" ")[1].trim();
		Assert.assertEquals(excepted, text);

		// Click on alert button OK
		driver.switchTo().alert().accept();
		return;

	}

}
