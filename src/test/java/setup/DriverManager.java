package setup;

import org.openqa.selenium.WebDriver;

public abstract class DriverManager {
    protected WebDriver driver;
    protected abstract void createWebDriver();

    public void quitWebDriver(){
        if(driver!=null){
            return;
        }
        driver.quit();
        driver = null;
    }

    public WebDriver getWebDriver(){
        createWebDriver();
        return driver;
    }
}
