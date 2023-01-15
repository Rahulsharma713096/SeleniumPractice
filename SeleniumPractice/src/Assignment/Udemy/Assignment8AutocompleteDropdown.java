package Assignment.Udemy;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import BrowserConnection.Connector;

public class Assignment8AutocompleteDropdown {
	public static void main(String[] args) {
		WebDriver driver = Connector.getChromeConnection();
		driver.get("http://qaclickacademy.com/practice.php");
		Assignment8AutocompleteDropdownMethod(driver);
driver.close();
	}

	public static void Assignment8AutocompleteDropdownMethod(WebDriver driver) {
		// TODO Auto-generated method stub
		// Suggestion Class Example: get Country
		driver.findElement(By.id("autocomplete")).sendKeys("ind");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ui-menu-item-wrapper']")));

		List<WebElement> AllCountry = driver.findElements(By.xpath("//div[@class='ui-menu-item-wrapper']"));
		String s = "India";
		for (WebElement Country : AllCountry) {
			if (Country.getText().equals(s)) {
				Country.click();
				break;
			}

		}
		return;

	}

}
