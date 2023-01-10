package Res;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class BaseTest {
	
	public AndroidDriver driver;
	
	@BeforeClass
	public void Config() throws MalformedURLException {
		
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
	}
	
	@AfterClass
	public void TearDown() {
		driver.quit();
	  }
	} 