package Tests;

import java.time.Duration;
import java.util.Arrays;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.testng.annotations.Test;

import Res.BaseTest;
import io.appium.java_client.AppiumBy;

public class Cart extends BaseTest{
	
	@Test
	public void CartTest() throws InterruptedException {
		
		   driver.findElement(AppiumBy.xpath("//android.widget.Button[@index=\"2\"]")).click();
        
	       WebElement search = driver.findElement(AppiumBy.xpath("//android.widget.EditText[@index=\"1\"]"));
	       search.sendKeys("GetSlim juice");
	       driver.hideKeyboard();
	       driver.findElement(AppiumBy.xpath("//android.widget.ImageView[@index=\"3\"]")).click();
	       Thread.sleep(4000);
           driver.findElement(AppiumBy.xpath("//android.view.View[@index=\"4\"]")).click();
		
//		WebElement el01=driver.findElement(By.xpath("//android.widget.ScrollView"));
//	  	int center_x=el01.getRect().x + (el01.getSize().width/2);
//	  	double start_y=el01.getRect().y + (el01.getSize().height*0.7);
//	  	double end_y=el01.getRect().y + (el01.getSize().height*0.1);
//	  	PointerInput finger=new PointerInput(PointerInput.Kind.TOUCH,"finger");
//	  	Sequence swipe = new Sequence(finger, 1);
//	  	swipe.addAction(finger.createPointerMove(Duration.ofSeconds(0), PointerInput.Origin.viewport(), center_x, (int)start_y));
//	  	swipe.addAction(finger.createPointerDown(0));
//	  	swipe.addAction(finger.createPointerMove(Duration.ofMillis(700), PointerInput.Origin.viewport(), center_x, (int)end_y));
//	  	swipe.addAction(finger.createPointerUp(0));
//	  	driver.perform(Arrays.asList(swipe));
//	  	
//	  	Thread.sleep(3000);
//	  	
//	  	driver.findElement(AppiumBy.xpath("//android.view.View[@content-desc=\"Get Slim Juice ( 1.58K ) ₹1098 ₹989\"]/android.widget.ImageView[2]")).click();
	  	Thread.sleep(3000);
	  	
	  	driver.findElement(AppiumBy.accessibilityId("1 Cart")).click();
	  	WebElement ht=driver.findElement(AppiumBy.accessibilityId("Get Slim Juice 1month(2units): ₹989 @10% "
	  			+ "off Price: ₹989.00 Qty: 1 Total Price: ₹989.00"));
	  	String ro=ht.getAttribute("content-desc");
	  	
	  	if(ro.contains("Get Slim Juice")) {
	  		System.out.println("Pass");
	  	}else {
	  		System.out.println("Fail");
	  	}
		
	}

}
