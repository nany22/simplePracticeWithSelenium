package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * This page class will go to the login page only, without log in.
 * Pages are the only one using Selenium driver directly
 * Pages will have attributes and methods are used in the current page
 *
 * <b>emailAddressElement</b> represents the input text field for email
 * <b>passwordElement</b> represents the input text field for password
 * <b>btnElement</b> represents the submit button when log in
 */

public class LoginPage extends PageObject {
        @FindBy(css = "input#email")
        WebElement emailAddressElement;

        @FindBy(id = "password")
        WebElement passwordElement;

        @FindBy(css ="button[type='submit']")
        WebElement btnElement;

        @FindBy(css ="button.lightGrey")
        WebElement loginButtonTextElement;

    /**
     * Constructor: call to constructor in the super class {@link PageObject}
     * @param driver will be sent from test
    */
    public LoginPage(WebDriver driver){
        super(driver);
    }

    /**
     * Set email sent as parameter in the email attribute
     */
    private void setEmailAddress (String emailAddress){
        this.emailAddressElement.sendKeys(emailAddress);
    }

    /**
     * Set password sent as parameter in the password attribute
     */
    private void setPassword (String password){
        this.passwordElement.sendKeys(password);
    }

    /**
     * Click the Submit button after log in
     */
    private void clickButton (){
        this.btnElement.click();
    }

    /**
     * Log in to Pinterest using parameters sent
     * @param emailAddress will be sent from {@link testObjects.LoginTest}
     * @param password will be sent from {@link testObjects.LoginTest}
     * @return HomePage class. As best practices when you navigate,you should return the page object for the next page
     */
    public HomePage loginToPage(String emailAddress, String password){
        setEmailAddress(emailAddress);
        setPassword(password);
        clickButton();
        return (new HomePage(driver));
    }

    /**
     * obtain the text of "Log in" button (in the right side at top of the page)
     * when you access to the Pinterest url
     * @return  the text of log in button
     */
    public String getLoginButton (){
       return (this.loginButtonTextElement.getText());
    }

}
