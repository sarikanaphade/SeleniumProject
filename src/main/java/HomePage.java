import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.interactions.Actions;
import java.awt.AWTException;	

public class HomePage extends BaseTest{

	HomePage(WebDriver driver) {
		super(driver);
	}

	public static void main(String[] args) throws InterruptedException, AWTException {
		// TODO Auto-generated method stub
		openFirebaseApp();
        
	    WebElement home = driver.findElement(By.xpath("//a[contains(text(),'Home')]"));
	    Actions a1 = new Actions(driver);
	    a1.moveToElement(home).build().perform();
	    home.click();
	    
	     //Home page details
	     WebElement name = driver.findElement(By.id("name"));
	     name.sendKeys("TestUser");
	     driver.findElement(By.id("lname")).sendKeys("Automation");
	     driver.findElement(By.id("postaladdress")).sendKeys("Address 1");
	     driver.findElement(By.id("personaladdress")).sendKeys("Address 12345");
	        
	        //radio button
	     String value = "female";
	     driver.findElement(By.xpath("//input[@name='gender' and @value='"+value+"']")).click();
	        
	        //for dropdown use select class
	     Select city = new Select(driver.findElement(By.name("city")));
	     city.selectByValue("goa");
	     Select course = new Select(driver.findElement(By.name("course")));
	     course.selectByIndex(2);
	     Select district = new Select(driver.findElement(By.name("district")));
	     district.selectByVisibleText("GOA");
	     Select state = new Select(driver.findElement(By.name("state")));
	     state.selectByContainsVisibleText("GOA");
	        
	     driver.findElement(By.xpath("//input[@id='pincode']")).sendKeys("1234");
	     driver.findElement(By.id("emailid")).sendKeys("abc@test.com");
	     driver.findElement(By.className("bootbutton")).click();
        
	     quitBrowser();
	}

}
