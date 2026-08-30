package day3;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FrameHandling {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.automationtesting.in/Frames.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		//driver.findElement(By.partialLinkText("Single Iframe ")).click();
		
		driver.switchTo().frame("singleframe");
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("TestUser");
		
		driver.switchTo().defaultContent();
		
		driver.findElement(By.xpath("//a[text()='Iframe with in an Iframe']")).click();
		
		// Switch to parent frame
		
		WebElement parentFrame = driver.findElement(By.xpath("//iframe[@src='MultipleFrames.html']"));
		driver.switchTo().frame(parentFrame);
		
		// switch to child frame
		WebElement childFrame = driver.findElement(By.xpath("//iframe[@src='SingleFrame.html']"));
		driver.switchTo().frame(childFrame);
		
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("TestUser");
		
		// switch back to parent frame
		
		driver.switchTo().parentFrame();
		String text = driver.findElement(By.xpath("//h5[text()='Nested iFrames']")).getText();
		System.out.println("Element from parent frame: " +text);
		
		// switch to default content
		driver.switchTo().defaultContent();
		
		driver.findElement(By.xpath("//a[text()='Single Iframe ']")).click();
		
		
		
		
	}

}
