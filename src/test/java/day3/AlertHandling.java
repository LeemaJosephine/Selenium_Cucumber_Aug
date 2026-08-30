package day3;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertHandling {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		driver.findElement(By.id("name")).sendKeys("Testuser");
		driver.findElement(By.id("alertbtn")).click();
		
		// switch to the alert
		Alert alert = driver.switchTo().alert();
		String alertText = alert.getText();
		System.out.println("The text in alert: " +alertText);
		alert.accept();
		
		driver.findElement(By.id("confirmbtn")).click();
		Alert confirmAlert = driver.switchTo().alert();
		String con_alertText = alert.getText();
		System.out.println("The text in confirm alert: " +con_alertText);
		confirmAlert.dismiss();
		
	}

}
