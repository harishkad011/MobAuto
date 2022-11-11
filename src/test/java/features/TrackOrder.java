package features;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
public class TrackOrder extends BaseTest {
	@Test
	public void TrackOrderTest() {
		
		 driver.findElement(AppiumBy.xpath("//android.widget.Button[@index='0']")).click();
         driver.findElement(AppiumBy.accessibilityId("Track Order")).click();
         WebElement el2=driver.findElement(AppiumBy.xpath("//android.widget.EditText[@text='Enter Order Id']"));
              el2.click();
              el2.sendKeys("123456");
         driver.hideKeyboard();
         driver.findElement(AppiumBy.accessibilityId("Track")).click();
         
         String el=driver.findElement(AppiumBy.xpath("//android.view.View[@index='4']")).getAttribute("content-desc");

         if(el.contains("Order details not found"))
         {
        	 System.out.println("TestPass");
         }else {
        	 System.out.println("TestFail");
         }
   }
}
