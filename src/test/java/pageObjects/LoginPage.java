package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/*This page class will go to the login page only, without log in*/

public class LoginPage {
        WebDriver driver;
        WebElement emailAddressElement;
        WebElement passwordElement;
        WebElement loginButtonTextElement;

    /*Constructor,used to be able to then send the driver used in testClass,to this class to continue using the same driver and not another new */
    /*this is used to refers to the driver object declared in that class*/
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    private void setEmailAddress (String emailAddress){
        emailAddressElement = driver.findElement(By.cssSelector("input#email"));
        emailAddressElement.sendKeys(emailAddress);
    }

    private void setPassword (String password){
        passwordElement = driver.findElement(By.id("password"));
        passwordElement.sendKeys(password);
    }

    private void clickButton (){
        WebElement btnElement = driver.findElement(By.cssSelector("button[type='submit']"));
        btnElement.click();
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
       loginButtonTextElement = driver.findElement(By.cssSelector("button.lightGrey"));
       return (loginButtonTextElement.getText());
    }

}
