package Assignment.Udemy;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Assignment7WebTablesAssignment {

	public static void Assignment7WebTables(WebDriver driver) {
		// TODO Auto-generated method stub
		List<WebElement> list = driver.findElements(By.cssSelector(".table-display tr"));
		int countRow = list.size();
		// Print the rows present on table with Heading rows also
		System.out.println(countRow);
		List<WebElement> listCol = driver.findElements(By.cssSelector(".table-display tr:nth-child(1) th"));
		int countColumn = listCol.size();
		// Print the Column Present in table
		System.out.println(countColumn);
		// Print second row
		for (int i = 0; i < countRow; i++) {
			if (i == 2) {
				System.out.println(list.get(i).getText());
			}
		}
		return;
	}
}
