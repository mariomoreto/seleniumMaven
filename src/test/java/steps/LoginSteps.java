package steps;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java8.En;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pages.LoginPage;
import setup.DriverManager;
import setup.DriverManagerFactory;
import setup.DriverType;

public class LoginSteps implements En {

    DriverManager driverManager;
    WebDriver driver;
    LoginPage loginPage;

    @Before
    public void setup(){
        driverManager = DriverManagerFactory.getDriverManager(DriverType.CHROME);
        driver = driverManager.getWebDriver();
        loginPage = PageFactory.initElements(driver, LoginPage.class);
    }
    public LoginSteps(){

        Given("I visit page", () -> {
            driver.get("http://the-internet.herokuapp.com/login");
        });

        When("I put credentials {string} and password {string}", (String username, String password) -> {
            loginPage.login(username, password);
        });

        Then("screen sucess appear", () -> {
            Assert.assertTrue(loginPage.test());
        });

   }

   @After
    public void cleanUp(){
        driverManager.quitWebDriver();
   }
}
