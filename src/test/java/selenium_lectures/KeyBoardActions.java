package selenium_lectures;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class KeyBoardActions {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		driver.get("https://extendsclass.com/text-compare.html");
		WebElement sourcetext = driver.findElement(By.xpath("//div[@id='dropZone']"));
		
		Actions action4 = new Actions(driver);


		action4.keyDown(sourcetext,Keys.CONTROL).sendKeys("a").sendKeys("c").build().perform();
		Thread.sleep(2000);
		
		WebElement droptext = driver.findElement(By.xpath("//div[@class='CodeMirror cm-s-default']"));

		action4.keyDown(droptext, Keys.CONTROL).sendKeys("a").sendKeys("v").build().perform();
		Thread.sleep(2000);
	
	

		driver.close();

	}

}
