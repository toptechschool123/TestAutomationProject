package selenium_lectures;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import utils.JavaScriptExecutor;

public class JsExample extends JavaScriptExecutor {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://ksrtc.in/oprs-web/");

		Thread.sleep(3000);
		WebElement dateDeparture = driver.findElement(By.id("txtJourneyDate"));
		WebElement dateReturn = driver.findElement(By.id("txtReturnJourneyDate"));

		String dateDept = "07/20/2023";
		String dateRet = "08/20/2023";
		Thread.sleep(3000);
		JavaScriptExecutor.selectCalendarDateWithJS(driver, dateDept, dateDeparture);
		JavaScriptExecutor.selectCalendarDateWithJS(driver, dateRet, dateReturn);
		Thread.sleep(3000);

		// JavascriptExecutor js = (JavascriptExecutor)driver;
		WebElement searchBus = driver
				.findElement(By.xpath("//button[@class='btn btn-primary btn-lg btn-block btn-booking']"));
		JavascriptExecutor javascript = (JavascriptExecutor) driver;
		javascript.executeScript("arguments[0].click();", searchBus);

		Thread.sleep(3000);
		// searchBus.click();
		// JavaScriptExecutor.clickElementWithJS(searchBus, driver);

		driver.switchTo().alert().accept();
		Thread.sleep(3000);
		WebElement crm = driver.findElement(By.xpath("//p[text()='CRM']"));
		crm.click();
		// JavaScriptExecutor.clickElementWithJS(crm, driver);

		Set<String> WindowsHandles = driver.getWindowHandles();

		// Iterator will iterate through the SET to get next index Iterator<String>
		Iterator<String> it = WindowsHandles.iterator();

		String parentWindow = it.next();
		String childwindow = it.next();

		driver.switchTo().window(childwindow);

		WebElement login = driver.findElement(By.xpath("/html/body/header/div/nav/b[1]/a/b"));
		// login.click();

		javascript.executeScript("arguments[0].click();", login);
		
		JavaScriptExecutor.getTitle(driver);
		
		
		
		driver.close();

	}

}
