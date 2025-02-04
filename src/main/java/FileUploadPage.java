import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;

public class FileUploadPage extends BaseTest{

	FileUploadPage(WebDriver driver) {
		super(driver);
	}

	public static void main(String[] args) throws InterruptedException, AWTException {
		openFirebaseApp();
		//testFileUpload();
		testFileUploadRobotClass();
		quitBrowser();
	}

	public static void testFileUpload(){
		WebElement fileupload= driver.findElement(By.xpath("//a[contains(text(),'File Upload')]"));
		Actions a = new Actions(driver);
		a.moveToElement(fileupload).build().perform();
		fileupload.click();
		
		WebElement clear = driver.findElement(By.xpath("//button[text()='Clear']"));
		clear.click();
		WebElement image = driver.findElement(By.tagName("img"));
        String srcValue = image.getDomAttribute("src");
        if(srcValue==null) {
        	System.out.println("No image Uploaded!!!");
        }

		String filePath = System.getProperty("user.dir")+"/src/main/resources/TestFile.txt";
		WebElement fileupld = driver.findElement(By.id("logo"));
		fileupld.sendKeys(filePath);
		
		WebElement image1 = driver.findElement(By.tagName("img"));
        srcValue = image1.getDomAttribute("src");
        if(srcValue != null) {
        	System.out.println("Image Uploaded successfully!!!");
        }	
	}
	
	public static void testFileUploadRobotClass() throws AWTException {
		WebElement fileupload= driver.findElement(By.xpath("//a[contains(text(),'File Upload')]"));
		Actions a = new Actions(driver);
		a.moveToElement(fileupload).build().perform();
		fileupload.click();
		
		WebElement clear = driver.findElement(By.xpath("//button[text()='Clear']"));
		clear.click();
		WebElement image = driver.findElement(By.tagName("img"));
        String srcValue = image.getDomAttribute("src");
        if(srcValue==null) {
        	System.out.println("No image Uploaded!!!");
        }
        String filePath = System.getProperty("user.dir")+"/src/main/resources/TestFile.txt";
		StringSelection ss = new StringSelection(filePath);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
        
		WebElement fileupld = driver.findElement(By.id("logo"));
		fileupld.click();
		Robot robot = new Robot();
		robot.delay(500);
		robot.keyPress(KeyEvent.VK_META);
	    robot.keyPress(KeyEvent.VK_V);
	    robot.keyRelease(KeyEvent.VK_META);
	    robot.keyRelease(KeyEvent.VK_V);

	    //Press Enter key to close the Goto window and Upload window
	    robot.keyPress(KeyEvent.VK_ENTER);
	    robot.keyRelease(KeyEvent.VK_ENTER);
	    robot.delay(500);
	    
	    WebElement image1 = driver.findElement(By.tagName("img"));
        srcValue = image1.getDomAttribute("src");
        if(srcValue != null) {
        	System.out.println("Image Uploaded successfully!!!");
        }	
	}

}
