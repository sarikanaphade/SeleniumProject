package shadowdom;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.JavascriptExecutor;

import java.util.*;

public class ShadowwDom{

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
	    WebDriver driver = new ChromeDriver();
	    driver.manage().window().maximize();
	    driver.get(""); // Replace with your page URL
	    Thread.sleep(10000);
	    WebElement element = driver.findElement(By.cssSelector("#content > div > div.elementor.elementor-9374 > section > div > div > div > div > div > div#userName"));
	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
	    Thread.sleep(500); 
	        
	    SearchContext shadowHost = driver.findElement(By.cssSelector("#content > div > div.elementor.elementor-9374 > section > div > div > div > div > div > div#userName")).getShadowRoot();
	    WebElement inputElement = shadowHost.findElement(By.cssSelector("#kils"));
	    inputElement.sendKeys("Hello123");
	    
	    Thread.sleep(1000);
	    
	    //switch to iframe and interact with open shadow root elements
	    driver.switchTo().frame(shadowHost.findElement(By.id("pact1")));
	    WebElement destiny = driver.findElement(By.cssSelector("input[id='glaf']"));
	    destiny.sendKeys("HelloHow are you");
	    WebElement close = driver.findElement(By.cssSelector("button[id='close']"));
	    close.click();
	    
	    driver.switchTo().defaultContent();
	    
	    //div#"userName" - first
	    //div#app2 - second shadow root
	    //input[id='pizza'] 
	    Thread.sleep(10000);
	    SearchContext parentshadowhost = driver.findElement(By.cssSelector("div#userName")).getShadowRoot();
	    SearchContext secondShadowhost = parentshadowhost.findElement(By.cssSelector("div#app2")).getShadowRoot();
	    WebElement pizzaInput = secondShadowhost.findElement(By.cssSelector("input[id='pizza']"));
	    pizzaInput.sendKeys("cheese pizza");
	    
	    //Interact with closed shadow dom elments using actions class
	    WebElement concept = shadowHost.findElement(By.cssSelector("div#concepts"));
	    concept.click();
	    
	    Actions acct = new Actions(driver);
	    Thread.sleep(2000);
	    acct.sendKeys(Keys.TAB).perform();
	    Thread.sleep(2000);
	    acct.sendKeys("Heelo hellow").perform();
	    Thread.sleep(2000);
	    
	    String currentwindowhandle = driver.getWindowHandle();
	    acct.sendKeys(Keys.TAB).perform();
	    Thread.sleep(2000);
	    acct.sendKeys(Keys.ENTER).perform();
	    
	    Set<String> handles = driver.getWindowHandles();
	    
	    for(String handle : handles) {
	    	driver.switchTo().window(handle);
	    	Thread.sleep(2000);
	    	if(driver.getTitle().contains("XPath, CSS Selector, Web,DOM, SelectorsHub & TestCase Studio")) {
	    		System.out.println("On a new window");
	    		driver.close();
	    	}
	    }
	    driver.switchTo().window(currentwindowhandle);
	    //WebElement pwd = driver.findElement(By.xpath("//div[@id='userPass']"));
	    Thread.sleep(2000);
	    acct.sendKeys(Keys.TAB).perform();
	    Thread.sleep(2000);
	    acct.sendKeys("password Entered").perform();
	    Thread.sleep(2000);
	}
}


