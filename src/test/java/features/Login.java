package features;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.appium.java_client.AppiumBy;

public class Login extends BaseTest{
	
	@Test
	public void ValidTest() throws MalformedURLException, InterruptedException {
		
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
        driver.findElement(AppiumBy.accessibilityId("Profile")).click();
        String logintext = driver.findElement(AppiumBy.accessibilityId("Harish QA")).getAttribute("content-desc");
        //System.out.println(logintext);
        Assert.assertEquals(logintext, "Harish QA");
        
        if(logintext.equalsIgnoreCase("Harish QA")){
        	System.out.println("Logged in Successfully");
        }else {
        	System.out.println("Failed to Login");
        } 
   }
}