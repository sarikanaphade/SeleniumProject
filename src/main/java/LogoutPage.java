import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class LogoutPage extends BaseTest {

	LogoutPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) throws InterruptedException {
		openFirebaseApp();
		testLogout();
		quitBrowser();
	}

	public static void testLogout(){
		WebElement logout= driver.findElement(By.linkText("Logout"));
		Actions a = new Actions(driver);
		a.moveToElement(logout).build().perform();
		logout.click();
		
		WebElement emailid = driver.findElement(By.id("email_field"));
		if(emailid.isDisplayed()) {
			System.out.println("Successfully logged out!!");
		}else {
			System.out.println("Error while logging out...");
		}
	}

}
