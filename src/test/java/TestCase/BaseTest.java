package TestCase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Objects;

public class BaseTest {
	protected WebDriver driver ;
	String completeURL;
	String browser = System.getProperty("BROWSER");
	@BeforeTest
	public void setUpDriver() throws MalformedURLException {
		String host = "localhost";
		if(System.getProperty("HUB_HOST")!=null) {
			host=System.getProperty("HUB_HOST");
			
		}
		if(Objects.isNull(browser))
			browser = "Chrome";
		System.out.println("The browser initiated is "+browser);
		DesiredCapabilities dc = new DesiredCapabilities();
		if(browser.equals("firefox")){
			completeURL="http://" + host +":4442/wd/hub";
			dc.setBrowserName("firefox");
			this.driver = new RemoteWebDriver(new URL(completeURL), dc);
		}else {
			completeURL="http://" + host +":4444/wd/hub";
			ChromeOptions options = new ChromeOptions();
			options.addArguments("disable-infobars");
			this.driver = new RemoteWebDriver(new URL(completeURL), options);
			
		}
		
		
		
		//dc.setCapability(capabilityName, value);
		//this.driver =new RemoteWebDriver
		
	}
	@AfterTest
	public void quitDriver() {
		this.driver.quit();
	}

}
