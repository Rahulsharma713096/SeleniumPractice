package Practice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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

		// Suggestion Class Example: get Country
		driver.findElement(By.id("autocomplete")).sendKeys("ind");

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ui-menu-item-wrapper']")));

		List<WebElement> AllCountry = driver.findElements(By.xpath("//div[@class='ui-menu-item-wrapper']"));
		String s = "India";
		for (WebElement Country : AllCountry) {
			if (Country.getText().equals(s)) {
				Country.click();
				break;
			}

		}

		
		System.out.println("****End****  \n Test run fine");

		driver.close();

	}

}
