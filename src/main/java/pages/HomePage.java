package pages;

import org.openqa.selenium.WebElement;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class HomePage extends BasePage {

	public HomePage(AppiumDriver driver) {
		super(driver);
	}

	@AndroidFindBy(id = "com.solodroid.solomerce:id/search")
	public WebElement searchIcon;

	@AndroidFindBy(id = "com.solodroid.solomerce:id/search_src_text")
	public WebElement searchTextBox;

	@AndroidFindBy(id = "com.solodroid.solomerce:id/category_image")
	public WebElement searchResultImage;

	@AndroidFindBy(id = "com.solodroid.solomerce:id/btn_add_cart")
	public WebElement addToCartButton;

	@AndroidFindBy(id = "com.solodroid.solomerce:id/userInputDialog")
	public WebElement orderInputBox;

	@AndroidFindBy(id = "android:id/button1")
	public WebElement addButton;

	@AndroidFindBy(id = "com.solodroid.solomerce:id/cart")
	public WebElement cartIcon;

	@AndroidFindBy(id = "com.solodroid.solomerce:id/btn_checkout")
	public WebElement checkoutButton;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Shopping Cart']")
	public WebElement shoppingcartLabel;

}
