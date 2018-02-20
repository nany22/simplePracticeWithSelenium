package utils;

import org.openqa.selenium.WebDriver;

/*This class will have all related to navigation. All goToUrl for each page will be here*/
public class Navigation{
    /*using static modifier, the driver can be accessed directly without creating any Navigation object */
    static WebDriver driver;
    String urlPage = "https://ar.pinterest.com/";
    String urlSettings = "https://ar.pinterest.com/settings";

    public Navigation(WebDriver driver) {
        this.driver = driver;
    }

    /*Go to any URL*/
    private void gotoURL(String url){
        this.driver.get(url);
    }

    /*Go to Login URL*/
    public void gotoLoginPage(){
        gotoURL(this.urlPage);
    }

    /*Go to Settings URL*/
    public void gotoSettingsPage(){
        gotoURL(this.urlSettings);
    }

    public String getCurrentURL(){
        return(this.driver.getCurrentUrl());
    }
}
