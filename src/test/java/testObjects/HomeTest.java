package testObjects;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import utils.Navigation;

/*This class will have all possible tests related to the page LoginPage*/
/*The inicialization of classes needs to be done after goto the URL that redirects to you to the page, so after you are in the page, you now can instantiate that*/
public class HomeTest extends TestObject {
    String emailAddress = "<set your email>";
    String password = "<set your password>";
    String homeTab = "continue as a business";


    @BeforeTest
    /*Before each test, the setup in super class (TestObject) and setup here, will be run*/
    public void setupTest(){
        Navigation navigation = new Navigation(driver);
        navigation.gotoLoginPage();
    }

    @Test(description="Validate you are logged in",priority = 1)
    public void verifyLoginPage (){
        LoginPage loginPageObject = new LoginPage(driver);
        /*TBD: validate it is initialized, use junit or testNG*/
        HomePage homePageObject = loginPageObject.loginToPage(emailAddress,password);
        /*TBD: validate it is initialized use junit or testNG*/
        String inicioTabText = homePageObject.getInicioTab();
        /*TBD: catch assert, to be able to continue with next line if assert fails*/
        Assert.assertTrue(inicioTabText.toLowerCase().contentEquals(homeTab), "does not match");
        homePageObject.clickOnLogOut();
    }

    @Test(description="Validate you are logged out", priority = 2)
    public void verifyCloseSessionPage (){
        LoginPage loginPageObject = new LoginPage(driver);
        /*TBD: validate it is initialized use junit or testNG*/
        HomePage homePageObject = loginPageObject.loginToPage(emailAddress,password);
        /*TBD: validate it is initialized use junit or testNG*/
        homePageObject.clickOnLogOut();
        String inicioTabText = homePageObject.getInicioTab();
        //"inicioTabText" will doesn't match with the string inside of "homeTab" after logs out it will have another string"
        Assert.assertFalse(inicioTabText.toLowerCase().contentEquals(homeTab),"does match");
        }
}
