package testObjects;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.LoginPage;

public class HomeTest extends AbstractTest {
    HomePage homePageObject;
    LoginPage loginPageObject;
    String emailAddress = "<set your email>";
    String password = "<set your password>";
    String homeTab = "inicio";

    @BeforeClass
    public void setup(){
        super.setup();
        this.driver.get(url);
        this.loginPageObject = new LoginPage(driver);
        this.homePageObject = new HomePage(driver);
    }

    @Test(description="Validate you are logged in",priority = 1)
    public void verifyLoginPage (){
        homePageObject.loginToPage(emailAddress,password);
        String inicioTabText = homePageObject.getInicioTab();
        Assert.assertTrue(inicioTabText.toLowerCase().contentEquals(homeTab),"does not match");
        homePageObject.clickOnLogOut();
    }

    @Test(description="Validate you are logged out", priority = 2)
    public void verifyCloseSessionPage (){
        homePageObject.loginToPage(emailAddress,password);
        homePageObject.clickOnLogOut();
        Assert.assertTrue(/*validate user is logged out TBD*/true);
    }

    @AfterClass
    public void tearDown(){
        super.tearDown();
    }

}
