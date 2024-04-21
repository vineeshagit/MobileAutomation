package automation;

import java.net.MalformedURLException;

import org.testng.annotations.Test;

//import io.appium.java_client.AppiumDriver;
//import io.appium.java_client.android.AndroidDriver;
import pages.HomePage;

public class homePageTest extends BaseTest {

	@Test
	public static void addProductToCart() throws MalformedURLException {

		driver = BaseTest.getDriver("android");
		HomePage hp = new HomePage(driver);
		hp.searchIcon.click();
		hp.searchTextBox.sendKeys("Apple");
		hp.searchResultImage.click();
		hp.addToCartButton.click();
		hp.orderInputBox.click();
		hp.orderInputBox.sendKeys("1");
		hp.addButton.click();

	}
}
