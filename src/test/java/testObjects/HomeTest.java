package testObjects;

import org.testng.Assert;
import org.testng.annotations.*;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import utils.Navigation;

/**
 * This class will have all possible tests related to the page LoginPage
 * The initialization of classes needs to be done AFTER goto the URL that redirects to you to the page,
 * so after you are in the page, you now can instantiate that
 * <p>
 * <b>BeforeMethod</b> in TestNG will be run before each test in the class. (BeforeTest only run before the first test in the class)
 * For more information read <a href="http://testng.org/doc/documentation-main.html#annotations">JavaDoc</a>
 * <b>After</b> each test, cookies will be deleted (on super class) because it is needed tests are atomic and user is logged out
 * <p>
 * HomePage class is initialized in the LoginPage class when clicking the submit button. therefore here is not a new HomePage(driver)
 */

public class HomeTest extends TestObject {
    String emailAddress = "danielaojeda22@gmail.com";
    String password = "30132371";
    String homeTab = "continue as a business";

    /**
     * Before run this setup, will run setup in the superclass {@link TestObject}
     * Initialize Navigation class to then be able to go to needed URL on each page
     */
    @BeforeMethod
    public void setupTest(){
        Navigation navigation = new Navigation(driver);
        navigation.gotoLoginPage();
    }

    /**
     * Do Logs in, and checks INICIO tab is shown
     */
    @Test(description="Validate you are logged in",priority = 1)
    public void verifyLoginPage (){
        LoginPage loginPageObject = new LoginPage(driver);
        HomePage homePageObject = loginPageObject.loginToPage(emailAddress,password);
        String inicioTabText = homePageObject.getInicioTab();
        Assert.assertTrue(inicioTabText.toLowerCase().contentEquals(homeTab), "does not match");
    }

    /**
     * Do Logs in, Logs out, and checks LOG IN button is shown
     */
    @Test(description="Validate you are logged out", priority = 2)
    public void verifyCloseSessionPage (){
        LoginPage loginPageObject = new LoginPage(driver);
        HomePage homePageObject = loginPageObject.loginToPage(emailAddress,password);
        homePageObject.clickOnLogOut();
        String loginButton = loginPageObject.getLoginButton();
        Assert.assertTrue(loginButton.toLowerCase().contentEquals("log in"),"does not match");
        }
}
