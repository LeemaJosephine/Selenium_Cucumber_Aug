package day6;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutoITSample {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.ilovepdf.com/pdf_to_word");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		driver.findElement(By.id("pickfiles")).click();
		
		Thread.sleep(5000);
		Runtime.getRuntime().exec("C:\\Users\\leema\\OneDrive\\Desktop\\FileUpload.exe");
		
//		Thread.sleep(5000);
		driver.findElement(By.id("processTask")).click();
	}

}
