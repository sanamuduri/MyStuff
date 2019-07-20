package appiumtests;

import static org.junit.Assert.assertEquals;

import java.net.MalformedURLException;
import java.net.URL;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

/**
 * Test suite
 * @author saritanamuduri
 *
 */
public class QATest {

	private  AppiumDriver<MobileElement> driver;
	private  DesiredCapabilities capabilities ;
	
	//TODO change path according to your settings
	private final String PATH_QATEST = "/Users/saritanamuduri/Library/Developer/Xcode/DerivedData"
	  		+ "/QATest-hhkfzemdfxrvfkbpgxwmelacuoyl/Build/Products"
  		+ "/Debug-iphonesimulator/QATest.app";
	
	@Before
	public void setUp() throws MalformedURLException {
		capabilities = new DesiredCapabilities();
		capabilities.setCapability("platformName", "iOS");
		capabilities.setCapability("platformVersion", "12.2");
		capabilities.setCapability("deviceName", "iPad Air 2");
		capabilities.setCapability("app", PATH_QATEST);
	 
		URL url = new URL("http://0.0.0.0:4723/wd/hub");
	  
		//IOSDriver<IOSElement> driver = new IOSDriver(url, cap);
		driver = new AppiumDriver<MobileElement>(url, capabilities);
	}
	
	@Test
	public void validLoginCredentialsTest() throws Exception {
		MobileElement userName = driver.findElementByXPath("//XCUIElementTypeApplication[@name=\"QATest\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTextField[1]\n"); 
		userName.sendKeys("David");
		
		MobileElement password = driver.findElementByXPath("//XCUIElementTypeApplication[@name=\"QATest\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTextField[2]");
		password.sendKeys("abc1234");
		
		MobileElement loginButton = driver.findElementByXPath("//XCUIElementTypeButton[@name=\"Login\"]");
		loginButton.click();
		
		driver.quit();		
	}
	
	@Test
	public void  oneOfAlbumdisplayDetailsTest() throws Exception {
		MobileElement userName = driver.findElementByXPath("//XCUIElementTypeApplication[@name=\"QATest\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTextField[1]\n"); 
		userName.sendKeys("David");
		
		MobileElement password = driver.findElementByXPath("//XCUIElementTypeApplication[@name=\"QATest\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTextField[2]");
		password.sendKeys("abc1234");
		
		MobileElement loginButton = driver.findElementByXPath("//XCUIElementTypeButton[@name=\"Login\"]");
		loginButton.click();
		
		Thread.sleep(2000);
		
		MobileElement albumElement = driver.findElementByXPath("//XCUIElementTypeApplication"
				+ "[@name=\"QATest\"]/XCUIElementTypeWindow[1]"
				+ "/XCUIElementTypeOther/XCUIElementTypeOther"
				+ "/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeCollectionView/XCUIElementTypeCell[1]/XCUIElementTypeOther"); 
		
		Thread.sleep(5000);
		albumElement.click();
		Thread.sleep(1000);
		MobileElement albumInfo = driver.findElementById("Taylor Swift");
		assertEquals("Taylor Swift", albumInfo.getText());
		
		driver.quit();		
	}
	
	
	@Test
	public void usernameWithMaxCharactersTest() throws Exception {
		MobileElement userName = driver.findElementByXPath("//XCUIElementTypeApplication[@name=\"QATest\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTextField[1]\n"); 
		userName.sendKeys("David12345678910111213141516171819!_°W°EEEE");
				
		MobileElement okButton = driver.findElementById("Ok");
		Thread.sleep(5000);
		okButton.click();			
		driver.quit();		
	}
	
	@Test
	public void logoutTest() throws Exception {
		MobileElement userName = driver.findElementByXPath("//XCUIElementTypeApplication[@name=\"QATest\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTextField[1]\n"); 
		userName.sendKeys("David");
		
		MobileElement password = driver.findElementByXPath("//XCUIElementTypeApplication[@name=\"QATest\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTextField[2]");
		password.sendKeys("abc1234");
		
		MobileElement loginButton = driver.findElementByXPath("//XCUIElementTypeButton[@name=\"Login\"]");
		loginButton.click();
			
		MobileElement logout = driver.findElementById("Logout");
		
		assertEquals("Logout", logout.getText());
		
		logout.click();
		Thread.sleep(5000);
		driver.quit();		
	}
	@Test
	public void invalidLoginCredentialsTest() {
		MobileElement userName = driver.findElementByXPath("//XCUIElementTypeApplication[@name=\"QATest\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTextField[1]\n"); 
		userName.sendKeys("David2");
		
		MobileElement password = driver.findElementByXPath("//XCUIElementTypeApplication[@name=\"QATest\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTextField[2]");
		password.sendKeys("invalid");
		
		MobileElement loginButton = driver.findElementByXPath("//XCUIElementTypeButton[@name=\"Login\"]");
		loginButton.click();
		driver.quit();
		
	}
	@Test
	public void albumDisplayUsernameTest() throws Exception {
		MobileElement userName = driver.findElementByXPath("//XCUIElementTypeApplication[@name=\"QATest\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTextField[1]\n"); 
		userName.sendKeys("Mike");		
		MobileElement password = driver.findElementByXPath("//XCUIElementTypeApplication[@name=\"QATest\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTextField[2]");
		password.sendKeys("abc123456");
		MobileElement loginButton = driver.findElementByXPath("//XCUIElementTypeButton[@name=\"Login\"]");
		loginButton.click();
			
		MobileElement nameAlbum = driver.findElementByXPath("//XCUIElementTypeOther[@name=\"Mike Albums\"]");
		assertEquals("Mike Albums", nameAlbum.getText());
		driver.quit();		
	}
	
	@Test
	public void goBackToSelectDifferentAlbumTest() throws Exception {
		MobileElement userName = driver.findElementByXPath("//XCUIElementTypeApplication[@name=\"QATest\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTextField[1]\n"); 
		userName.sendKeys("Mike");		
		MobileElement password = driver.findElementByXPath("//XCUIElementTypeApplication[@name=\"QATest\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTextField[2]");
		password.sendKeys("abc123456");
		MobileElement loginButton = driver.findElementByXPath("//XCUIElementTypeButton[@name=\"Login\"]");
		loginButton.click();
		MobileElement albumElement = driver.findElementByXPath("//XCUIElementTypeApplication"
				+ "[@name=\"QATest\"]/XCUIElementTypeWindow[1]"
				+ "/XCUIElementTypeOther/XCUIElementTypeOther"
				+ "/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeCollectionView/XCUIElementTypeCell[1]/XCUIElementTypeOther"); 
		
		albumElement.click();
		
	    Thread.sleep(3000);
	 
		MobileElement albumInfo = driver.findElementById("Taylor Swift");
		assertEquals("Taylor Swift", albumInfo.getText());
	    
		MobileElement backButton = driver.findElementById("Mike Albums");
		backButton.click();
		Thread.sleep(2000);
		
		MobileElement albumElement2 = driver.findElementByXPath("//XCUIElementTypeApplication"
				+ "[@name=\"QATest\"]/XCUIElementTypeWindow[1]"
				+ "/XCUIElementTypeOther/XCUIElementTypeOther"
				+ "/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeCollectionView/XCUIElementTypeCell[2]/XCUIElementTypeOther"); 
		
		albumElement2.click();
		Thread.sleep(2000);
		MobileElement albumInfo2 = driver.findElementById("Fearless");
		assertEquals("Fearless", albumInfo2.getText());
		driver.quit();
	}
	
	@After
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}
	
}
