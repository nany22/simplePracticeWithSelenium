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
    String emailAddress = "danielaojeda22@gmail.com";
    String password = "30132371";

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
        Assert.assertTrue(inicioTabText.toLowerCase().contentEquals("inicio"),"es distinto");
        /*I need to logs out in each test, because each one needs to be atomic*/
        //homePageObject.clickOnLogOut();
    }

    //@Test(description="Validate you are logged out", priority = 2)
    public void verifyCloseSessionPage (){
        homePageObject.loginToPage(emailAddress,password);
        homePageObject.logoutOfPage(emailAddress,password);

        //Assert.assertTrue(inicioTabText.toLowerCase().contentEquals("inicio"),"es distinto");
    }

    @AfterClass
    public void tearDown(){
        super.tearDown();
    }

}
