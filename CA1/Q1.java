package CA1;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Q1 {
	public static void main(String args[]) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver;
		ChromeOptions co = new ChromeOptions();
		co.addArguments("--remote-alow-origin=*");
		driver = new ChromeDriver(co);
		
		
		driver.navigate().to("https://www.amazon.in/Ben-Martin-Classic-Collar-Cotton/dp/B09YMCW9FD/ref=sr_1_2_sspa?crid=Z5OUSLRT6WL&keywords=shirts&qid=1681289896&sprefix=%2Caps%2C241&sr=8-2-spons&sp_csd=d2lkZ2V0TmFtZT1zcF9hdGY&th=1&psc=1");
		driver.manage().window().maximize();
		WebElement qu = driver.findElement(By.xpath("//*[@id=\"quantity\"]"));
		Select sl = new Select(qu);
		sl.selectByIndex(3);
		WebElement shirt = driver.findElement(By.xpath("//*[@id=\"add-to-cart-button\"]"));
		shirt.click();
		System.out.println("Shirt1 added to the cart");
		driver.navigate().to("https://www.amazon.in/Kizyoo-Shirt-Shirts-Casual-Printed/dp/B0BZDJ7T5W/ref=sr_1_1_sspa?crid=Z5OUSLRT6WL&keywords=shirts&qid=1681289896&sprefix=%2Caps%2C241&sr=8-1-spons&sp_csd=d2lkZ2V0TmFtZT1zcF9hdGY&psc=1");
		WebElement shirt1 = driver.findElement(By.xpath("//*[@id=\"add-to-cart-button\"]"));
		shirt1.click();
		System.out.println("Shirt2 added to the cart");
		WebElement cart = driver.findElement(By.xpath("//*[@id=\"nav-cart\"]"));
		cart.click();
		System.out.println("moving to the cart page");
		WebElement quan = driver.findElement(By.xpath("//*[@id=\"a-autoid-3-announce\"]"));
		quan.click();
		driver.findElement(By.xpath("//*[@id=\"quantity_10\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"a-autoid-4-announce\"]")).click();
		String tit = driver.getTitle();
		System.out.println("Thus the page has been redirected to sign in"+tit);
		 
	}
}
