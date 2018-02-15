package testObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.LoginPage;

public abstract class AbstractTest {
    WebDriver driver;
    String url = "https://ar.pinterest.com/";

    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Dany\\Downloads\\chromedriver_win32\\chromedriver.exe");
        this.driver = new ChromeDriver();
    }

    public void tearDown() {
        this.driver.close();
    }

}
