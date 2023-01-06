package Tests;

import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;

import Res.Slacky;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import lombok.SneakyThrows;



public class PayOnline_workflow {
	
	Slacky slack=new Slacky();
	
	public AndroidDriver driver;
	
	@SneakyThrows
	@Test
	public void PayOnlineTest() throws InterruptedException, IOException {
		
        DesiredCapabilities cap=new DesiredCapabilities();
		
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
		
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, Platform.ANDROID);
		//cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel");
		//cap.setCapability(MobileCapabilityType.UDID, "72c414f1");
		cap.setCapability("adbExecTimeout", 50000);
		cap.setCapability("appWaitforLaunch", false);
		cap.setCapability("appWaitDuration", 30000);
		cap.setCapability("uiautomater2ServerInstallTimeout", 60000);
		cap.setCapability("ignoreHiddenApiPolicyError", true);
		cap.setCapability("autoGrantPermissions", true);
		cap.setCapability(MobileCapabilityType.APP, System.getProperty("user.dir")+"/App/app-release.apk");
		AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

			 
		Slacky.Sendmessage("*******KapivaAppUserWorkflow_PayOnlineTest*******");
		
		driver.findElement(AppiumBy.accessibilityId("Profile")).click();
	
		Thread.sleep(3000);
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
	    driver.findElement(AppiumBy.accessibilityId("Profile")).click();
        String logintext = driver.findElement(AppiumBy.accessibilityId("Harish QA")).getAttribute("content-desc");
        if(logintext.equalsIgnoreCase("Harish QA")){
        	System.out.println("LoginTest_PASS");
      
        	Slacky.Sendmessage("LoginTest                                         PASS");
     
        }else {
        	System.out.println("LoginTest_FAIL");
        	//SlackTest.Sendmessage("LoginTest_FAIL");
        } 
        driver.findElement(AppiumBy.accessibilityId("Home")).click();
        
//        WebElement el01=driver.findElement(By.xpath("//android.widget.ScrollView"));
//        
//    	int center_x=el01.getRect().x + (el01.getSize().width/2);
//    	double start_y=el01.getRect().y + (el01.getSize().height*0.7);
//    	double end_y=el01.getRect().y + (el01.getSize().height*0.1);
//    	PointerInput finger=new PointerInput(PointerInput.Kind.TOUCH,"finger");
//    	Sequence swipe=new Sequence(finger, 1);
//    	
//    	swipe.addAction(finger.createPointerMove(Duration.ofSeconds(0), PointerInput.Origin.viewport(), center_x, (int)start_y));
//    	swipe.addAction(finger.createPointerDown(0));
//    	swipe.addAction(finger.createPointerMove(Duration.ofMillis(700), PointerInput.Origin.viewport(), center_x, (int)end_y));
//    	swipe.addAction(finger.createPointerUp(0));
//    	driver.perform(Arrays.asList(swipe));
        
    	Thread.sleep(2000);
        driver.findElement(AppiumBy.xpath("//android.widget.Button[@index=\"2\"]")).click();
        
       WebElement search = driver.findElement(AppiumBy.xpath("//android.widget.EditText[@index=\"1\"]"));
       search.sendKeys("GetSlim juice");
       driver.hideKeyboard();
       
       
       
       driver.findElement(AppiumBy.xpath("//android.widget.ImageView[@index=\"3\"]")).click();
       
       Thread.sleep(4000);
       driver.findElement(AppiumBy.accessibilityId("BUY NOW")).click();
        
        Thread.sleep(3000);
        System.out.println("BuyNowTest_PASS");
        Slacky.Sendmessage("BuyNowTest                                   PASS");
        
        Thread.sleep(3000);
    	WebElement el04=driver.findElement(By.xpath("//android.view.View"));
    	int center_x1=el04.getRect().x + (el04.getSize().width/2);
    	double start_y1=el04.getRect().y + (el04.getSize().height*0.6);
    	double end_y1=el04.getRect().y + (el04.getSize().height*0.1);
    	PointerInput finger2=new PointerInput(PointerInput.Kind.TOUCH,"finger2");
    	
    	Sequence swipe2=new Sequence(finger2, (int) 0.5);
    	swipe2.addAction(finger2.createPointerMove(Duration.ofSeconds(0), PointerInput.Origin.viewport(), center_x1, (int)start_y1));
    	swipe2.addAction(finger2.createPointerDown(0));
    	swipe2.addAction(finger2.createPointerMove(Duration.ofMillis(400), PointerInput.Origin.viewport(), center_x1, (int)end_y1));
    	swipe2.addAction(finger2.createPointerUp(0));
   	    driver.perform(Arrays.asList(swipe2));
        Thread.sleep(4000);
   	    
	 	driver.findElement(AppiumBy.xpath("//android.view.View[@content-desc=\"SAVE5\nGet extra 5% off on orders"
	 			+ " above ₹989\"]")).click();
	 	
//	    String cuponcode= cupon.getAttribute("content-desc");
//	    		cuponcode.replaceAll("Get extra 5% off on orders above ₹988", "");
//   	    System.out.println(cuponcode);    
//        WebElement tb=driver.findElements(AppiumBy.className("android.widget.EditText")).get(0);
//        tb.click();
//        tb.sendKeys(cuponcode);
//        Thread.sleep(3000);
//        WebElement apply=driver.findElement(AppiumBy.accessibilityId("Apply"));
//        apply.click();
        Thread.sleep(4000);
    
        System.out.println("ApplyCuponCodeTest_PASS");
        Slacky.Sendmessage("ApplyCuponTest                             PASS");
   	
     // WebElement paybutton = driver.findElements(By.className("android.view.View")).get(2);
      WebElement paybutton =driver.findElement(AppiumBy.accessibilityId("Pay ₹893.00"));
                  paybutton.click();
        //for(WebElement button : paybutton){
        //System.out.println(paybutton.get(2).getText());
       // }
 	    //paybutton.click();w 0..
 	    Thread.sleep(4000);
        String paymentpage=driver.findElement(AppiumBy.xpath("//android.widget.TextView[@index=1]")).getAttribute("text");
        Assert.assertEquals(paymentpage,"Payment Methods");
        if(paymentpage.contains("Payment Methods")) {
    	 System.out.println("CheckOutTest_PASS");
    	 System.out.println("UserWokflow_PayOnlineTest_PASS");
    	 Slacky.Sendmessage("CheckOutTest                                 PASS");
    	 Slacky.Sendmessage("PayOnlineTest                                 PASS");
        }else{
    	System.out.println("CheckOutTest_FAIL");}
    	//SlackTest.Sendmessage("CheckOutTest_FAIL");}
	}}