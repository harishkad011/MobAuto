package Tests;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;
import Res.BaseTest;
import Res.Slacky;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class AppLogin {
	
	public AndroidDriver driver;
	
	@Test
	public void AppLoginTest() throws InterruptedException {
		
		DesiredCapabilities cap=new DesiredCapabilities();
		
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, Platform.ANDROID);
		cap.setCapability("adbExecTimeout", 50000);
		cap.setCapability("appWaitforLaunch", false);
		cap.setCapability("appWaitDuration", 30000);
		cap.setCapability("uiautomater2ServerInstallTimeout", 60000);
		cap.setCapability("ignoreHiddenApiPolicyError", true);
		cap.setCapability("autoGrantPermissions", true);
		cap.setCapability(MobileCapabilityType.APP, System.getProperty("user.dir")+"/App/app-release.apk");
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
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
  
    	//Slacky.Sendmessage("LoginTest                                         PASS");
 
    }else {
    	System.out.println("LoginTest_FAIL");
    	//SlackTest.Sendmessage("LoginTest_FAIL");
    } 
  }
}