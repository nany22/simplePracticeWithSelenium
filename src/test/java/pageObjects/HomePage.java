package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;

/*This page class will go to the home page after login. Pages are the only one using Selenium driver directly*/

public class HomePage extends PageObject{
    String url = "https://ar.pinterest.com/";

    @FindBy(css = "div._5k")
    WebElement inicioTabTextElemen;

    @FindBy(css = "div._0:nth-child(7) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > button:nth-child(1)")
    WebElement settingsElement;

    @FindBy(css = "div._0[role=listitem]")
    List<WebElement> dropDownElements;

    //WebDriverWait wait = new WebDriverWait(driver, 100);

    public HomePage(WebDriver driver){
        super(driver);
    }

    public void goToURL(){
        this.driver.get(this.url);
    }

    /*Obtain the text of Inicio tab webElement, shown after user log in Pinterest*/
    public String getInicioTab (){
        //WebElement inicioTabTextElement = driver.findElement(By.cssSelector("div._5k"));
        return (this.inicioTabTextElemen.getText());
    }

    /*Click on the settings dropdown menu*/
    private void clickOnSettings (){
        //WebElement settingsElement = driver.findElement(By.cssSelector("div._0:nth-child(7) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > button:nth-child(1)"));
        this.settingsElement.click();
        /*Here is needed a wait.Working on that*/
        //wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div._0[role=listitem]")));
    }

    /*Logs out*/
    public void clickOnLogOut (){
        this.clickOnSettings();
        //List<WebElement> dropDownElements = driver.findElements(By.cssSelector("div._0[role=listitem]"));
        /* We depend on list order because pintrest has for dropdown menu,5 elements with only class as value and they are the same.Logout is the 5th element*/
        dropDownElements.get(this.dropDownElements.size() - 1).findElement(By.cssSelector("div._0._3j._2n")).click();
    }

}
