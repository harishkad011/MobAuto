package Tests;
import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.appium.java_client.AppiumBy;
import lombok.SneakyThrows;
import resources.Basetest;
import resources.SlackTest;

public class Login extends Basetest{
	
	SlackTest slack=new SlackTest();
	//public AndroidDriver driver;
	
	@SneakyThrows
	@Test
	public void LoginTest() throws InterruptedException, IOException {
		
//		DesiredCapabilities cap=new DesiredCapabilities();
//		
//		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
//		
//		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, Platform.ANDROID);
//		//cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel");
//		//cap.setCapability(MobileCapabilityType.UDID, "72c414f1");
//		cap.setCapability("adbExecTimeout", 50000);
//		cap.setCapability("appWaitforLaunch", false);
//		cap.setCapability("appWaitDuration", 30000);
//		cap.setCapability("uiautomater2ServerInstallTimeout", 60000);
//		cap.setCapability("ignoreHiddenApiPolicyError", true);
//		cap.setCapability("autoGrantPermissions", true);
//		cap.setCapability(MobileCapabilityType.APP, System.getProperty("user.dir")+"/App/app-release.apk");
//		AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);
//		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//		
		SlackTest.Sendmessage("*******Kat*******");
		
		Thread.sleep(3000);

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
        }else {
        	System.out.println("Failed to Login");
        } 
  }
}
