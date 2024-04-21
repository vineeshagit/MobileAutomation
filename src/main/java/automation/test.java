package automation;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Arrays;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.PointerInput.Kind;
import org.openqa.selenium.interactions.PointerInput.Origin;
import org.openqa.selenium.interactions.Sequence;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;

public class test {
	AppiumDriverLocalService server; // appuimdriver(intialising globally for start and stop) is a class to start
										// server

	@BeforeTest
	public void startServer() {

//		server = new AppiumServiceBuilder()
//				.withAppiumJS(new File("C:\\Users\\chidr\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
//				.withIPAddress("127.0.0.1").usingPort(4723).build();
//		server.start();
	}

	@BeforeMethod
	public void setUp() {

	}

	@AfterTest
	public void stopServer() {
		server.stop();
	}

	public static void scrollDown() {
//		org.openqa.selenium.Dimension size = driver.manage().window().getSize();
//		int startY = (int) (size.height * 0.70);
//		int endY = (int) (size.height * 0.30);
//		int centre = size.width / 2;
//		System.out.println("start position: " + startY + " end position: " + endY);
//
//		PointerInput finger = new PointerInput(Kind.TOUCH, "finger");
//		Sequence swipe = new Sequence(finger, 0);
//		swipe.addAction(finger.createPointerMove(Duration.ofSeconds(0), Origin.viewport(), centre, (int) startY));
//		swipe.addAction(finger.createPointerDown(0));
//		swipe.addAction(finger.createPointerMove(Duration.ofSeconds(1), Origin.viewport(), centre, (int) endY));
//		swipe.addAction(finger.createPointerUp(0));
//		driver.perform(Arrays.asList(swipe));

		WebElement ele = driver.findElement(AppiumBy.id(""));
		org.openqa.selenium.Dimension size = driver.manage().window().getSize();
		int startY = (int) (size.height * 0.70);
		int endY = (int) (size.height * 0.30);
		int centre = size.width / 2;
		System.out.println(centre);
		System.out.println("Start postion: " + startY + " End position: " + endY);
		PointerInput finger = new PointerInput(Kind.TOUCH, "finger");
		Sequence swipe = new Sequence(finger, 0);
		swipe.addAction(finger.createPointerMove(Duration.ofSeconds(0), Origin.viewport(), centre, (int) startY));
		swipe.addAction(finger.createPointerDown(0));
		swipe.addAction(finger.createPointerMove(Duration.ofSeconds(1), Origin.viewport(), centre, (int) endY));
		swipe.addAction(finger.createPointerUp(0));

		PointerInput finger2 = new PointerInput(Kind.TOUCH, "finger2");
		Sequence swipe2 = new Sequence(finger, 0);
		swipe.addAction(finger2.createPointerMove(Duration.ofSeconds(0), Origin.viewport(), centre, (int) startY));
		swipe.addAction(finger2.createPointerDown(0));
		swipe.addAction(finger2.createPointerMove(Duration.ofSeconds(1), Origin.viewport(), centre, (int) endY));
		swipe.addAction(finger2.createPointerUp(0));

		driver.perform(Arrays.asList(swipe, swipe2));

	}

	@Test
	public void launchApp() throws MalformedURLException, InterruptedException {
		UiAutomator2Options uio = new UiAutomator2Options();
		URL url = new URL("http://127.0.0.1:4723/");
		uio.setPlatformName("ANDROID");
		uio.setDeviceName("realme");
		uio.setPlatformVersion("12");
		uio.setAutomationName("UIAutomator2");
		uio.setAppPackage("com.solodroid.solomerce");
		uio.setAppActivity("com.solodroid.solomerce.activities.MainActivity");
		AndroidDriver driver = new AndroidDriver(url, uio);
		driver.lockDevice();
		Thread.sleep(5000);
		String container = "new UiSelector().resourceId(\"com.solodroid.solomerce:id/recycler_view\")";
		driver.findElement(AppiumBy
				.androidUIAutomator("new UiScrollable(" + container + ")" + ".scrollIntoView(new UiSelector().textContains(\"Money Counter\"))"))
				.click();
	}

	static AndroidDriver driver = null;

//	public static void main(String[] args) throws MalformedURLException, InterruptedException {
//		UiAutomator2Options uio = new UiAutomator2Options();
//		URL url = new URL("http://127.0.0.1:4723/");
//		uio.setPlatformName("ANDROID");
//		uio.setDeviceName("realme");
//		uio.setPlatformVersion("12");
//		uio.setAutomationName("UIAutomator2");
//		uio.setAppPackage("com.solodroid.solomerce");
//		uio.setAppActivity("com.solodroid.solomerce.activities.MainActivity");
//		AndroidDriver driver = new AndroidDriver(url, uio);
//		driver.findElement(By.id("com.solodroid.solomerce:id/search")).click();
//		driver.findElement(By.id("com.solodroid.solomerce:id/search_src_text")).sendKeys("LED TV");
//		driver.hideKeyboard();
//		if (driver.getOrientation().equals(ScreenOrientation.PORTRAIT)) {
//			driver.rotate(ScreenOrientation.LANDSCAPE);
//		}
//		driver.rotate(ScreenOrientation.PORTRAIT);
//		HashMap<String, String> arg1 = new HashMap<String, String>();
//		arg1.put("direction", "up");
//		driver.executeScript("mobile: pinch", arg1);
//
//		driver.lockDevice();
//		Thread.sleep(5000);
//	}

}
