package Assignment.Udemy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Assignment2 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();

		driver.get("https://www.rahulshettyacademy.com/angularpractice/");

		// Enter Name

		driver.findElement(By.cssSelector("input[name='name']")).sendKeys("Rahul sharma");
		// Email

		driver.findElement(By.cssSelector("input[name='email']")).sendKeys("Rahul@sharma.com");

		// Password

		driver.findElement(By.id("exampleInputPassword1")).sendKeys("Rahul_you_are_grate");

		// Check button

		driver.findElement(By.id("exampleCheck1")).click();

		// Select from drop-down
		WebElement ddm = driver.findElement(By.id("exampleFormControlSelect1"));
		Select dds = new Select(ddm);
		dds.selectByIndex(1);
		// Student radio button

		driver.findElement(By.id("inlineRadio1")).click();

		// Date of birth

		driver.findElement(By.name("bday")).sendKeys("01-01-2001");

		// Submit button

		driver.findElement(By.cssSelector("input[class$='btn-success']")).click();
		String mes=driver.findElement(By.xpath("//div [@class='alert alert-success alert-dismissible']")).getText();
		if(mes.contains("Success")) Assert.assertTrue(true);
		else Assert.assertTrue(true);
		Thread.sleep(5000);

		driver.quit();
		System.out.println("**END**");

	}

}
