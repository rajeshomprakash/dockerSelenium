package TestCase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.net.MalformedURLException;
import java.net.URL;


public class BaseTest {
	protected WebDriver driver ;
	String completeURL;
	@BeforeTest
	public void setUpDriver() throws MalformedURLException {
		String host = "localhost";
		if(System.getProperty("HUB_HOST")!=null) {
			host=System.getProperty("HUB_HOST");
			
		}
		DesiredCapabilities dc = new DesiredCapabilities();
		if(System.getProperty("BROWSER") !=null && System.getProperty("BROWSER").equalsIgnoreCase("firefox")){
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
