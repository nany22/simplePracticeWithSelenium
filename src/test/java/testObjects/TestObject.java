package testObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

/*Additional functionalTest super Class to hold all the driver lifecycle management code*/
public class TestObject {
    /*using protected modifier, the driver can be accessed by subclasses*/
    /*using static modifier, the driver is common to all instances (or objects) of the class because i is a class level variable
     *only a single copy of static variable is created and shared among all the instances of the class.
     */
    protected static WebDriver driver;

    @BeforeTest
    public void setup() {
        /*Before each test, the browser will be opened and driver is instantiated*/
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Dany\\Downloads\\chromedriver_win32\\chromedriver.exe");
        this.driver = new ChromeDriver();
    }

    /*Its not working, looks like the object is null when call to this method*/
    @AfterTest
    public void cleanUp(){
        this.driver.manage().deleteAllCookies();
    }

    /*quit instead of close because that leaves open the browser process*/
    @AfterTest
    public void tearDown() {
        this.driver.quit();
    }

}
