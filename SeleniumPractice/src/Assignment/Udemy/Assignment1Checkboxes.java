package Assignment.Udemy;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;

public class Assignment1Checkboxes {
	public static void main(String[] args) {

		WebDriver driverE = new EdgeDriver();
		driverE.get("https://rahulshettyacademy.com/AutomationPractice/");
		/*
		 * 1. Check the first check-box and verify if it is successfully checked and
		 * un-check it again to verify it again to verify if it is successfully
		 * un-checked.
		 * 
		 */
		WebElement checkBoxOption1 = driverE.findElement(By.xpath("//input[@name='checkBoxOption1']"));
		checkBoxOption1.click();
		Assert.assertTrue(checkBoxOption1.isSelected());
		checkBoxOption1.click();
		Assert.assertFalse(checkBoxOption1.isSelected());
		
		/*
		 *2. How to get the count of number of check boxes present in the pages. 
		 */
		
		List<WebElement> findElements = driverE.findElements(By.xpath("//input [@type='checkbox']"));

		System.out.println(findElements.size());
		
		System.out.println("End");

		driverE.quit();

	}
}
