package SauceDemo1;

import static org.testng.Assert.assertEquals;

import java.io.FileWriter;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.github.dockerjava.api.model.Driver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Navigate {
	@Test
public void main() throws InterruptedException, IOException {
	
		
	WebDriverManager.chromedriver().setup();
	WebDriver driver=new ChromeDriver();
	driver.get("https://www.saucedemo.com/");
	
	driver.manage().window().maximize();
	Thread.sleep(3000);
	
	
	driver.findElement(By.id("user-name")).sendKeys("standard_user");
	driver.findElement(By.id("password")).sendKeys("secret_sauce");
	driver.findElement(By.xpath("//input[@type='submit']")).click();
	Thread.sleep(3000);
	SoftAssert softassert=new SoftAssert();
	String actualurl=driver.getCurrentUrl();
	String expectedurl="https://www.saucedemo.com/inventory.html";
	softassert.assertEquals(actualurl, expectedurl,"URL is mismatched");
	Thread.sleep(3000);
	System.out.println("Successful login will land the user on Products page");
	WebElement name=driver.findElement(By.className("inventory_item_name"));
	WebElement price=driver.findElement(By.className("inventory_item_price"));
	String productname=name.getText();
	System.out.println(name.getText());
	String productprice=price.getText();
	System.out.println(price.getText());
	 FileWriter fileWriter = new FileWriter("product_info.txt");
        fileWriter.write("Product Name: " + productname + "\n");
        fileWriter.write("Product Price: " + productprice + "\n");
//    } catch (IOException e) {
//        e.printStackTrace();
//    }

    System.out.println("Product information has been saved to product_info.txt.");
    
    driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
    Thread.sleep(3000);
    
     driver.findElement(By.className("shopping_cart_link")).click();
     System.out.println(driver.findElement(By.className("inventory_item_name")).getText());
     String actualtext1=driver.findElement(By.className("inventory_item_name")).getAttribute("Sauce Labs Backpack");
     String expectedtext1="";
     softassert.assertEquals(actualtext1, expectedtext1);
     
     Thread.sleep(3000);
     
     driver.findElement(By.id("react-burger-menu-btn")).click();
     Thread.sleep(3000);
     driver.findElement(By.id("logout_sidebar_link")).click();
     Thread.sleep(3000);
     
     
    

	driver.quit();
	
	
	
}
	
}
