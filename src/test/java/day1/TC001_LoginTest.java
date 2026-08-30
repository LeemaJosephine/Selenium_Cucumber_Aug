package day1;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC001_LoginTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		DesiredCapabilities capabilities = new DesiredCapabilities();
//		capabilities.setBrowserName("chrome");
//		capabilities.setPlatform(Platform.WINDOWS);  // Selenium 3
//		
//		WebDriverManager.chromedriver().setup();
//		WebDriver driver = new ChromeDriver(capabilities);
//		driver.get("https://eventhub.rahulshettyacademy.com/login");
//		driver.manage().window().maximize();
//		driver.findElement(By.id("email")).sendKeys("leema@gmail.com");
//		driver.findElement(By.id("password")).sendKeys("Testuser@123", Keys.ENTER);
		
		
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();   // Selenium 4
		options.addArguments("--headless");
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://eventhub.rahulshettyacademy.com/login");
		driver.manage().window().maximize();
		driver.findElement(By.id("email")).sendKeys("leema@gmail.com");
		driver.findElement(By.id("password")).sendKeys("Testuser@123", Keys.ENTER);
		
		
		
	}

}
