package utils;

import org.openqa.selenium.WebDriver;

/**
 * This class will have all related to navigation. All goToUrl for each page will be here
 *
 * <b>driver</b> use "static" modifier because the driver is common to all instances.
 * <b>urlPage</b> is the url needed to access to pinterest and used also after login.
 */

public class Navigation{
    static WebDriver driver;
    String urlPage = "https://ar.pinterest.com/";
    String urlSettings = "https://ar.pinterest.com/settings";

    /**
     *
     * @param driver will be sent via test clases
     */
    public Navigation(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Go to any URL
     * @param url will be sent via the needed goTo method in that class
     */
    private void gotoURL(String url){
        this.driver.get(url);
    }

    /**
     * Go to Login URL
     */
    public void gotoLoginPage(){
        gotoURL(this.urlPage);
    }

    /**
     * Go to Settings URL
    */
    public void gotoSettingsPage(){
        gotoURL(this.urlSettings);
    }

    /**
     * Get the current URL
     * @return the actual url
     */
    public String getCurrentURL(){
       return(this.driver.getCurrentUrl());
    }
}
