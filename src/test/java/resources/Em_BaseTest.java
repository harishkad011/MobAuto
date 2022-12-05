package resources;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class Em_BaseTest {

public AndroidDriver driver;

@BeforeClass
public void Config() throws MalformedURLException, InterruptedException {

DesiredCapabilities cap=new DesiredCapabilities();
cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel");
cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "11");
cap.setCapability(MobileCapabilityType.UDID, "emulator-5554");
cap.setCapability("autoGrantPermissions", true);
cap.setCapability("app", "D:\\Automation\\KapivaMobileAutomation\\src\\test\\java\\resources\\app-release.apk");
//driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), cap);
URL url = new URL("http://127.0.0.1:4723/wd/hub");
driver=new AndroidDriver(url,cap);
driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//driver.switchTo().alert().accept();
//System.out.println("App started in the Real device");
//driver.findElements(AppiumBy.className("android.widget.Button")).get(1).click();

}	
@AfterClass 
public void tearDown(){

	driver.quit();;
  }		
}
