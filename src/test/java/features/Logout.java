package features;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import resources.BaseTest;

public class Logout extends BaseTest {
	
	@Test
    public void LogoutTest() throws MalformedURLException, InterruptedException {
		
		    driver.findElement(AppiumBy.xpath("//android.widget.Button[@index='0']")).click();
			driver.findElement(AppiumBy.accessibilityId("Login/Register")).click();
			WebElement email = driver.findElement(By.xpath("//android.widget.EditText[@text='Email']"));
	                   email.click();
			           email.sendKeys("harish.hj@kapiva.in");
		    driver.hideKeyboard();
		    WebElement password =driver.findElement(By.xpath("//android.widget.ImageView[@index='2']"));
		               password.click();
		               password.sendKeys("Kapiva@123");
	        driver.hideKeyboard();
	        driver.findElement(By.xpath("//android.widget.Button[@content-desc='Login']")).click();
	        driver.findElement(AppiumBy.xpath("//android.widget.Button[@index='0']")).click();
		    driver.findElement(AppiumBy.accessibilityId("Logout")).click();
		    driver.findElement(AppiumBy.accessibilityId("Ok")).click();
		
		String logouttext = driver.findElement(AppiumBy.accessibilityId("Logout successful")).getAttribute("content-desc");
		
        Assert.assertEquals("Logout successful",logouttext );
       
       if(logouttext.equalsIgnoreCase("Logout successful")){
       	System.out.println("Logged out Successfully");
       }else {
       	System.out.println("Failed to LogOut");
       } 
    }
}
