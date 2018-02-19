package testObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

/*Additional functionalTest super Class to hold all the driver lifecycle management code*/
public class TestObject {
    /*using protected modifier, the driver can be accessed by subclasses*/
    /*using static modifier, the driver can be accessed directly without creating any TestObject object */
    protected static WebDriver driver;

    @BeforeClass
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Dany\\Downloads\\chromedriver_win32\\chromedriver.exe");
        this.driver = new ChromeDriver();
    }

    /*Its not working, looks like the object is null when call to this method*/
    @AfterClass
    public void cleanUp(){
        this.driver.manage().deleteAllCookies();
    }

    @AfterClass
    public void tearDown() {
        this.driver.close();
    }

}
