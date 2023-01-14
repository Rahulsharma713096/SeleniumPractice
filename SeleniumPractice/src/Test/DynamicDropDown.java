package Test;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DynamicDropDown {
	public static void main(String[] args) {
		// Chrome
		ChromeDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
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

	}
}
