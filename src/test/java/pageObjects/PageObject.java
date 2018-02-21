package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

/**
 * This is an Additional functionalPage super Class to hold common driver initialization
 *
 * driver use "protected" modifier, so the driver can be accessed by subclasses
 * driver use "static" modifier, because it is common to all instances (or objects) of the class (is a class level variable)
 * only a single copy of static variable is created and shared among all the instances of the class.
 */

public class PageObject {
    protected static WebDriver driver;

    /**
     * Constructor: using PageFactory pattern.It sends the driver and page needed.
     * <a href = "https://en.wikipedia.org/wiki/Factory_method_pattern"><b>pageFactory</b></a> inicialize webelements using an EXPLICIT wait,
     * it means any search for element on the page could take the time the explicit wait is
     * <b>findby</b> has a lazy initialization, executing that only when element is used
     * @param driver is sent from pages classes constructors
     */
    public PageObject(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 20), this);
    }
}
