import java.util.*;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class WidgetPage extends BaseTest{

	WidgetPage(WebDriver driver) {
		super(driver);
	}
	
	public static void main(String[] args) throws InterruptedException {
		openFirebaseApp();
		//testWebTable();
		//testAccordian();
		//testAutoComplete();
		testDatePicker();
		quitBrowser();
	}
	
	public static void testDatePicker() throws InterruptedException {
		// TODO Auto-generated method stub
		///////////Widget -> DatePicker page
		WebElement widget = driver.findElement(By.xpath("//button[contains(text(),'Widget')]"));
		Actions a = new Actions(driver);
		a.moveToElement(widget).build().perform();
		WebElement  dp= driver.findElement(By.xpath("//a[contains(text(),'Date Picker')]"));
		a.moveToElement(dp).build().perform();
		dp.click();
		
		WebElement birthday = driver.findElement(By.xpath("//input[@name='bday']"));
		Thread.sleep(1000);
		birthday.sendKeys(Keys.TAB);
		Thread.sleep(1000);
		birthday.sendKeys(Keys.TAB);
		Thread.sleep(1000);
		birthday.sendKeys(Keys.TAB);
		Thread.sleep(1000);
		birthday.sendKeys(Keys.SPACE);
		Thread.sleep(1000);
		birthday.sendKeys(Keys.TAB);
		Thread.sleep(1000);
		birthday.sendKeys(Keys.TAB);
		Thread.sleep(1000);
		birthday.sendKeys(Keys.TAB);
		Thread.sleep(1000);
		birthday.sendKeys(Keys.SPACE);
		Thread.sleep(1000);
		
		int year = 2024;
		int month = 12;
		int yearfind = 2025-year;
		int l = yearfind*3;
		for(int aa=0;aa<l;aa++) {
		Thread.sleep(1000);
		birthday.sendKeys(Keys.UP);
		}
		
		if(month == 12) {
			for(int i=0;i<11;i++) {
				Thread.sleep(1000);
				birthday.sendKeys(Keys.RIGHT);
			}
		}
		
		birthday.sendKeys(Keys.ENTER);
		Thread.sleep(1000);
		
		Thread.sleep(1000);

		
	}

	public static void testAutoComplete() {
		////////////Widget -> AutoComplete page
		WebElement widget = driver.findElement(By.xpath("//button[contains(text(),'Widget')]"));
		Actions a = new Actions(driver);
		a.moveToElement(widget).build().perform();
		WebElement  ac= driver.findElement(By.xpath("//a[contains(text(),'AutoComplete')]"));
		a.moveToElement(ac).build().perform();
		ac.click();
		
		WebElement country = driver.findElement(By.cssSelector("input#myInput"));
		country.sendKeys("i");
		List<WebElement> autocompletelist = driver.findElements(By.cssSelector("div#myInputautocomplete-list > div"));
		String countryName = "India";
		System.out.println(autocompletelist.size());
		for(int i=0;i<autocompletelist.size();i++) {
			WebElement cnty = autocompletelist.get(i);
			String value = cnty.findElement(By.tagName("input")).getDomAttribute("Value");
			System.out.println(value);
			if(value.equals(countryName)) {
				cnty.click();
				break;
			}
		}
	}

	public static void testWebTable() {
		////////////Widget -> Table page
		WebElement widget = driver.findElement(By.xpath("//button[contains(text(),'Widget')]"));
	    Actions a = new Actions(driver);
	    a.moveToElement(widget).build().perform();
	    WebElement  t= driver.findElement(By.xpath("//a[contains(text(),'Table')]"));
	    a.moveToElement(t).build().perform();
	    t.click();
	    
	    WebElement table = driver.findElement(By.tagName("table"));
	    List<WebElement> rows = table.findElements(By.tagName("tr"));
	    //System.out.println(rows.size());
	    
	    for(int r=0;r<rows.size();r++) {
	    	List<WebElement> header = rows.get(r).findElements(By.tagName("th"));
	    	for(int c=0;c<header.size();c++) {
	    		System.out.println(header.get(c).getText());
	    	}
	    	header= rows.get(r).findElements(By.tagName("td"));
	    	for(int c=0;c<header.size();c++) {
	    		System.out.println(header.get(c).findElement(By.tagName("input")).getDomAttribute("Value"));
	    	}
    	System.out.println("");
	    }
	}
	
	public static void testAccordian() {
		////////////Widget -> Table page
		WebElement widget = driver.findElement(By.xpath("//button[contains(text(),'Widget')]"));
		Actions a = new Actions(driver);
		a.moveToElement(widget).build().perform();
		WebElement  acdn= driver.findElement(By.xpath("//a[contains(text(),'Accordian')]"));
		a.moveToElement(acdn).build().perform();
		acdn.click();
		
		List<WebElement> sections = driver.findElements(By.xpath("//div[@id='user_div']/div[2]/button"));
		for(int i=0;i<sections.size();i++) {
			//WebElement section = driver.findElement(By.xpath("//div[@id='user_div']/div[2]/button["+i+"]"));
			WebElement section = sections.get(i);
			section.click();
			WebElement contents = driver.findElement(By.xpath("//div[@id='user_div']/div[2]/button[@class ='accordion active']//following-sibling::div[1]/p"));
			System.out.println("Section "+ (i+1)+ " Contents:: "+ contents.getText());
			System.out.println();
			section.click();
		}
	}

	public static void testWebTables() {
		////////////Widget -> Table page
		WebElement widget = driver.findElement(By.xpath("//button[contains(text(),'Widget')]"));
	    Actions a = new Actions(driver);
	    a.moveToElement(widget).build().perform();
	    WebElement  t= driver.findElement(By.xpath("//a[contains(text(),'Table')]"));
	    a.moveToElement(t).build().perform();
	    t.click();
	    
	    //get table contents - done
	    //table/tbody/tr/td[3] == get third column values
	    //table/tbody/tr[2]/td == get second row walues
	    //table/tbody/tr/td == gets all rows and columns 
	    //fetch specific row contents - 
	    //modify row contents
	    
	    //Printing all rows and cols values
	    List<WebElement> rows = driver.findElements(By.xpath("//table/tbody/tr"));
	    System.out.println(rows.size());
	    
	    for(int r = 2;r<=rows.size();r++) {
	    	List<WebElement> cols = driver.findElements(By.xpath("//table/tbody/tr["+r+"]/td"));
	    	
	    	for(int c=1;c<=cols.size();c++) {
	    		WebElement colcontents = driver.findElement(By.xpath("//table/tbody/tr["+r+"]/td["+c+"]/input"));
	    		System.out.println("row: "+r+ "col: "+c + " Contents:  "+colcontents.getDomAttribute("value"));
	    		System.out.println();
	    	}
	    }
	    
	    //print all ids,lastnames,firstnames,mail ids in the table
	    List<WebElement> r1 = driver.findElements(By.xpath("//table/tbody/tr"));
    	ArrayList<String> lslist = new ArrayList<String>();
    	ArrayList<String> idlist = new ArrayList<String>();
    	ArrayList<String> fnlist = new ArrayList<String>();
        ArrayList<String> midlist = new ArrayList<String>();
    	for(int rw=2;rw<=r1.size();rw++) {
    		WebElement id = driver.findElement(By.xpath("//table/tbody/tr["+rw+"]/td[1]/input"));
    		idlist.add(id.getDomAttribute("value"));
    		WebElement fn = driver.findElement(By.xpath("//table/tbody/tr["+rw+"]/td[2]/input"));
    		fnlist.add(fn.getDomAttribute("value"));
    		WebElement ls = driver.findElement(By.xpath("//table/tbody/tr["+rw+"]/td[3]/input"));
    		lslist.add(ls.getDomAttribute("value"));
    		WebElement mid = driver.findElement(By.xpath("//table/tbody/tr["+rw+"]/td[4]/input"));
    		midlist.add(mid.getDomAttribute("value"));	
    	}
    	System.out.println("Id's in the Table:: " +idlist);
    	System.out.println("Firstname column values :: " +fnlist);
    	System.out.println("lastname column values :: "+lslist);
    	System.out.println("Mail ids in the Table:: "+midlist);
    	
    	//fetch row contents based on firstname
    	List<WebElement> r2 = driver.findElements(By.xpath("//table/tbody/tr"));
    	for(int rw=2;rw<=r2.size();rw++) {
    		List<WebElement> cols = driver.findElements(By.xpath("//table/tbody/tr["+rw+"]/td"));
    		for(int cl=1;cl<=cols.size();cl++) {
    			WebElement fn = driver.findElement(By.xpath("//table/tbody/tr["+rw+"]/td[2]/input"));
    			if(fn.getDomAttribute("value").equals("Ujjwal")) {
    				WebElement coldetails = driver.findElement(By.xpath("//table/tbody/tr["+rw+"]/td["+cl+"]/input"));	
    				System.out.println("Ujjals details are: "+ coldetails.getDomAttribute("value"));
    			}
    		}
    	}
    	
    	//Edit last name of specific row n col
//	    
//	    List<WebElement> r3 = driver.findElements(By.xpath("//table/tbody/tr"));
//    	for(int rw=2;rw<=r3.size();rw++) {
//    		List<WebElement> cols = driver.findElements(By.xpath("//table/tbody/tr["+rw+"]/td"));
//    		for(int cl=1;cl<=cols.size();cl++) {
//    			WebElement fn = driver.findElement(By.xpath("//table/tbody/tr["+rw+"]/td[2]/input"));
//    			if(fn.getDomAttribute("value").equals("Ujjwal")) {
//    				
//    			}
//    			}    
	}
	    

}
