package Test;

import org.openqa.selenium.WebDriver;

import Assignment.Udemy.Assignment7WebTablesAssignment;
import BrowserConnection.Connector;

public class Test1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = Connector.getChromeConnection();
		
		//driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
		
		//driver.get("http://qaclickacademy.com/practice.php");
		
		
		
		driver.close();
	}

}
