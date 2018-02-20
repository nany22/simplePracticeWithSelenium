package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.AssertJUnit;
import sun.font.TrueTypeFont;

import java.util.List;

/*This page class will go to the home page after login. Pages are the only one using Selenium driver directly*/
/*Pages will have attributes and methods are used in the current page*/

public class HomePage extends PageObject{
    @FindBy(css = "div._5k")
    WebElement inicioTabTextElemen;

    @FindBy(css = "div._0:nth-child(7) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > button:nth-child(1)")
    WebElement settingsElement;

    @FindBy(css = "div._0[role=listitem]")
    List<WebElement> dropDownElements;


    /*Constructor: call tu constructor in the super class*/
    public HomePage(WebDriver driver){
        super(driver);
    }

    /*Obtain the text of Inicio tab webElement, at top of the page*/
    public String getInicioTab (){
        return (this.inicioTabTextElemen.getText());
    }

    /*Click on the settings dropdown menu*/
    private void clickOnSettings (){
        this.settingsElement.click();
    }

    /*Logs out*/
    public void clickOnLogOut (){
        this.clickOnSettings();
        /* We depend on list order because pintrest has for dropdown menu,5 elements with only class as value and they are the same.Logout is the 5th element*/
        dropDownElements.get(this.dropDownElements.size() - 1).findElement(By.cssSelector("div._0._3j._2n")).click();
    }

}
