import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.support.ui.Select;
//import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.Alert;
//import java.awt.AWTException;	
//import java.util.concurrent.TimeUnit;
//import java.awt.Robot;	
//import java.awt.event.KeyEvent;
import java.time.Duration;
//import java.util.*;
//import org.openqa.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseTest {
	public static WebDriver driver = new ChromeDriver();
	 static WebDriverWait wait = new WebDriverWait(driver,Duration.ofMillis(200));

	BaseTest(WebDriver driver){
		this.driver = driver;
	}
	
	public static void openFirebaseApp() throws InterruptedException {
		 driver.manage().window().maximize();
		 driver.get("https://demoqa.com");
		 WebElement emailid = driver.findElement(By.id("email_field"));
		 wait.until(ExpectedConditions.elementToBeClickable(By.id("email_field")));
		 emailid.clear();
	     emailid.sendKeys("");
	     
	     WebElement password = driver.findElement(By.id("password_field"));
	     password.clear();
	     password.sendKeys("");
	     
	     WebElement Login = driver.findElement(By.xpath("//button[text()='Login to Account']"));
	     Login.click();
	     
	     wait.until(ExpectedConditions.titleContains("Selenium"));
	     System.out.println("Page title is: " + driver.getTitle());
	     if(driver.getTitle()=="Selenium") {
	        System.out.println("Landed on Firebase Application Landing page.");
	     }
	}
	
	public static void quitBrowser() {
		driver.quit();
	}
	
	public static void enterText(WebElement element, String text) {
		if(element.isDisplayed() && text!=null) {
			element.clear();
			element.sendKeys(text);
		}else {
			System.out.println("Error while entering text!!");
		}
	}
	
	public static void click(WebElement element) {
		if(element.isDisplayed() && element.isEnabled()) {
			element.click();
		}else {
			System.out.println("Cannot able to click on element!!");
		}
	}

	public static WebElement FindElement(String locator,String value) {
		WebElement element = null;
		try {
		if(locator!=null) {
			if(locator.equalsIgnoreCase("id")) {
				element = driver.findElement(By.id(value));
			}else if(locator.equalsIgnoreCase("name")) {
				element = driver.findElement(By.name(value));
			}else if(locator.equalsIgnoreCase("className")) {
				element = driver.findElement(By.className(value));
			}else if(locator.equalsIgnoreCase("tagName")) {
				element = driver.findElement(By.tagName(value));
			}else if(locator.equalsIgnoreCase("xpath")) {
				element = driver.findElement(By.xpath(value));
			}else if(locator.equalsIgnoreCase("css")) {
				element = driver.findElement(By.cssSelector(value));
			}else{
				System.out.println("Element with locator "+ locator + " and value "+ value +" not found");
			}
			}
		}catch(NoSuchElementException e) {
			System.out.println("Element not present with the specified locator "+ locator+" and value " + value);
		}
		return element;
	}
	
	public static void waitForPageToLoad(String PageTitle) {
		wait.until(ExpectedConditions.titleContains(PageTitle));
	}
	
	public static void waitForElement(WebElement element) {
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	
}
