package Task;



import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Q1 {
	@Test
	public void Function() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver;
		ChromeOptions co = new ChromeOptions();
		co.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(co);
		
		driver.get("https://www.saucedemo.com/");
		driver.findElement(By.xpath("//*[@id=\"user-name\"]")).sendKeys("standard_user");
		driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("secret_sauce");
		driver.findElement(By.xpath("//*[@id=\"login-button\"]")).click();
		System.out.println("Logged in successfully");
		driver.findElement(By.xpath("//*[@id=\"add-to-cart-sauce-labs-backpack\"]")).click();
		driver.findElement(By.xpath("//*[@class=\"shopping_cart_link\"]")).click();

		if(driver.getCurrentUrl().equals("https://www.saucedemo.com/cart.html"))
			System.out.println("Product added to cart");
		driver.findElement(By.xpath("//*[@id=\"checkout\"]")).click();
		if(driver.getCurrentUrl().equals("https://www.saucedemo.com/checkout-step-one.html"))
			System.out.println("Redirected to the Your information page");
		driver.findElement(By.xpath("//*[@id=\"first-name\"]")).sendKeys("Rajpal");
		driver.findElement(By.xpath("//*[@id=\"last-name\"]")).sendKeys("B");
		driver.findElement(By.xpath("//*[@id=\"postal-code\"]")).sendKeys("635203");
		driver.findElement(By.xpath("//*[@id=\"continue\"]")).click();
		System.out.println("Redirected to the product details page");
		String pname=driver.findElement(By.xpath("//*[@id=\"item_4_title_link\"]/div")).getText();
		System.out.println("product name : "+pname);
		String pprice=driver.findElement(By.xpath("//*[@id=\"checkout_summary_container\"]/div/div[1]/div[3]/div[2]/div[2]/div")).getText();
		System.out.println("product price : "+pprice);
		assertEquals(driver.getTitle(), "Swag Labs");
		assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/checkout-step-two.html");
	}
}
