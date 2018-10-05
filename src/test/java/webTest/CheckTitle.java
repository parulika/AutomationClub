package webTest;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.screentaker.ViewportPastingStrategy;

public class CheckTitle {

	WebDriver driver;
	String pageTitle;
	String path = System.getProperty("user.dir");
	String path2 = "Machintosh HD/Users/parulika/Desktop";

	@SuppressWarnings("deprecation")
	// this is added after addition of capabilities
	@Test
	public void checkPageTitles() throws IOException {
		
		Logger log = LogManager.getLogger(CheckTitle.class.getName());
		
		log.info(path);

		System.setProperty("webdriver.gecko.driver", path
				+ "/driver/geckodriver");// relative path
		log.error("capability required");
		DesiredCapabilities capabilities = new DesiredCapabilities();

		capabilities = DesiredCapabilities.firefox();// optional
		capabilities.setBrowserName("firefox");// optional
		capabilities.setVersion("your firefox version");// optional
		capabilities.setPlatform(Platform.MAC);// optional
		capabilities.setCapability("marionette", false);// must have capability
														// to avoid capability
														// related isues

		driver = new FirefoxDriver(capabilities);
		log.fatal("test data");
		driver.get("https://www.google.com");
		driver.navigate().to("http://www.makemytrip.com");

		// to take full screenshot of any page use AShot class
		/*Screenshot fpScreen = new AShot().shootingStrategy(
				new ViewportPastingStrategy(100)).takeScreenshot(driver);
		ImageIO.write(fpScreen.getImage(), "PNG", new File(
				"Users\\parulika\\Desktop\\result.png"));*/
		pageTitle = driver.getTitle();
		AssertJUnit
				.assertEquals(pageTitle,
						"MakeMyTrip - #1 Travel Website 50% OFF on Hotels, Flights & Holiday");
		log.debug("title check");
		
		/*JavascriptExecutor js = (JavascriptExecutor) driver;  
		   js.executeScript("window.scrollBy(1000)");*/

		
		
	}
	@AfterSuite
	public void killDriver()
	{
		driver.quit();
	}

}
