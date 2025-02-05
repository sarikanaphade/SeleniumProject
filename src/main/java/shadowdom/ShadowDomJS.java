package shadowdom;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.SearchContext;

public class ShadowDomJS{

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
	    driver.manage().window().maximize();
	    driver.get(""); // Replace with your page URL
	    Thread.sleep(10000);
	    WebElement shadowHost = driver.findElement(By.cssSelector("#content > div > div.elementor.elementor-9374 > section > div > div > div > div > div > div#userName"));
	    JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
	    SearchContext shadowRoot = (SearchContext) jsExecutor.executeScript("return arguments[0].shadowRoot;", shadowHost);
	    WebElement elementInsideShadow = shadowRoot.findElement(By.cssSelector("#kils"));
	    elementInsideShadow.sendKeys("Hello123");
	}

}
