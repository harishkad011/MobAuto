package Tests;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import Res.BaseTest;
import Res.Slacky;
import io.appium.java_client.AppiumBy;

public class BuyNow extends BaseTest {
	
	@Test
	public void BuyNowTest() throws InterruptedException {
		
       driver.findElement(AppiumBy.xpath("//android.widget.Button[@index=\"2\"]")).click();
        
       WebElement search = driver.findElement(AppiumBy.xpath("//android.widget.EditText[@index=\"1\"]"));
       search.sendKeys("shila");
       driver.hideKeyboard();
 
       List<WebElement> pro= driver.findElements(AppiumBy.className("android.widget.ImageView"));
        for(WebElement wo : pro) {
        	try{   
    	  String me = wo.getAttribute("content-desc");
    	  me.contains("Shilajit Gold Resin"); 
    	  wo.click();
    	   break;
    	  }catch(Exception e){
    		     System.out.println(e.getMessage());
    	  }
    	}
        
       Thread.sleep(4000);
       driver.findElement(AppiumBy.accessibilityId("BUY NOW")).click();
        
        Thread.sleep(3000);
         
     String checkout = driver.findElement(AppiumBy.accessibilityId("Checkout")).getAttribute("content-desc");
     
    
     if(checkout.contains("Checkout")) {
        System.out.println("BuyNowTest_PASS");
       // Slacky.Sendmessage("BuyNowTest                                   PASS");
        }else {
        System.out.println("BuyNowTest_FAIL");	
        }
     Assert.assertEquals(checkout, "Checkout");
	}
}