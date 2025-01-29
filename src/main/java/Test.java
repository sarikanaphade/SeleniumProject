import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.Alert;
import java.awt.AWTException;	
import java.awt.Robot;	
import java.awt.event.KeyEvent;	
import java.util.*;

public class Test {

	public static void main(String[] args) throws InterruptedException, AWTException {
		// TODO Auto-generated method stub
		 WebDriver driver = new ChromeDriver();

	        // Open a website
	        driver.get("https://demohome.html");
	        Thread.sleep(10000);
	        driver.findElement(By.id("email_field")).sendKeys("");
	        driver.findElement(By.id("password_field")).sendKeys("");
	        driver.findElement(By.xpath("//button[text()='Login to Account']")).click();

	        // Perform actions on the website
	        System.out.println("Page title is: " + driver.getTitle());
	        if(driver.getTitle()=="Selenium") {
	        	System.out.println("Landed on selenium page.");
	        }
	        
	        Thread.sleep(10000);
	        driver.findElement(By.id("name")).sendKeys("TestUser");
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
//	        
//	        //mouseover using actions class
	        Thread.sleep(5000);
	        WebElement switchTo = driver.findElement(By.xpath("//div[@class='navbar']/div[1]"));
	        Actions a = new Actions(driver);
	        a.moveToElement(switchTo).perform();
	        WebElement Alertlink = driver.findElement(By.linkText("Alert"));
	        Alertlink.click();
	        driver.findElement(By.xpath("//button[text()='Promt Alert']")).click();
	        
	        //handling prompt/windows alert - using alert anf robot class
	        Alert al = driver.switchTo().alert();
	        al.sendKeys("Test Selenium");
	        Thread.sleep(10000);
	        al.accept();
	        Thread.sleep(10000);
	        System.out.println(driver.findElement(By.id("Selenium")).getText());
	      
	        driver.findElement(By.xpath("//button[text()='Window Alert']")).click();
	        driver.switchTo().alert().accept();
	        Thread.sleep(2000);
	        driver.findElement(By.xpath("//button[text()='Window Alert']")).click();
	        Robot robot = new Robot();  // Robot class throws AWT Exception	
	        Thread.sleep(10000); // Thread.sleep throws InterruptedException	
	        robot.keyPress(KeyEvent.VK_TAB);	
	        Thread.sleep(10000);	
	        robot.keyPress(KeyEvent.VK_SPACE);	
	        Thread.sleep(10000);	
	        driver.switchTo().alert().accept();
	        
	        
	        Thread.sleep(5000);
	        Actions a1 = new Actions(driver);
	        a1.moveToElement(switchTo).perform();
	        WebElement WindowsLink = driver.findElement(By.linkText("Window"));
	        WindowsLink.click();
	        
	        driver.findElement(By.xpath("//div[@class=' login']/a[1])")).click();
	        
//	        Set<String> handles=driver.getWindowHandles();
//	        Iterator window = handles.iterator();
//	        while()
	        
	        // Close the browser
	        driver.quit();
	}

}
