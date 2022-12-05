package features;

import java.time.Duration;
import org.apache.commons.lang3.time.StopWatch;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import resources.BaseTest;

public class PDPSpeed extends BaseTest {
	 
	//WebDriver driver;
	
  @Test
  public void PDpTest() throws InterruptedException {
	
     StopWatch loadTime = new StopWatch();	
	 Thread.sleep(3000);
	 WebElement sea= driver.findElements(AppiumBy.className("android.widget.Button")).get(1);
	 sea.click();
	 WebElement sea1= driver.findElements(AppiumBy.className("android.widget.EditText")).get(0);
	 sea1.sendKeys("hair");
	 Thread.sleep(3000);
     WebElement sea2= driver.findElements(AppiumBy.className("android.widget.ImageView")).get(0);
	 sea2.click();
	 
     //loadTime.start();
     long start = System.currentTimeMillis();
	 driver.findElement(AppiumBy.xpath("//android.view.View[@content-desc=\"Skin & Hair\"]")).isDisplayed();
	 //ef.isDisplayed();
	 
//	 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//	 boolean appLoaded = wait.until(ExpectedConditions.visibilityOfElementLocated(
//			 AppiumBy.xpath("//android.view.View[@content-desc=\"Skin & Hair\"]"))).isDisplayed();
	 
     //loadTime.stop();
     long finish = System.currentTimeMillis();
     long totalTime = finish - start; 
     System.out.println("Total Time for page load - "+totalTime);
     
     //System.out.println("is App loaded : " +appLoaded);
     //long pageLoadTime_ms = loadTime.getTime();
     //System.out.println(" Load Time: " + pageLoadTime_ms + " milliseconds");
	 Thread.sleep(3000);
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
////	 long start = System.currentTimeMillis();
//	 loadTime.start();
//	 
	 
//	 
//	 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
//	 boolean appLoaded = wait.until(ExpectedConditions.visibilityOfElementLocated(
//			 AppiumBy.xpath("(//android.view.View[@content-desc=\"Hair Care Juice | Hair "
//				 		+ "Fall Control & Hair Growth\"])[2]"))).isDisplayed();
//	 
////	 long finish = System.currentTimeMillis();
//	 loadTime.stop();
//	 
////	 long totalTime = finish - start; 
////	 System.out.println("Total Time for page load - "+totalTime);
//	 System.out.println("is App loaded : " +appLoaded);
//	 long pageLoadTime_ms = loadTime.getTime();
//	 System.out.println(" Load Time: " + pageLoadTime_ms + " milliseconds");
//	 
////	 System.out.println(start);
////	 System.out.println(finish);
	 
	 
	 
//	WebElement search = driver.findElements(AppiumBy.className("android.widget.Button")).get(2);
//	
//	search.click();
//	
	
//	WebElement el01=driver.findElement(By.xpath("//android.widget.ScrollView"));
//      
//  	int center_x=el01.getRect().x + (el01.getSize().width/2);
//  	double start_y=el01.getRect().y + (el01.getSize().height*0.9);
//  	double end_y=el01.getRect().y + (el01.getSize().height*0.1);
//  	PointerInput finger=new PointerInput(PointerInput.Kind.TOUCH,"finger");
//  	Sequence swipe=new Sequence(finger, 1);
//  	
//  	swipe.addAction(finger.createPointerMove(Duration.ofSeconds(0), PointerInput.Origin.viewport(), center_x, (int)start_y));
//  	swipe.addAction(finger.createPointerDown(0));
//  	swipe.addAction(finger.createPointerMove(Duration.ofMillis(700), PointerInput.Origin.viewport(), center_x, (int)end_y));
//  	swipe.addAction(finger.createPointerUp(0));
//  	driver.perform(Arrays.asList(swipe));
//  	Thread.sleep(3000);
//  	
//  	driver.findElement(AppiumBy.xpath("//android.view.View[@content-desc=\"Get Slim Juice ( 1.57K ) ₹1647 ₹1318\"]")).click();
//    Thread.sleep(3000);
//  	  driver.findElement(AppiumBy.accessibilityId("Women Wellness")).click();
//  	  Thread.sleep(3000);
    
//    loadTime.start();
//    boolean appLoaded = new WebDriverWait(driver, 30).until(
//            ExpectedConditions.elementToBeClickable(MobileBy.xpath("any xpath of expected page"))).isDisplayed();
//    
//    loadTime.stop();
//    
//    System.out.println("is App loaded : " +appLoaded);
//    long pageLoadTime_ms = loadTime.getTime();
//    System.out.println(" Load Time: " + pageLoadTime_ms + " milliseconds");
  	 
  }
}
