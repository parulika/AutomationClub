package webTest;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckTitle {
	
	WebDriver driver;
	String pageTitle;
	String path = System.getProperty("user.dir");
	String path2 = "Machintosh HD/Users/parulika/Desktop";
	
	
	@SuppressWarnings("deprecation")
	@Test
	public void checkPageTitles()
	{
		System.out.println(path);
		
		System.setProperty("webdriver.gecko.driver", path+"/driver/geckodriver");
		
		DesiredCapabilities capabilities = new DesiredCapabilities();

		// capabilities = DesiredCapabilities.firefox();
		// capabilities.setBrowserName("firefox");
		// capabilities.setVersion("your firefox version");
		// capabilities.setPlatform(Platform.MAC);
		 capabilities.setCapability("marionette", false);

		driver = new FirefoxDriver(capabilities);
		driver.get("https://www.google.com");
		pageTitle = driver.getTitle();
		AssertJUnit.assertEquals(pageTitle, "Google");
	}

}
