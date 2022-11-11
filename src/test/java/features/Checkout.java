package features;
import java.time.Duration;
import java.util.Arrays;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.testng.annotations.Test;
import io.appium.java_client.AppiumBy;

public class Checkout extends BaseTest {
	
	@Test
	public void CheckoutTest() throws InterruptedException {
		
		driver.findElement(AppiumBy.xpath("//android.widget.Button[@index='0']")).click();
		driver.findElement(AppiumBy.accessibilityId("Login/Register")).click();
		WebElement email = driver.findElement(By.xpath("//android.widget.EditText[@text='Email']"));
                email.click();
		           email.sendKeys("harish.hj@kapiva.in");
	    driver.hideKeyboard();
	    WebElement password =driver.findElement(By.xpath("//android.widget.ImageView[@index='2']"));
	               password.click();
	               password.sendKeys("Kapiva@123");
        driver.hideKeyboard();
        driver.findElement(By.xpath("//android.widget.Button[@content-desc='Login']")).click();
        
        WebElement el01=driver.findElement(By.xpath("//android.widget.ScrollView"));
        
    	int center_x=el01.getRect().x + (el01.getSize().width/2);
    	double start_y=el01.getRect().y + (el01.getSize().height*0.9);
    	double end_y=el01.getRect().y + (el01.getSize().height*0.1);
    	PointerInput finger=new PointerInput(PointerInput.Kind.TOUCH,"finger");
    	Sequence swipe=new Sequence(finger, 1);
    	
    	swipe.addAction(finger.createPointerMove(Duration.ofSeconds(0), PointerInput.Origin.viewport(), center_x, (int)start_y));
    	swipe.addAction(finger.createPointerDown(0));
    	swipe.addAction(finger.createPointerMove(Duration.ofMillis(700), PointerInput.Origin.viewport(), center_x, (int)end_y));
    	swipe.addAction(finger.createPointerUp(0));
    	driver.perform(Arrays.asList(swipe));
    	Thread.sleep(2000);
        driver.findElement(AppiumBy.xpath("(//android.widget.Button[@content-desc=\"BUY NOW\"])[1]")).click();
        
//    	WebElement el03=driver.findElement(AppiumBy.accessibilityId("Cash on Delivery"));	

    	WebElement el04=driver.findElement(By.xpath("//android.view.View"));
    	int center_x1=el04.getRect().x + (el04.getSize().width/2);
    	double start_y1=el04.getRect().y + (el04.getSize().height*0.5);
    	double end_y1=el04.getRect().y + (el04.getSize().height*0.1);
    	PointerInput finger2=new PointerInput(PointerInput.Kind.TOUCH,"finger2");
    	
    	Sequence swipe2=new Sequence(finger2, (int) 0.5);
    	swipe2.addAction(finger2.createPointerMove(Duration.ofSeconds(0), PointerInput.Origin.viewport(), center_x1, (int)start_y1));
    	swipe2.addAction(finger2.createPointerDown(0));
    	swipe2.addAction(finger2.createPointerMove(Duration.ofMillis(400), PointerInput.Origin.viewport(), center_x1, (int)end_y1));
    	swipe2.addAction(finger2.createPointerUp(0));
   	   driver.perform(Arrays.asList(swipe2));
     	Thread.sleep(5000);
    	
 	    driver.findElement(AppiumBy.xpath("//android.view.View[@content-desc='Pay ₹1298.00']")).click();
 	    Thread.sleep(5000);
 	    
     String paymentpage=driver.findElement(AppiumBy.xpath("//android.widget.TextView[@index=1]")).getAttribute("text");
     if(paymentpage.contains("Payment Methods")) {
    	 System.out.println("Test Pass");
     }else{
    	 System.out.println("Test fail");
     }
}}
