import java.awt.AWTException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.JavascriptExecutor;

public class calculatorPage extends BaseTest{

	calculatorPage(WebDriver driver) {
		super(driver);
	}

	public static void main(String[] args) throws InterruptedException {
			openFirebaseApp();
			testCalculator();
			quitBrowser();
		}

		public static void testCalculator() throws InterruptedException{
			WebElement calculator= driver.findElement(By.xpath("//a[contains(text(),'Calculator')]"));
			Actions a = new Actions(driver);
			a.moveToElement(calculator).build().perform();
			calculator.click();
			
			clickClearButton();
			int res = add(2,3,4);
			System.out.println("Addition of numbers: "+res);
			clickClearButton();
			res = subtract(4,1);
			System.out.println("Substraction of numbers: "+res);
			clickClearButton();
			res = multiply(2500,4);
			System.out.println("Multiplication of numbers: "+res);
			clickClearButton();
			res = divide(244444444,2);
			System.out.println("Division of numbers: "+res);
			VerifyDisplayResult(res);
		}
		
		public static int add(int...n) throws InterruptedException { 
			int res =0;
			//System.out.println(n.length);
			for(int i=0;i<n.length;i++) {
				res = res+n[i];
				//System.out.println(res);
				clickNumber(n[i]);
				Thread.sleep(1000);
				if(i==(n.length-1)) {
					click("=");
					Thread.sleep(1000);
				}else {
					click("+");
				Thread.sleep(1000);
				}
			}
			return res;
		}
		public static int subtract(int...n) throws InterruptedException { 
			int res =0;
			//System.out.println(n.length);
			for(int i=0;i<n.length;i++) {
				if(i==0) {
					res = n[i]-res;
				}else {
				res = res-n[i];
				}
				clickNumber(n[i]);
				Thread.sleep(1000);
				if(i==(n.length-1)) {
					click("=");
					Thread.sleep(1000);
				}else {
					click("-");
				Thread.sleep(1000);
				}
			}
			return res;
		}
		
		public static int multiply(int...n) throws InterruptedException { 
			int res =1;
			//System.out.println(n.length);
			for(int i=0;i<n.length;i++) {
				res = n[i]* res;
				clickNumber(n[i]);
				Thread.sleep(1000);
				if(i==(n.length-1)) {
					click("=");
					Thread.sleep(1000);
				}else {
					click("x");
				Thread.sleep(1000);
				}
			}
			return res;
		}
		
		public static int divide(int...n) throws InterruptedException { 
			int res =1;
			//System.out.println(n.length);
			for(int i=0;i<n.length;i++) {
				if(i==0) {
					res = n[i]/res;
				}else {
				res = res/n[i];
				}
				//System.out.println(res);
				clickNumber(n[i]);
				Thread.sleep(1000);
				if(i==(n.length-1)) {
					click("=");
					Thread.sleep(1000);
				}else {
					click("/");
				Thread.sleep(1000);
				}
			}
			return res;
		}
		public static void VerifyDisplayResult(int ans) {
//			WebElement display = driver.findElement(By.xpath("//input[@id='display']"));
//			System.out.println(display.getText());
//			if(display.getText().equals(String.valueOf(ans))) {
//				System.out.println("Displaying correct result");
//			}else {
//				System.out.println("Wrong result");
//			}
			JavascriptExecutor js = (JavascriptExecutor) driver;
			String script = "return document.querySelector('#display').innerText"; // Modify this accordingly
	        String screenValue = (String) js.executeScript(script);
	        System.out.println(screenValue);
		}

		public static void click(String val) {
			driver.findElement(By.xpath("//input[@class='button mathButtons' and @value='"+val+"']")).click();	
		}
		
		public static void clickClearButton() {
			driver.findElement(By.xpath("//input[@id='clearButton']")).click();
		}
		public static void clickNumber(int num) {
			String n = String.valueOf(num);
			char[] a = n.toCharArray();
			for(int i=0;i<a.length;i++) {
				WebElement no = driver.findElement(By.xpath("//input[@class='button digits' and @value ="+a[i]+"]"));
				no.click();
			}
		}
		
		

}
