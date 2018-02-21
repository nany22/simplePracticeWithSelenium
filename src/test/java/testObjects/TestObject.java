package testObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

/**
 * This is an Additional functionalTest super Class to hold all the driver lifecycle management code
 * <p>
 * <b>BeforeMethod</b> will be run before each test to make them atomic
 * For more information read <a href="http://testng.org/doc/documentation-main.html#annotations">JavaDoc</a>
 * <b>AfterMethod</b> will be run after each test to make them atomic
 *
 * <b>driver</b> use "protected" modifier, the driver can be accessed by subclasses
 * <b>driver</b> use "static" modifier, the driver is common to all instances (or objects) of the class because i is a class level variable
 * only a single copy of static variable is created and shared among all the instances of the class.
 */

public class TestObject {
    protected static WebDriver driver;

    /**
    * Browser will be opened each time for each test
    */
    @BeforeMethod
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\chromedriver.exe");
        this.driver = new ChromeDriver();
    }

    /**
    * Cookies will be deleted because it is needed user logs out for each tests to be atomic
    * So user is logged out via cookies deleted.
    */
    @AfterMethod
    public void cleanUp(){
        this.driver.manage().deleteAllCookies();
    }

    /**
    * Browser will be closed for each test("quit" is used instead of "close" because that leaves open the browser process)
    */
    @AfterMethod
    public void tearDown() {
        this.driver.quit();
    }
}
