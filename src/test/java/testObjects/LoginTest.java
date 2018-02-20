package testObjects;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.LoginPage;
import utils.Navigation;

/*This class will have all possible tests related to the page LoginPage*/
/*The inicialization of classes needs to be done after goto the URL that redirects to you to the page, so after you are in the page, you now can instantiate that*/
public class LoginTest  extends TestObject{

    @BeforeTest
    /*Before each test, the setup in super class (TestObject) and setup here, will be run*/
    public void setupTest(){
        Navigation navigation = new Navigation(driver);
        navigation.gotoLoginPage();
    }

    @Test(description="Validate you are on the Login Page",priority = 1)
    public void verifyLoginButton (){
        LoginPage loginPageObject = new LoginPage(driver);
        /*TBD: validate it is initialized use junit or testNG*/
        String loginButton = loginPageObject.getLoginButton();
        Assert.assertTrue(loginButton.toLowerCase().contentEquals("log in"),"does not match");
    }

}
