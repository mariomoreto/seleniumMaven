package pages.FileUpload;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FileUploadPage {
    @FindBy(id = "file-upload")
    private WebElement fieldUpload;

    @FindBy(id = "file-submit")
    private WebElement btnUpload;

    public FileUploadPage uploadFile(String path){
        fieldUpload.sendKeys(path);
        return this;
    }

    public FileUploadPage clickBtnUpload(){
        btnUpload.click();
        return this;
    }
}
