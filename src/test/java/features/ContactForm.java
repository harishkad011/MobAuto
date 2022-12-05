package features;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import resources.BaseTest;

public class ContactForm extends BaseTest {
	
	@Test
	public void ContactFormTest() {
		
	driver.findElement(AppiumBy.xpath("//android.widget.Button[@index='0']")).click();
	driver.findElement(AppiumBy.xpath("//android.view.View[@index='11']")).click();
    driver.findElement(AppiumBy.xpath("//android.widget.Button[@index='3']")).click();
    WebElement name=driver.findElement(By.xpath("//android.widget.EditText[@text='Your Name*']"));
               name.click();
               name.sendKeys("Harish");
    driver.hideKeyboard();
    WebElement email=driver.findElement(By.xpath("//android.widget.EditText[@text='Your Email Address*']"));
               email.click();
               email.sendKeys("harish.hj@kapiva.in");
    driver.hideKeyboard();
    WebElement number=driver.findElement(By.xpath("//android.widget.EditText[@text='Contact Number*']"));
               number.click();
               number.sendKeys("9159575490");
    driver.hideKeyboard();
    WebElement orderno=driver.findElement(By.xpath("//android.widget.EditText[@text='Order Number']"));
               orderno.click();
               orderno.sendKeys("915957");
    driver.hideKeyboard();
    WebElement msg=driver.findElement(By.xpath("//android.widget.EditText[@text='Message']"));
               msg.click();
               msg.sendKeys("testing contact form feature");
    driver.hideKeyboard();
    driver.findElement(AppiumBy.accessibilityId("Send")).click();
    
    String msgtext=driver.findElement(AppiumBy.accessibilityId("Message Received")).getAttribute("content-desc");
    
    Assert.assertEquals(msgtext,"Message Received");
    if(msgtext.contains("Message Received")) {
   	 System.out.println("Contactform test pass");
    }else{
   	 System.out.println("Contactform test fail");
    }
}}
