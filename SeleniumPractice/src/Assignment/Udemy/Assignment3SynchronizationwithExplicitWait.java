package Assignment.Udemy;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import BrowserConnection.Connector;

public class Assignment3SynchronizationwithExplicitWait {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver edgeConnection = Connector.getEdgeConnection();

		// driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		WebDriverWait wait = new WebDriverWait(edgeConnection, Duration.ofSeconds(10));

		edgeConnection.get("https://rahulshettyacademy.com/loginpagePractise/");

		// Fill user name
		edgeConnection.findElement(By.id("username")).sendKeys("rahulshettyacademy");

		// Fill Password
		edgeConnection.findElement(By.id("password")).sendKeys("learning");

		// Select User Radio button
		edgeConnection.findElement(By.xpath("//label[2]/span[2]")).click();
		// click OK on Pop-up
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("okayBtn")));
		WebElement alertbtn = edgeConnection.findElement(By.id("okayBtn"));
		alertbtn.click();
		// Drop-down select Consultant
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//select [@class='form-control' and @data-style='btn-info']")));
		Select dpwn = new Select(
				edgeConnection.findElement(By.xpath("//select [@class='form-control' and @data-style='btn-info']")));
		dpwn.selectByValue("consult");

		// Check terms
		edgeConnection.findElement(By.id("terms")).click();
		// Click on Sign In button
		edgeConnection.findElement(By.id("signInBtn")).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button.btn-info")));
		List<WebElement> AllAddBtn = edgeConnection.findElements(By.cssSelector("button.btn-info"));
		for (WebElement AddBtn : AllAddBtn) {
			AddBtn.click();
		}

		edgeConnection.findElement(By.cssSelector("a[class='nav-link btn btn-primary']")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td /h3")));
		Assert.assertEquals(edgeConnection.findElement(By.xpath("//td /h3")).getText(), "Total");
		edgeConnection.close();
		System.out.println("**END******");
	}

}
