package setup;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeDriverManager extends DriverManager {

    @Override
    protected void createWebDriver() {
        System.setProperty("webdriver.chrome.driver", "/var/lib/jenkins/jobs/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("headless");
        this.driver = new ChromeDriver(options);
    }
}
