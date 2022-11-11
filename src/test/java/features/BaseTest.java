package features;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class BaseTest {
	
	public AndroidDriver driver;
	
@SuppressWarnings("deprecation")
@BeforeClass
	public void SetUp() throws MalformedURLException, InterruptedException {
		
	DesiredCapabilities cap=new DesiredCapabilities();
	cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Appium");
	cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Galaxy");
	cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
	cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "11");
	cap.setCapability(MobileCapabilityType.UDID, "R9ZN5046QJP");
	cap.setCapability("appPackage","com.kapiva.app");
	cap.setCapability("appActivity","com.kapiva.app.MainActivity");
	URL url = new URL("http://127.0.0.1:4723/wd/hub");
    driver=new AndroidDriver(url,cap);
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	System.out.println("App started in the Real device");
	driver.findElements(AppiumBy.className("android.widget.Button")).get(2).click();
	}	
@AfterClass 
	public void tearDown(){
	
		driver.quit();;
	}		
}


