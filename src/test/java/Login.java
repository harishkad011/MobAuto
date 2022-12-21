

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import lombok.SneakyThrows;

public class Login {
	//SlackTest slack=new SlackTest();
	
	@SneakyThrows
	@Test
	public void LoginTest() throws InterruptedException, IOException {
		
		DesiredCapabilities cap=new DesiredCapabilities();
		
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
		
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, Platform.ANDROID);
		
		cap.setCapability("uiautomater2ServerInstallTimeout", 60000);
		cap.setCapability("autoGrantPermissions", true);
		cap.setCapability(MobileCapabilityType.APP, "./App/app-release.apk");
		AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);
		
//		URL url = new URL("http://127.0.0.1:4723/wd/hub");
//		driver=new AndroidDriver(url,cap);
		//SlackTest.Sendmessage("*******Kat*******");

	    //driver.findElement(AppiumBy.xpath("//android.widget.Button[@index='0']")).click();
		 driver.findElement(AppiumBy.accessibilityId("Profile")).click();
		//driver.findElement(AppiumBy.xpath("//android.view.View[@content-desc='Login/Register']")).click();
		//log.click();
		
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
        }else {
        	System.out.println("Failed to Login");
        } 
  }
}
