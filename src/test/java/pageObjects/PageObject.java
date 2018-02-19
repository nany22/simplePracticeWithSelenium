package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class PageObject {
    /*using protected modifier, the driver can be accessed by subclasses*/
    /*using static modifier, the driver can be accessed directly without creating any TestObject object */
    protected static WebDriver driver;

    /*Constructor: Send the driver and page needed. Always will use the same driver and different page needed */
    public PageObject(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

}
