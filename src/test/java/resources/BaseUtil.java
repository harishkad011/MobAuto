package resources;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class BaseUtil {
	public AndroidDriver driver;
	//public AppiumDriverLocalService service;

	@BeforeClass
	public void Config() throws MalformedURLException, InterruptedException {
		
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
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);



//		service = new AppiumServiceBuilder()
//				.withAppiumJS(new File(
//						"C:\\Users\\shilpa hk\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
//				.withIPAddress("127.0.0.1").usingPort(4723).build();
//		service.start();

//         DesiredCapabilities cap=new DesiredCapabilities();
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
	}
@AfterClass
public void teardown() {
	driver.quit();
       }
	}		

