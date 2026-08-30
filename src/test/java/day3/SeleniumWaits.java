package day3;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.jspecify.annotations.NonNull;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumWaits {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.hyrtutorials.com/p/waits-demo.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(3));
		
		driver.findElement(By.id("btn1")).click();
		driver.findElement(By.id("txt1")).sendKeys("TestUser");  // will be handled by implicit wait 
		
		driver.findElement(By.id("btn2")).click();
		
//		// Explicit wait
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//		WebElement textBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("txt2")));
//		textBox.sendKeys("TestUser1");
		
		//Fluent wait
		Wait<WebDriver> wait1 = new FluentWait<>(driver)
				.withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofSeconds(2))
				.ignoring(NoSuchElementException.class)
				.withMessage("It failed due to no such element expection");
		
		WebElement textBox1 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("txt2")));
		textBox1.sendKeys("TestUser1");
		
		
		
	}

}
