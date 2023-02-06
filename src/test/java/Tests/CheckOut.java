package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Arrays;
import Res.BaseTest;
import Res.Slacky;
import io.appium.java_client.AppiumBy;

public class CheckOut extends BaseTest {

	@Test
	public void CheckOutTest() throws InterruptedException {
		
    WebElement el01=driver.findElement(By.xpath("//android.widget.ScrollView"));
  	int center_x=el01.getRect().x + (el01.getSize().width/2);
  	double start_y=el01.getRect().y + (el01.getSize().height*0.7);
  	double end_y=el01.getRect().y + (el01.getSize().height*0.1);
  	PointerInput finger=new PointerInput(PointerInput.Kind.TOUCH,"finger");
  	Sequence swipe = new Sequence(finger, 1);
  	swipe.addAction(finger.createPointerMove(Duration.ofSeconds(0), PointerInput.Origin.viewport(), center_x, (int)start_y));
  	swipe.addAction(finger.createPointerDown(0));
  	swipe.addAction(finger.createPointerMove(Duration.ofMillis(700), PointerInput.Origin.viewport(), center_x, (int)end_y));
  	swipe.addAction(finger.createPointerUp(0));
  	driver.perform(Arrays.asList(swipe));
  	
  	Thread.sleep(3000);
  	
  	driver.findElement(AppiumBy.xpath("(//android.widget.Button[@content-desc=\"BUY NOW\"])[1]")).click();
  	Thread.sleep(3000);
  	
  	driver.findElement(AppiumBy.accessibilityId("Pay ₹939.55")).click();
  	
  	WebElement email = driver.findElement(By.xpath("//android.widget.EditText[@text='Email']"));
    email.click();
    email.sendKeys("harish.hj@kapiva.in");
    driver.hideKeyboard();
    Thread.sleep(1000);
    WebElement password =driver.findElement(By.xpath("//android.widget.ImageView[@index='2']"));
    password.click();
    password.sendKeys("Kapiva@123"); 

    driver.hideKeyboard();
    driver.findElement(By.xpath("//android.widget.Button[@content-desc='Login']")).click();
  	
    Thread.sleep(8000);
    
    driver.findElement(AppiumBy.accessibilityId("Pay ₹939.55")).click();
    Thread.sleep(8000);
    
    String paymentpage=driver.findElement(AppiumBy.xpath("//android.widget.TextView[@index=1]")).getAttribute("text");
    Assert.assertEquals(paymentpage,"Payment Methods");
    if(paymentpage.contains("Payment Methods")) {
	 System.out.println("CheckOutTest_PASS");
    }else{
	System.out.println("CheckOutTest_FAIL");}
	}
}
