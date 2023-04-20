package Task;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Q2 {
	
	static WebDriver driver;
	public static String select(Select sl,int i) {
		sl.selectByIndex(i);
		List<WebElement>li=driver.findElements(By.xpath("//*[@class=\"inventory_item_name\"]"));
		Iterator<WebElement> it = li.iterator();
		return it.next().getText();
	}
	public static void main(String args[]) {
		WebDriverManager.chromedriver().setup();
		ChromeOptions co = new ChromeOptions();
		co.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(co);
		
		driver.get("https://www.saucedemo.com/");
		driver.findElement(By.xpath("//*[@id=\"user-name\"]")).sendKeys("standard_user");
		driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("secret_sauce");
		driver.findElement(By.xpath("//*[@id=\"login-button\"]")).click();
		System.out.println("Logged in successfully");
		
		WebElement dd = driver.findElement(By.xpath("//*[@class=\"product_sort_container\"]"));
		Select sl = new Select(dd);
		System.out.println("Z to A :"+select(sl,1));
		 dd = driver.findElement(By.xpath("//*[@class=\"product_sort_container\"]"));
		sl = new Select(dd);
		System.out.println("A to Z :"+select(sl,0));
		dd = driver.findElement(By.xpath("//*[@class=\"product_sort_container\"]"));
		sl = new Select(dd);
		System.out.println("High to low :"+select(sl,2));
		dd = driver.findElement(By.xpath("//*[@class=\"product_sort_container\"]"));
		sl = new Select(dd);
		System.out.println("Low to High :"+select(sl,3));
	}
}
