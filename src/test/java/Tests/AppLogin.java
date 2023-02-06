package Tests;

import java.net.MalformedURLException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import Res.BaseTest;
import Res.Slacky;
import io.appium.java_client.AppiumBy;

public class AppLogin extends BaseTest {
	
	@Test
	public void AppLoginTest() throws InterruptedException, MalformedURLException {
		
		
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