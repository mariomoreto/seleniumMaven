package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MenuPage {

    @FindBy(css="#content > ul > li:nth-child(21) > a")
    private WebElement formAuthentication;

    @FindBy(css="#content > ul > li:nth-child(18) > a")
    private WebElement fileUpload;

    public void clickFormAuthentication(){
        this.formAuthentication.click();
    }

    public void clickFileUpload(){
        this.fileUpload.click();
    }
}
