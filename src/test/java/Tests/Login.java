package Tests;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Res.Slacky;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import lombok.SneakyThrows;


public class Login {
	
	public AndroidDriver driver;
	
	@SneakyThrows
	@Test
	public void LoginTest() throws InterruptedException, IOException {
		
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
	
		WebElement cl=driver.findElement(AppiumBy.accessibilityId("Profile"));
        cl.click();
	
		Thread.sleep(3000);
		WebElement email = driver.findElement(By.xpath("//android.widget.EditText[@text='Email']"));
        email.click();
        email.sendKeys("harish.hj@kapiva.in");
	    driver.hideKeyboard();
	    WebElement password =driver.findElement(By.xpath("//android.widget.ImageView[@index='2']"));
	               password.click();
	               password.sendKeys("Kapiva@123"); 	
	    driver.hideKeyboard();
        driver.findElement(By.xpath("//android.widget.Button[@content-desc='Login']")).click();
        driver.findElement(AppiumBy.accessibilityId("Profile")).click();
        String logintext = driver.findElement(AppiumBy.accessibilityId("Harish QA")).getAttribute("content-desc");
       
        Assert.assertEquals("Harish QA",logintext );
        if(logintext.equalsIgnoreCase("Harish QA")){
        	System.out.println("Logged in Successfully");
        	//SlackTest.Sendmessage("Logged in Successfully");
        }else {
        	System.out.println("Failed to Login");
        }      
        driver.findElement(AppiumBy.accessibilityId("Home")).click();
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
	 	
}   }