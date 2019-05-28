package setup;


import cucumber.api.java.After;
import org.openqa.selenium.WebDriver;

public class Setup {
    public static DriverManager driverManager;
    public static WebDriver driver;

    public static WebDriver getDriver(){
        if(driver==null) {
            driverManager = DriverManagerFactory.getDriverManager(DriverType.CHROME);
            return driver = driverManager.getWebDriver();
        }
        return driver;
    }


}
