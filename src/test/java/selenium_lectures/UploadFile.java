package selenium_lectures;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class UploadFile extends ScreenShots{

	public static void main(String[] args) throws IOException {

		WebDriverManager.chromedriver().setup();

		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		// driver.manage().deleteAllCookies();

		driver.get("https://xndev.com/display-image/");
	
		
		WebElement uploadFile = driver.findElement(By.xpath("//input[@type='file'] "));
		String filePath = "C://Users//T540p//Desktop//UpdatedBrochure.jpeg";
	
		ScreenShots.takeScreenShot(driver);
		
	   

		uploadFile.sendKeys(filePath);
		
		

		
	
		 

	}

}
