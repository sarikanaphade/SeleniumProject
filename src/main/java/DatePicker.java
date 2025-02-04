import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
public class DatePicker {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://jqueryui.com/datepicker/");
		
	     Thread.sleep(2000);
	     driver.switchTo().frame(driver.findElement(By.className("demo-frame")));
	     driver.findElement(By.id("datepicker")).click();
	     Thread.sleep(2000);
	     int day=12;
	     int year = 2025;
	     String mnth = "May";
	     
	     WebElement month = driver.findElement(By.xpath("//div[@class='ui-datepicker-title']/span[1]"));
	     WebElement yyyy = driver.findElement(By.xpath("//div[@class='ui-datepicker-title']/span[2]"));
	     int y = Integer.parseInt(yyyy.getText());
		 String mon = month.getText();
	     if(year < y) {
	    	 while(!mon.equals(mnth) || year != y) {
	    		 System.out.println("mon "+ mon + " month "+ mnth);
	    		 System.out.println("year "+ year + " y " + y);
	    		 WebElement previous = driver.findElement(By.xpath("//a[@data-handler='prev']"));
	    	     previous.click();
	    	     month = driver.findElement(By.xpath("//div[@class='ui-datepicker-title']/span[1]"));
	    	     yyyy = driver.findElement(By.xpath("//div[@class='ui-datepicker-title']/span[2]"));
	    	     y = Integer.parseInt(yyyy.getText());
	    		 mon = month.getText();
	    	 }
		 }else {
			 while(!mon.equals(mnth) || year != y) {
	    		 System.out.println("mon "+ mon + " month "+ mnth);
	    		 System.out.println("year "+ year + " y " + y);
	    		 WebElement next = driver.findElement(By.xpath("//a[@data-handler='next']"));
	    	     next.click();
	    	     month = driver.findElement(By.xpath("//div[@class='ui-datepicker-title']/span[1]"));
	    	     yyyy = driver.findElement(By.xpath("//div[@class='ui-datepicker-title']/span[2]"));
	    	     y = Integer.parseInt(yyyy.getText());
	    		 mon = month.getText();
	    	 }
		 }
	     
	     
	     WebElement t = driver.findElement(By.cssSelector("table.ui-datepicker-calendar"));
	     List<WebElement>rows = t.findElements(By.tagName("tr"));
	     System.out.println(rows.size());
	    
	     
	     for(int r = 0;r<rows.size();r++) {
	    	 List<WebElement> col = rows.get(r).findElements(By.tagName("td"));
	    	 System.out.println("Test Data col size:: " +col.size());
	    	 for(int c=0;c<col.size();c++) {
	    		 String d= String.valueOf(day);
	    		 System.out.println("String d:: "+d);
	    		 WebElement dy = col.get(c).findElement(By.xpath("//a[@data-date='"+d+"']"));
	    		 String val = dy.getText();
	    		 System.out.println("Val :: " +val);
	    		 if(val.equals(d)) {
	    			 dy.click();
	    			 System.out.println(day +" clicked");
	    			 Thread.sleep(2000);
	    		 }
	    	 }
	    	 
	    	 
	     }
	     driver.quit();
	}

}
