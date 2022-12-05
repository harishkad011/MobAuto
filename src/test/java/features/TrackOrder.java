package features;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.appium.java_client.AppiumBy;
import resources.BaseTest;

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
         
         String  el=driver.findElement(AppiumBy.accessibilityId("Order details not found. Kindly enter the correct order ID or wait for 48 hours for tracking details.")).getAttribute("content-desc");

         
         boolean text = false;
         if(el.contains("Order details not found")){
        	 text=true;
        	 Assert.assertEquals(text, true);
        	System.out.println("TrackOrder pass");
         }else {
        	 Assert.assertEquals(text, true);
        	 System.out.println("TrackOrder fail");
         }
   }
}
