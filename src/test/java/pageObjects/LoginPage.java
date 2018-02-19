package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;



/*This page class will go to the login page only, without log in. Pages are the only one using Selenium driver directly*/

public class LoginPage extends PageObject {
        String url = "https://ar.pinterest.com/";

        @FindBy(css = "input#email")
        WebElement emailAddressElement;

        @FindBy(id = "password")
        WebElement passwordElement;

        @FindBy(css ="button[type='submit']")
        WebElement btnElement;


        @FindBy(css ="button.lightGrey")
        WebElement loginButtonTextElement;


    public LoginPage(WebDriver driver){
        super(driver);
    }

    public void goToURL(){
        this.driver.get(this.url);
    }

    private void setEmailAddress (String emailAddress){
        //emailAddressElement = driver.findElement(By.cssSelector("input#email"));
        this.emailAddressElement.sendKeys(emailAddress);
    }

    private void setPassword (String password){
        //passwordElement = driver.findElement(By.id("password"));
        this.passwordElement.sendKeys(password);
    }

    private void clickButton (){
        //btnElement = driver.findElement(By.cssSelector("button[type='submit']"));
        this.btnElement.click();
        /*Here is needed a wait.Working on that*/
        //wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div._5k")));
    }

    /*Log in to Pinterest*/
    public void loginToPage(String emailAddress, String password){
        setEmailAddress(emailAddress);
        setPassword(password);
        clickButton();
    }

    /*obtain the text of Log in button when you access to the Pinterest url*/
    public String getLoginButton (){
       //WebElement loginButtonTextElement = driver.findElement(By.cssSelector("button.lightGrey"));
       return (this.loginButtonTextElement.getText());
    }

}
