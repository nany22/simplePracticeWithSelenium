package testObjects;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.LoginPage;

public class LoginTest  extends TestObject{
    LoginPage loginPageObject;

    @BeforeClass
    public void setup(){
        super.setup();
        this.loginPageObject = new LoginPage(driver);
        this.loginPageObject.goToURL();
    }

    @Test(description="Validate you are on the Login Page",priority = 1)
    public void verifyLoginButton (){
        String loginButton = loginPageObject.getLoginButton();
        Assert.assertTrue(loginButton.toLowerCase().contentEquals("log in"),"does not match");
    }

}
