package Assignment.Udemy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Assignment2_other {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriver d = new EdgeDriver();
		d.get("https://www.rahulshettyacademy.com/angularpractice/");
		d.findElement(By.xpath("//input [@class='form-control ng-untouched ng-pristine ng-invalid']")).sendKeys("RAJ");
		d.findElement(By.xpath("//input [@class='form-control ng-untouched ng-pristine ng-invalid']"))
				.sendKeys("rs@rs.com");
		d.findElement(By.xpath("//input [@class='form-control' and @type='password' and @placeholder='Password']"))
				.sendKeys("asdsasdd");

		d.findElement(By.xpath("//input[@class='form-check-input' and @id='exampleCheck1' and @type='checkbox']"))
				.click();

		WebElement asw = d.findElement(By.xpath("//select[@class='form-control' and @id='exampleFormControlSelect1']"));
		Select drpdn = new Select(asw);
		drpdn.selectByIndex(1);

		d.findElement(By.xpath(
				"//input [@class='form-check-input'  and @id='inlineRadio1' and  @name='inlineRadioOptions' and  @type='radio' and  @value='option1']"))
				.click();

		d.findElement(By.xpath(
				"//input [@class='form-control' and @max='3000-12-31' and @min='1000-01-01' and @name='bday' and @type='date']"))
				.sendKeys("12-12-2022");
		d.findElement(By.xpath("//input[@class='btn btn-success' and @type='submit' and @value='Submit']")).click();
		String msg = new String(
				d.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible']")).getText());

		Assert.assertTrue(msg.contains("Success"));
		Thread.sleep(5000);
		d.quit();
		System.out.println("========********************=========End===================***************============");
	}

}
