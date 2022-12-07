package resources;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class Em_BaseTest {

public AndroidDriver driver;
public AppiumDriverLocalService service;

@BeforeClass
public void Config() throws MalformedURLException, InterruptedException {

	service =new AppiumServiceBuilder().withAppiumJS(new File("C:\\Users\\shilpa hk\\AppData\\Roaming\\npm\\"
			+ "node_modules\\appium\\build\\lib\\main.js")).withIPAddress("127.0.0.1").usingPort(4723).build();
	service.start();
	 
	UiAutomator2Options options=new UiAutomator2Options();
	
	options.setDeviceName("Pixel");
	//options.setCapability(MobileCapabilityType.UDID, "emulator-5555");
	options.setCapability("autoGrantPermissions", true);
	options.setCapability(MobileCapabilityType.APP,"D:\\Automation\\KapivaMobileAutomation\\src\\test\\java\\resources\\app-release.apk");
	URL url = new URL("http://127.0.0.1:4723");
	driver=new AndroidDriver(url,options);
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	
	
//DesiredCapabilities cap=new DesiredCapabilities();
//cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
//cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel");
//cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
//cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "11");
//cap.setCapability(MobileCapabilityType.UDID, "emulator-5554");
//cap.setCapability("autoGrantPermissions", true);
//cap.setCapability("app", "D:\\Automation\\KapivaMobileAutomation\\src\\test\\java\\resources\\app-release.apk");
////driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), cap);
//URL url = new URL("http://127.0.0.1:4723/wd/hub");
//driver=new AndroidDriver(url,cap);
//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//driver.switchTo().alert().accept();
//System.out.println("App started in the Real device");
//driver.findElements(AppiumBy.className("android.widget.Button")).get(1).click();

}	
@AfterClass 
public void tearDown(){

	driver.quit();
	service.stop();
  }		
}
