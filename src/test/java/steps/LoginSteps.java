package steps;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java8.En;
import org.junit.Assert;
import org.openqa.selenium.support.PageFactory;
import pages.LoginPage;
import pages.MenuPage;
import setup.Setup;

import java.awt.*;

public class LoginSteps implements En {

    LoginPage loginPage;
    MenuPage menuPage;

    @Before
    public void setup(){
        loginPage = PageFactory.initElements(Setup.getDriver(), LoginPage.class);
        menuPage = PageFactory.initElements(Setup.getDriver(), MenuPage.class);
    }
    public LoginSteps(){

        Given("I visit page", () -> {
            Setup.getDriver().get("http://the-internet.herokuapp.com");
        });

        And("I click in FormAuthentication", () -> {
            menuPage.clickFormAuthentication();
        });

        When("I put credentials {string} and password {string}", (String username, String password) -> {
            loginPage.login(username, password);
        });

        Then("screen sucess appear", () -> {
            Assert.assertTrue(loginPage.test());
        });

   }

    @After
    public static void tearDown(){
        Setup.driverManager.quitWebDriver();
    }


}
