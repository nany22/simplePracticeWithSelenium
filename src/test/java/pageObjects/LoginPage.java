package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import testObjects.HomeTest;

/*This page class will go to the login page only, without log in. Pages are the only one using Selenium driver directly*/
/*Pages will have attributes and methods are used in the current page*/

public class LoginPage extends PageObject {
        @FindBy(css = "input#email")
        WebElement emailAddressElement;

        @FindBy(id = "password")
        WebElement passwordElement;

        @FindBy(css ="button[type='submit']")
        WebElement btnElement;

        @FindBy(css ="button.lightGrey")
        WebElement loginButtonTextElement;

    /*Constructor: call tu constructor in the super class*/
    public LoginPage(WebDriver driver){
        super(driver);
    }

    private void setEmailAddress (String emailAddress){
        this.emailAddressElement.sendKeys(emailAddress);
    }

    private void setPassword (String password){
        this.passwordElement.sendKeys(password);
    }

    private void clickButton (){
        this.btnElement.click();

    }

    /*Log in to Pinterest*/
    public HomePage loginToPage(String emailAddress, String password){
        setEmailAddress(emailAddress);
        setPassword(password);
        clickButton();
        /*As best practices when you navigate,you should return the page object for the next page*/
        return (new HomePage(driver));
    }

    /*obtain the text of Log in button (in the right side at top of the page) when you access to the Pinterest url*/
    public String getLoginButton (){
       return (this.loginButtonTextElement.getText());
    }

}
