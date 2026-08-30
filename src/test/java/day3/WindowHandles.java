package day3;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandles {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		String parentWindow = driver.getWindowHandle();
		System.out.println("The address of parent window: " + parentWindow);
		
		driver.findElement(By.id("opentab")).click();
		
		Set<String> windowHandles = driver.getWindowHandles();
		
		// Convert Set to List
		List<String> lstWindow = new ArrayList<String>(windowHandles);
		
		// Now using get method switch to the corresponding window.
		
		driver.switchTo().window(lstWindow.get(1));
		
		// Get the title
		String title = driver.getTitle();
		System.out.println("The title of the child window is: "+title);
		
		// switch back to parent
		driver.switchTo().window(lstWindow.get(0));
		String parent_title = driver.getTitle();
		System.out.println("The title of the parent window is: "+parent_title);
		
		driver.quit();
		
	}

}
