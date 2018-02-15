package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;

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
        /*deberia ir un wait, este no se por que no anda, pero para q terminen de cargar la pagina despues del click*/
        //wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div._5k")));
    }

    /*Log in to Pinterest*/
    public void loginToPage(String emailAddress, String password){
        setEmailAddress(emailAddress);
        setPassword(password);
        clickButton();
    }

    /*Obtain the text of Inicio tab, shown after user log in Pinterest*/
    public String getInicioTab (){
        WebElement inicioTabTextElement = driver.findElement(By.cssSelector("div._5k"));
        return (inicioTabTextElement.getText());
    }

    private void clickOnSettings (){
        WebElement settingsElement = driver.findElement(By.cssSelector("div._0:nth-child(7) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > button:nth-child(1)"));
        settingsElement.click();
        //wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div._0[role=listitem]")));

    }

    public void clickOnLogOut (){
        this.clickOnSettings();
        WebElement logOutMainElement = driver.findElement(By.cssSelector("div._0[role=listitem]"));
        //System.out.println(logOutElement);
        WebElement logOutElement = logOutMainElement.findElement(By.className("div._0._3j._2n"));
    }

    /*Login and then logs out*/
    public void logoutOfPage (String emailAddress, String password){
        this.loginToPage(emailAddress,password);
        this.clickOnLogOut();
        /*deberia ir un wait, este no se por que no anda, pero para q termien de cargar la pagina despues de salir*/
        //wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div._5k")));
    }

}
