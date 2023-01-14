package Practice;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import BrowserConnection.Connector;

public class FillPracticePage {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = Connector.getChromeConnection();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
		// driver.manage().window().maximize();
		// Radio Button Example click on radio 2
		driver.findElement(
				By.xpath("//input[@value='radio2' and @name='radioButton' and @class='radioButton' and @type='radio']"))
				.click();

		// Drop-down Example
		Select dropOpt = new Select(driver.findElement(By.id("dropdown-class-example")));
		dropOpt.selectByVisibleText("Option2");

		// Check-box Example
		driver.findElement(By.id("checkBoxOption3")).click();
		driver.findElement(By.xpath("//input[@value='option2' and @name='checkBoxOption2']")).click();
		driver.findElement(By.cssSelector("#checkBoxOption1")).click();

		// Switch To Alert Example
		driver.findElement(By.id("name")).sendKeys(" Rahul ");
		driver.findElement(By.id("alertbtn")).click();
		System.out.println(driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("name")));
		driver.findElement(By.id("name")).sendKeys(" Sharma ");
		driver.findElement(By.id("confirmbtn")).click();
		System.out.println(driver.switchTo().alert().getText());
		driver.switchTo().alert().dismiss();

		
		System.out.println("****End****");

		// driver.close();

	}

}
