package util.screens;

import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

import util.CustomWait;
import org.openqa.selenium.Dimension;

import java.time.Duration;
import static java.lang.String.format;
import java.util.List;
import org.openqa.selenium.support.PageFactory;
import org.pmw.tinylog.Logger;

/**
 * Base class for all Screen Objects.
 * 
 */
public abstract class BaseScreen {
	/** The driver. */
	protected AndroidDriver<AndroidElement> driver;
	protected CustomWait customWait = new CustomWait();

	/**
	 * Constructor method for standard screen object.
	 * 
	 * @param driver : AndroidDriver
	 */
	public BaseScreen(AndroidDriver<AndroidElement> pDriver) {
		this.driver = pDriver;
		initElements();
	}

	/**
	 * Page factory.
	 */
	private void initElements() {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	/**
	 * Tab on back button.
	 */
	public void tapBack() {
		driver.navigate().back();
	}
	
	

	/**
	 * Scroll to the text attribute received by parameter.
	 *
	 * @param text : String
	 */
	public void scrollToText(String text) {
		String automator = "new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().textContains(\"%s\"))";
		AndroidElement textOnElement = driver.findElementByAndroidUIAutomator(format(automator, text));
		Logger.info(textOnElement.getText());
	}
	public void clickOn(AndroidElement element){
		element.click();
	}
	public String getAttribute(AndroidElement element, String attribute){
		return element.getAttribute(attribute);
	}
	
	public boolean isPresent(List<AndroidElement> elements){
		return elements.size() != 0;    
	}
	
	public boolean isEnabled(AndroidElement elements){
		return elements.isEnabled();   
	}
	
	public boolean isDispleyed(AndroidElement elements){
		return elements.isDisplayed();   
	}
	
	
	public String getText(AndroidElement element){
		String text = element.getText();
		return text;
	}
	public void sendKey(AndroidElement element, String text){
		element.sendKeys(text);
	}
	public void scrollAtions(AndroidElement slider) {
		Dimension dimension = driver.manage().window().getSize();
	    int scrollStart = (int) (dimension.getHeight() * 0.5);
	    int scrollEnd = (int) (dimension.getHeight() * 0.2);{
			new TouchAction((PerformsTouchActions) driver) 
	        .press(PointOption.point(0, scrollStart)) 
	        .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1))) 
	        .moveTo(PointOption.point(0, scrollEnd)) 
	        .release().perform();
	    }}

	
	public AndroidElement findElementByUISelector(String element) {
		AndroidElement elementMobile =driver.findElementByAndroidUIAutomator(element);
		return elementMobile;
	}

	
}
