package setup;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeDriverManager extends DriverManager {

    @Override
    protected void createWebDriver() {
        System.setProperty("webdriver.chrome.driver", "/home/mario/Documents/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("headless");
        this.driver = new ChromeDriver(options);
    }
}
