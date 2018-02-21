package testObjects;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
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
 */

 public class LoginTest  extends TestObject{

    /**
    * Before run this setup, will run setup in the superclass {@link TestObject}
     * Initialize Navigation class to then be able to go to needed URL on each page
    * */
    @BeforeMethod
    public void setupTest(){
        Navigation navigation = new Navigation(driver);
        navigation.gotoLoginPage();
    }

    /**
     * Do a check of LOG IN tab shown in the page
     */
    @Test(description="Validate you are on the Login Page",priority = 1)
    public void verifyLoginButton (){
        LoginPage loginPageObject = new LoginPage(driver);
        String loginButton = loginPageObject.getLoginButton();
        Assert.assertTrue(loginButton.toLowerCase().contentEquals("log in"),"does not match");
    }
}
