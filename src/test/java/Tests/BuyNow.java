package Tests;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import Res.BaseTest;
import Res.Slacky;
import io.appium.java_client.AppiumBy;

public class BuyNow extends BaseTest {
	
	@Test
	public void BuyNowTest() throws InterruptedException {
		
       driver.findElement(AppiumBy.xpath("//android.widget.Button[@index=\"2\"]")).click();
        
       WebElement search = driver.findElement(AppiumBy.xpath("//android.widget.EditText[@index=\"1\"]"));
       search.sendKeys("GetSlim juice");
       driver.hideKeyboard();
 
       driver.findElement(AppiumBy.xpath("//android.widget.ImageView[@index=\"3\"]")).click();
       
       Thread.sleep(4000);
       driver.findElement(AppiumBy.accessibilityId("BUY NOW")).click();
        
        Thread.sleep(3000);
        System.out.println("BuyNowTest_PASS");
       // Slacky.Sendmessage("BuyNowTest                                   PASS");
		
	}
}
