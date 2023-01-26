package ScreenShotAndLogs;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;

public class ScreenShots {

	public static void getScreenShot(WebDriver driver) {
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String dest = PathName.getPath() + ".png";
		try {
			FileUtils.copyFile(src, new File(dest));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void getWebElemntScreenShot(WebElement element) {
		// Works only in Selenium version4 and above.
		File src = element.getScreenshotAs(OutputType.FILE);
		String dest = PathName.getPath() + "-WebElement.png";
		try {
			FileUtils.copyFile(src, new File(dest));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void getWebElemntScreenShot(List<WebElement> findElements) {
		// Works only in Selenium version4 and above.

		int count = 1;
		for (WebElement element : findElements) {
			try {
				File src = element.getScreenshotAs(OutputType.FILE);
				String dest = PathName.getPath() + "-" + (count++) + "WebElement.png";
				try {
					FileUtils.copyFile(src, new File(dest));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} catch (WebDriverException ex) {
				ex.printStackTrace();
			}
		}

	}
}
