package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {

    @FindBy(using = "username")
    private WebElement username;

    @FindBy(using = "password")
    private WebElement password;

    @FindBy(css = "#login > button")
    private WebElement btnLogin;

    @FindBy(id="flash")
    private WebElement alertMessage;

    public void setUsername(String username){
        this.username.clear();
        this.username.sendKeys(username);
    }

    public void setPassword(String password){
        this.password.clear();
        this.password.sendKeys(password);
    }

    public void login(String username, String password){
        setUsername(username);
        setPassword(password);
        btnLogin.click();
    }

    public boolean test(){
        return this.alertMessage.isDisplayed();
    }

}
