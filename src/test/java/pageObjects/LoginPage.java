package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/*This page class will go to the login page only, without log in*/

public class LoginPage {
        WebDriver driver;
        WebElement loginButtonTextElement;

    /*Constructor,used to be able to then send the driver used in testClass,to this class to continue using the same driver and not another new */
    /*this is used to refers to the driver object declared in that class*/
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

        /*obtain the text of Log in button when you access to the Pinterest url*/
        public String getLoginButton (){
            loginButtonTextElement = driver.findElement(By.cssSelector("button.lightGrey"));
            return (loginButtonTextElement.getText());
        }

}
