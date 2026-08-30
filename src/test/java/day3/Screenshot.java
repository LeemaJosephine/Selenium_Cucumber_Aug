package day3;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Screenshot {

	public static WebDriver driver;
	
	public static void capture_screenshot(String name) throws IOException {
		TakesScreenshot screenshot = (TakesScreenshot)driver;
		File src = screenshot.getScreenshotAs(OutputType.FILE);
		String path = "C:\\Users\\leema\\eclipse-workspace\\SeleniumCucumber\\src\\test\\java\\screenshot\\"+name+".png";
		File dest = new File(path);
		FileUtils.copyFile(src, dest);
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		capture_screenshot("test1");
		
		
	}

}
