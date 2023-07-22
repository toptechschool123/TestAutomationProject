package selenium_lectures;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ScreenShots {

	public static void takeScreenShot(WebDriver driver) throws IOException  {

		
		
		Date currentDate = new Date();
		String screenshotFileName =currentDate.toString().replace(" ", " -").replace(":", "-");
		
		File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(srcFile,new File(".//screenshots//" +screenshotFileName +".png"));

	//	File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		
	//	FileUtils.copyFile(screenshotFile,new File(".//screenshot/screen.png"));
	}

}
