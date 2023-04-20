package CA1;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Q3 {

	public static void main(String args[]) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver;
		ChromeOptions co = new ChromeOptions();
		co.addArguments("--remote-alow-origin=*");
		driver = new ChromeDriver(co);
		
		
		driver.get("https://www.amazon.in/ref=rhf_sign_in");
		driver.findElement(By.xpath("//*[@id=\"nav-orders\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"ap_email\"]")).sendKeys("rajpalboopathi004@gmail.com",Keys.ENTER);
		driver.findElement(By.xpath("//*[@id=\"ap_password\"]")).sendKeys("Rajpal@1704",Keys.ENTER);
		Thread.sleep(2000);
		String name=driver.findElement(By.id("nav-link-accountList-nav-line-1")).getText();
		if(name.equals("Hello, Rajpal")) {
			System.out.println("Successfully, signed in");
		}else {
			System.out.println("Sign in failed");
		}
		System.out.println("Testing Ended");
		
    	driver.quit();
		}

}
