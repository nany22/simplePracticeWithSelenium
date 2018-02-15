package testObjects;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.LoginPage;

public class LoginTest  extends AbstractTest{
    LoginPage loginPageObject;

    @BeforeClass
    public void setup(){
        super.setup();
        this.driver.get(url);
        this.loginPageObject = new LoginPage(driver);
    }

    @Test(description="Validate you are on the Login Page",priority = 1)
    public void verifyLoginButton (){
        String loginButton = loginPageObject.getLoginButton();
        Assert.assertTrue(loginButton.toLowerCase().contentEquals("log in"),"es distinto");
    }

    @AfterClass
    public void tearDown(){
        super.tearDown();
    }

}
