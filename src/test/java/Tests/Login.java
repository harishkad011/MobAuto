package Tests;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import lombok.SneakyThrows;


public class Login {
	
	public AndroidDriver driver;
	
	@BeforeMethod
	public void Setup() throws MalformedURLException {
	
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
	}
	
	@SneakyThrows
	@Test
	public void LoginTest() throws InterruptedException, IOException {
		

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
        } }
        
        @Test
        public void BuyNowTest() throws InterruptedException {
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
  }
}
