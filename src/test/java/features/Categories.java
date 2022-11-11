package features;

																																			import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class Categories extends BaseTest {

	@Test
	public void CategoriesListTest() throws InterruptedException {
		
		driver.findElement(AppiumBy.accessibilityId("Categories")).click();
		
		Thread.sleep(3000);
		
		
           driver.findElements(AppiumBy.className("android.view.View")).get(2).click();
		
		Thread.sleep(3000);
		
		
		
//		WebElement solu =driver.findElement(AppiumBy.accessibilityId("Solution"));
//		WebElement ing =driver.findElement(AppiumBy.accessibilityId("Ingredients"));
//		WebElement pro =driver.findElement(AppiumBy.accessibilityId("Product"));		
//		WebElement off =driver.findElement(AppiumBy.accessibilityId("Offers"));
//		WebElement com =driver.findElement(AppiumBy.accessibilityId("Combos"));
//		WebElement shop =driver.findElement(AppiumBy.accessibilityId("Shop All"));
//		
//		Assert.assertEquals(true,solu.isDisplayed());
//		Assert.assertEquals(true,ing.isDisplayed());
//		Assert.assertEquals(true,pro.isDisplayed());
//		Assert.assertEquals(true,off.isDisplayed());
//		Assert.assertEquals(true,com.isDisplayed());
//		Assert.assertEquals(true,shop.isDisplayed());
	}
}
