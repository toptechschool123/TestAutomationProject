package selenium_lectures;

import java.io.File;
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

public class Tab_Handling {

	public static void main(String[] args) {
WebDriverManager.chromedriver().setup();

		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		// driver.manage().deleteAllCookies();

		driver.get("https://xndev.com/display-image/");
		
		WebElement uploadFile = driver.findElement(By.xpath("//*[@id=\"post-2554\"]/div/input"));

		String filePath = "C://Users//T540p//Desktop//UpdatedBrochure.jpeg";
	

		// upload the file 
		uploadFile.sendKeys(filePath);
		
		
	
		
		 driver.switchTo().newWindow(WindowType.TAB);
		 
		 driver.get("https://google.com");
		 driver.switchTo().newWindow(WindowType.TAB);
		 
		 
		 driver.get("https://facebook.com");
		 Set <String> handles =driver.getWindowHandles();
			Iterator<String> it = handles.iterator();
			String parent_tab = it.next();
			String child_tab1 =it.next();
			String child_tab2 =it.next();
		
		// driver.switchTo().window(child_window2);
		// driver.switchTo().window(child_tab2);
		 driver.switchTo().window(parent_tab);
		 

	}

}
