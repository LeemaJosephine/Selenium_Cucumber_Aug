package day2;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class FormElements {

	public static void main(String[] args) throws MalformedURLException, IOException {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		// TextBox
		WebElement username = driver.findElement(By.id("name"));
		WebElement email = driver.findElement(By.id("email"));
		username.sendKeys("admin");
		username.clear();
		username.sendKeys("testuser");
		
		// Select add and copy
		username.sendKeys(Keys.CONTROL,"a");
		username.sendKeys(Keys.CONTROL,"c");
		
		// Click and paste
		email.click();
		email.sendKeys(Keys.CONTROL,"v");
		
		String value = username.getAttribute("value");  // Get entered value
		System.out.println("The valus is " + value);
		username.isDisplayed();  // check visibility
		username.isEnabled();  // Check whether enabled 1
		
		
		WebElement phone = driver.findElement(By.id("phone"));
		// Select, copy and paste using actions
		
		Actions act = new Actions(driver);
		act.click(email).keyDown(Keys.CONTROL).sendKeys("a").sendKeys("c").keyUp(Keys.CONTROL)
		.click(phone).keyDown(Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).perform();
	

		// Button
		WebElement button = driver.findElement(By.name("start"));
		System.out.println(button.isDisplayed());
		System.out.println(button.isEnabled());
		
		if(button.isEnabled()) {
			
			button.click();
		}
		
		// act.click(button).perform();
		
		// Drop down
		
		WebElement country = driver.findElement(By.id("country"));
		
		Select select = new Select(country);
		
		select.selectByValue("france");
		
		select.selectByIndex(5);
		
		// Links
		
		// Using linktext
		
		//driver.findElement(By.linkText("Udemy Courses")).click();
		//driver.findElement(By.partialLinkText("Udemy")).click();
		
		// Find all invalid/empty links on webpage
		
//		List<WebElement> links = driver.findElements(By.tagName("a"));
//		
//		for(WebElement link : links) {
//			
//			String href = link.getAttribute("href");
//			
//				URL url = new URL(href);
//				HttpURLConnection connection = (HttpURLConnection) url.openConnection();
//				connection.connect();
//				
//				int statusCode = connection.getResponseCode();
//				
//				if(statusCode == 200) {
//					
//					System.out.println("Valid link: " +href);
//				} else {
//					
//					System.out.println("Broken Link: "+href);
//				}
//				
//		}
		
		
		// Check Boxes
		
		WebElement checkBox = driver.findElement(By.xpath("//input[@id='sunday']"));
		checkBox.click();
		
		System.out.println(checkBox.isSelected());
		
		// Select all unchecked checkboxes
		
		List<WebElement> days = driver.findElements(By.xpath("//label[text()='Days:']/following::div/input[@type='checkbox']"));
		
		for(WebElement day : days) {
			
			if(!day.isSelected()) {
				day.click();
			}
		}
		
		// Radio Button
		
		WebElement female = driver.findElement(By.xpath("//input[@value='female']"));
		
		if(!female.isSelected()) {
			
			female.click();
		}
		
		// HTML Tables
		
		// Get all rows
		
		List<WebElement> rows = driver.findElements(By.xpath("//table[@id='taskTable']//tr"));
		System.out.println(rows.size());
		
		// Get all columns
		List<WebElement> columns = driver.findElements(By.xpath("//table[@id='taskTable']//tr[1]//td"));
		System.out.println(columns.size());
		
		// Print complete table
		
		for(WebElement row : rows) {
			
			List<WebElement> cells = row.findElements(By.tagName("td"));
			for(WebElement cell : cells) {
				System.out.print(cell.getText()+" ");
			}
			System.out.println();
		}
	}

}
