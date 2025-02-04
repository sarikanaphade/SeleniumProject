import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class IntractionsPage extends BaseTest
{

	IntractionsPage(WebDriver driver) {
		super(driver);
	}

	public static void main(String[] args) throws InterruptedException {
		openFirebaseApp();
		//Intractions -> Drag & Drop page
		WebElement intractions = driver.findElement(By.xpath("//button[contains(text(),'Intractions')]"));
	    Actions a = new Actions(driver);
	    a.moveToElement(intractions).build().perform();
	    WebElement drgdrop = driver.findElement(By.xpath("//a[contains(text(),'Drag & Drop')]"));
	    a.moveToElement(drgdrop).build().perform();
	    drgdrop.click();
	    
	    WebElement catimage = driver.findElement(By.xpath("//img[@id='drag1']"));
	    WebElement container1 = driver.findElement(By.xpath("//div[@id='div1'][1]"));
	    WebElement container2 = driver.findElement(By.xpath("//div[@id='div1'][2]"));
	    a.dragAndDrop(catimage, container1).build().perform();
	    WebElement droppedimage1 = driver.findElement(By.xpath("//div[@id='div1'][1]/img"));
	    if(droppedimage1.isDisplayed()) {
	    	System.out.println("Cat image is in container 1");
	    }
	    a.dragAndDrop(catimage, container2).build().perform();
	    WebElement droppedimage2 = driver.findElement(By.xpath("//div[@id='div1'][2]/img"));
	    if(droppedimage2.isDisplayed()) {
	    	System.out.println("Cat image is in container 2");
	    }
	    //how to verify ???
	    
	  //Intractions -> Mouse hover page
	    WebElement intractions1 = driver.findElement(By.xpath("//button[contains(text(),'Intractions')]"));
	    a.moveToElement(intractions1).build().perform();
	    WebElement mousehover = driver.findElement(By.xpath("//a[contains(text(),'Mouse Hover')]"));
	    a.moveToElement(mousehover).build().perform();
	    mousehover.click();
	    
	    //Alert
	    WebElement mh = driver.findElement(By.xpath("//button[contains(text(),'mousehover')]"));
	    a.moveToElement(mh).build().perform();
	    WebElement 	alrt = driver.findElement(By.xpath("(//div[@class='dropdown-content']/a[text()='Alert'])[2]"));
	    a.moveToElement(alrt).build().perform();
	    alrt.click();
	    Alert alert = driver.switchTo().alert();
	    System.out.println(alert.getText());
	    alert.accept();
	    
	    //windows
	    a.moveToElement(mh).build().perform();
	    WebElement 	win = driver.findElement(By.xpath("(//div[@class='dropdown-content']/a[text()='Windows'])[2]"));
	    a.moveToElement(win).build().perform();
	    win.click();
	    alert = driver.switchTo().alert();
	    System.out.println(alert.getText());
	    alert.accept();
	    
	    //Tabs
	    a.moveToElement(mh).build().perform();
	    WebElement 	tab = driver.findElement(By.xpath("(//div[@class='dropdown-content']/a[text()='Tabs'])[2]"));
	    a.moveToElement(tab).build().perform();
	    tab.click();
	    alert = driver.switchTo().alert();
	    System.out.println(alert.getText());
	    alert.accept();
	    
	  //Intractions -> double click page
	    WebElement intractions2 = driver.findElement(By.xpath("//button[contains(text(),'Intractions')]"));
	    //Actions a = new Actions(driver);
	    a.moveToElement(intractions2).build().perform();
	    WebElement doubleclick = driver.findElement(By.xpath("//a[contains(text(),'Double Click')]"));
	    a.moveToElement(doubleclick).build().perform();
	    doubleclick.click();
	    
	    //single click
	    WebElement sc = driver.findElement(By.xpath("//button[text()='single Click']"));
	    WebElement sccount = driver.findElement(By.xpath("//p[@id = 'demo1']"));
	    for(int i=0;i<10;i++) {
	    	sc.click();
	    }
	    System.out.println(sccount.getText());
	    if(sccount.getText().equals("Count = 10")){
	    	System.out.println("single click cliked 10 times");
	    }
	    
	    //double click
	    WebElement dc = driver.findElement(By.xpath("//button[text()='Double Click']"));
	    WebElement dccount = driver.findElement(By.xpath("//p[@id = 'Selenium']"));
	    for(int i=0;i<5;i++) {
	    	a.doubleClick(dc).build().perform();
	    }
	    System.out.println(dccount.getText());
	    if(dccount.getText().equals("Count = 5")){
	    	System.out.println("double click cliked 5 times");
	    }
	    
	  //Intractions -> Tooltip page
	    WebElement intractions3 = driver.findElement(By.xpath("//button[contains(text(),'Intractions')]"));
	    a.moveToElement(intractions3).build().perform();
	    WebElement tooltip = driver.findElement(By.xpath("//a[contains(text(),'Tool Tip')]"));
	    a.moveToElement(tooltip).build().perform();
	    tooltip.click();
	    //quitBrowser();
	    
	    //left,right,top,bottom
	    String[] tooltipm = {"l","r","t","b"};
	    for(String optins: tooltipm) {
	    	WebElement tip = driver.findElement(By.cssSelector(".tooltip"+optins));
		    a.moveToElement(tip).build().perform();
		    WebElement message = driver.findElement(By.cssSelector(".tooltip"+optins+">span"));
		    System.out.println("Tooltip message for option "+optins+" ::" + message.getText());
	    }

	    quitBrowser();
	    
	}

}
