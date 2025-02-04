import java.util.Set;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

    public class SwitchToPage extends BaseTest{

    	SwitchToPage(WebDriver driver) {
    		super(driver);
    	}

	public static void main(String[] args) throws InterruptedException {
		openFirebaseApp();
		////////////SWitch To -> Alert Page
		WebElement switchto = driver.findElement(By.xpath("//button[contains(text(),'Switch To')]"));
	    Actions a = new Actions(driver);
	    a.moveToElement(switchto).build().perform();
	    WebElement al = driver.findElement(By.xpath("//a[contains(text(),'Alert')]"));
	    a.moveToElement(al).build().perform();
	    al.click();
	    
	    //Prompt Alert Box
	    driver.findElement(By.xpath("//button[text()='Promt Alert']")).click();
        Alert alert = driver.switchTo().alert();
        alert.sendKeys("Test Selenium");
        alert.accept();
        System.out.println(driver.findElement(By.id("Selenium")).getText());
      
        //Window Alert box
        driver.findElement(By.xpath("//button[text()='Window Alert']")).click();
        driver.switchTo().alert().accept();
        
        ////////////SWitch To -> Windows Page
        WebElement switchto1 = driver.findElement(By.xpath("//button[contains(text(),'Switch To')]"));
        Actions b = new Actions(driver);
        b.moveToElement(switchto1).build().perform();
        WebElement windows = driver.findElement(By.xpath("//a[contains(text(),'Windows')]"));
	    b.moveToElement(windows).build().perform();
	    windows.click();
	    
	    //window-tab
	    String ParentHandle = driver.getWindowHandle();
	    WebElement tabbutton = driver.findElement(By.xpath("//button[contains(text(),'Tab')]"));
	    tabbutton.click();
	    Set<String> handles = driver.getWindowHandles();
	    for(String handle: handles) {
	    	driver.switchTo().window(handle);
	    	if(driver.getTitle().equals("Google")) {
	    		System.out.println("On new Tab window");
	    		driver.close();
	    	}
	    }
	    driver.switchTo().window(ParentHandle);
	    
	    //new window
	    WebElement windowbutton = driver.findElement(By.xpath("//button[contains(text(),'Window')]"));
	    windowbutton.click();
	    Set<String> handles1 = driver.getWindowHandles();
	    for(String handle: handles1) {
	    	driver.switchTo().window(handle);
	    	if(driver.getTitle().equals("Google")) {
	    		System.out.println("On new window");
	    		driver.close();
	    	}
	    }
	    driver.switchTo().window(ParentHandle);
	    
		///////////SWitch To -> Tabs Page
	    WebElement switchto2 = driver.findElement(By.xpath("//button[contains(text(),'Switch To')]"));
        Actions c = new Actions(driver);
        c.moveToElement(switchto2).build().perform();
        WebElement tabs = driver.findElement(By.xpath("//a[contains(text(),'Tabs')]"));
	    c.moveToElement(tabs).build().perform();
	    tabs.click();
	    //select each tab and prints its contents
	    String[] citytabs = {"London","Paris","Tokyo"};
	    for(String city: citytabs) {
	    	WebElement t = driver.findElement(By.xpath("//div[@class='tab']/button[contains(text(),'"+city+"')]"));
	    	t.click();
	    	WebElement tabcontents = driver.findElement(By.id(city));
	    	System.out.println(tabcontents.getText());
	    }
	    
	    quitBrowser();
	}

}
