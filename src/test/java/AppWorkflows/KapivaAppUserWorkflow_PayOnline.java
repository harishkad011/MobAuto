package AppWorkflows;
import java.io.IOException;
import java.time.Duration;
import java.util.Arrays;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import resources.BaseTest;
import resources.Em_BaseTest;
import resources.SlackTest;


public class KapivaAppUserWorkflow_PayOnline extends Em_BaseTest {
		SlackTest slack=new SlackTest();
		@Test
		public void UserWokflow_PayOnline() throws InterruptedException, IOException {
				 
			SlackTest.Sendmessage("*******KapivaAppUserWorkflow_PayOnlineTest*******");
//			driver.findElement(AppiumBy.xpath("//android.widget.Button[@index='0']")).click();
//			driver.findElement(AppiumBy.accessibilityId("Login/Register")).click();
			driver.findElement(AppiumBy.accessibilityId("Profile")).click();
			Thread.sleep(3000);
			WebElement email = driver.findElement(By.xpath("//android.widget.EditText[@text='Email']"));
	                   email.click();
			           email.sendKeys("harish.hj@kapiva.in");
		    driver.hideKeyboard();
		    Thread.sleep(3000);
		    WebElement password =driver.findElement(By.xpath("//android.widget.ImageView[@index='2']"));
		    password.click();
		    password.sendKeys("Kapiva@123"); 	
	        driver.hideKeyboard();
	        driver.findElement(By.xpath("//android.widget.Button[@content-desc='Login']")).click();
	        driver.findElement(AppiumBy.accessibilityId("Profile")).click();
	        String logintext = driver.findElement(AppiumBy.accessibilityId("Harish QA")).getAttribute("content-desc");
	        if(logintext.equalsIgnoreCase("Harish QA")){
	        	System.out.println("LoginTest_PASS");
	      
	        SlackTest.Sendmessage("LoginTest                                         PASS");
	     
	        }else {
	        	System.out.println("LoginTest_FAIL");
	        	SlackTest.Sendmessage("LoginTest_FAIL");
	        } 
	        driver.findElement(AppiumBy.accessibilityId("Home")).click();
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
	        
	        System.out.println("BuyNowTest_PASS");
	        SlackTest.Sendmessage("BuyNowTest                                   PASS");
	        
	        Thread.sleep(4000);
	    	WebElement el04=driver.findElement(By.xpath("//android.view.View"));
	    	int center_x1=el04.getRect().x + (el04.getSize().width/2);
	    	double start_y1=el04.getRect().y + (el04.getSize().height*0.7);
	    	double end_y1=el04.getRect().y + (el04.getSize().height*0.1);
	    	PointerInput finger2=new PointerInput(PointerInput.Kind.TOUCH,"finger2");
	    	
	    	Sequence swipe2=new Sequence(finger2, (int) 0.5);
	    	swipe2.addAction(finger2.createPointerMove(Duration.ofSeconds(0), PointerInput.Origin.viewport(), center_x1, (int)start_y1));
	    	swipe2.addAction(finger2.createPointerDown(0));
	    	swipe2.addAction(finger2.createPointerMove(Duration.ofMillis(400), PointerInput.Origin.viewport(), center_x1, (int)end_y1));
	    	swipe2.addAction(finger2.createPointerUp(0));
	   	    driver.perform(Arrays.asList(swipe2));
            Thread.sleep(4000);
	   	    
		 	WebElement cupon=driver.findElement(AppiumBy.xpath("//android.view.View[@index='7']"));
    	    String cuponcode= cupon.getAttribute("content-desc").replaceAll("Get extra 5% off on orders above ₹989", "");
	   	    System.out.println(cuponcode);    
            WebElement tb=driver.findElements(AppiumBy.className("android.widget.EditText")).get(0);
            tb.click();
            tb.sendKeys(cuponcode);
            driver.findElement(AppiumBy.accessibilityId("Apply")).click();
	        Thread.sleep(5000);
	    
	        System.out.println("ApplyCuponCodeTest_PASS");
	        SlackTest.Sendmessage("ApplyCuponTest                             PASS");
	     	
	 	    WebElement paybutton =driver.findElement(AppiumBy.accessibilityId("Pay ₹1309.00"));
	 	    paybutton.click();
	 	    Thread.sleep(4000);
	        String paymentpage=driver.findElement(AppiumBy.xpath("//android.widget.TextView[@index=1]")).getAttribute("text");
	        Assert.assertEquals("Payment Methods", paymentpage);
	        if(paymentpage.contains("Payment Methods")) {
	    	 System.out.println("CheckOutTest_PASS");
	    	 System.out.println("UserWokflow_PayOnlineTest_PASS");
	    	SlackTest.Sendmessage("CheckOutTest                                 PASS");
		    SlackTest.Sendmessage("PayOnlineTest                                 PASS");
	        }else{
	    	System.out.println("CheckOutTest_FAIL");
	    	SlackTest.Sendmessage("CheckOutTest_FAIL");
	       }
		}
	}       
//
//SlackTest.Sendmessage("LoginTest                                         PASS");
//SlackTest.Sendmessage("BuyNowTest                                   PASS");
//SlackTest.Sendmessage("ApplyCuponTest                             PASS");
//SlackTest.Sendmessage("CheckOutTest                                 PASS");
//SlackTest.Sendmessage("PayOnlineTest                                 PASS");


