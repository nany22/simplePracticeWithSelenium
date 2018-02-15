package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;

/*This page class will go to the home page after login*/

public class HomePage {
    WebDriver driver;
    WebElement emailAddressElement;
    WebElement passwordElement;
    //WebDriverWait wait = new WebDriverWait(driver, 100);

    /*Constructor,used to be able to then send the driver used in testClass,to this class to continue using the same driver and not another new */
    /*this is used to refers to the driver object declared in that class*/
    public HomePage(WebDriver driver) {
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

    /*Obtain the text of Inicio tab webElement, shown after user log in Pinterest*/
    public String getInicioTab (){
        WebElement inicioTabTextElement = driver.findElement(By.cssSelector("div._5k"));
        return (inicioTabTextElement.getText());
    }

    /*Click on the settings dropdown menu*/
    private void clickOnSettings (){
        WebElement settingsElement = driver.findElement(By.cssSelector("div._0:nth-child(7) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > button:nth-child(1)"));
        settingsElement.click();
        /*Here is needed a wait.Working on that*/
        //wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div._0[role=listitem]")));

    }

    /*Logs out*/
    public void clickOnLogOut (){
        WebElement childFound;
        childFound = null ; /*you need to inicialize the webelement*/
        this.clickOnSettings();
        /*Work in Progress:*/
        List<WebElement> dropDownElements = driver.findElements(By.cssSelector("div._0[role=listitem]"));
        for (WebElement dropDownElement : dropDownElements){
            childFound = dropDownElement.findElement(By.cssSelector("div._0._3j._2n"));
        }
        childFound.click();
    }

}
