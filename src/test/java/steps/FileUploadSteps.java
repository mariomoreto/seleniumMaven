package steps;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java8.En;
import cucumber.api.java8.Pa;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pages.FileUpload.FileUploadPage;
import pages.FileUpload.FileUploadedPage;
import pages.MenuPage;
import setup.DriverManager;
import setup.DriverManagerFactory;
import setup.DriverType;
import setup.Setup;

import java.io.File;

public class FileUploadSteps implements En {

    MenuPage menuPage;
    FileUploadPage fileUploadPage;
    FileUploadedPage fileUploadedPage;

    @Before
    public void setup(){
        menuPage = PageFactory.initElements(Setup.getDriver(), MenuPage.class);
        fileUploadPage = PageFactory.initElements(Setup.getDriver(), FileUploadPage.class);
        fileUploadedPage = PageFactory.initElements(Setup.getDriver(), FileUploadedPage.class);
    }

    public FileUploadSteps(){

        And("I click in FileUpload", ()->{
            menuPage.clickFileUpload();
        });


        When("I select file", () -> {
            String path = new File("resource/teste.txt").getAbsolutePath();
            fileUploadPage.uploadFile(path);
        });


        When("I press in upload", () -> {
            fileUploadPage.clickBtnUpload();
        });

        Then("screen upload sucess appear", () -> {
            Assert.assertEquals("File Uploaded!", fileUploadedPage.getTextSucess());
            Assert.assertEquals("teste.txt", fileUploadedPage.getFileUploaded());
        });
    }

    @After
    public static void tearDown(){
        Setup.driverManager.quitWebDriver();
    }
}
