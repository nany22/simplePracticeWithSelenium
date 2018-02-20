package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class PageObject {
    /*using protected modifier, the driver can be accessed by subclasses*/
    /*using static modifier, the driver is common to all instances (or objects) of the class because i is a class level variable
    *only a single copy of static variable is created and shared among all the instances of the class.
    */
    protected static WebDriver driver;

    /*Constructor: using PageFactory pattern.It sends the driver and page needed.*/
    public PageObject(WebDriver driver){
        this.driver = driver;
        /*pageFactory inicialize webelements using an EXPLICIT wait, it means any search for element on the page could take the time the explicit wait is*/
        /*@findby has a lazy initialization, executing that only when element is used*/
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 20), this);
    }

}
