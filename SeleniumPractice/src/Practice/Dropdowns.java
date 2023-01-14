package Practice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Dropdowns {

	public static void main(String[] args) {
		WebDriver chromeDriver = new ChromeDriver();

		chromeDriver.get("https://rahulshettyacademy.com/AutomationPractice/");
		chromeDriver.manage().window().maximize();
        WebElement dropdown=chromeDriver.findElement(By.id("dropdown-class-example"));
     Select selectdrop=new Select(dropdown);
     List<WebElement> allSelectedOptions = selectdrop.getOptions();
        for(WebElement aSP:allSelectedOptions) {
        	System.out.println(aSP.getText());
        }
        selectdrop.selectByValue("option2");
      
        
        
		System.out.println("End");
		chromeDriver.quit();
	}
}
