package features;

																																			import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import resources.BaseTest;

public class Categories extends BaseTest {

	@Test
	public void CategoriesListTest() throws InterruptedException {
		
	 String actual[] = {"Solution","Ingredients","Product","Offers", "Combos", "Shop All"};
	StringBuffer sb = new StringBuffer();
	      for(int i = 0; i < actual.length; i++) {
	          sb.append(actual[i]);
	       }
	       String str = sb.toString();
	       //System.out.println(str);
	       
	       
		driver.findElement(AppiumBy.accessibilityId("Categories")).click();
		Thread.sleep(3000);
        List<WebElement> som=driver.findElements(AppiumBy.className("android.view.View"));
		//Thread.sleep(5000);
		for(int i1=0; i1<som.size(); i1++) {
		String exp =som.get(i1).getAttribute("content-desc");
		
		if( exp!=null) {
				exp.contains(str);
				System.out.println("pass");
		}else{
			System.out.println("fail");
		}
//		if(exp!=null) {
//		
//			exp.equalsIgnoreCase(exp)
		
		
	  
			
			
		
//			boolean isPresent = false;
//			if() {
//				isPresent = true;
//				System.out.println("pass");
//				Assert.assertEquals(isPresent, true);
//			}else {
//				System.out.println("fail");
//				Assert.assertEquals(isPresent, true);
		
	    }
	}
}
