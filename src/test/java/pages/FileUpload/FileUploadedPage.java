package pages.FileUpload;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FileUploadedPage {
    @FindBy(css = "#content > div > h3")
    private WebElement textSucess;

    @FindBy(id = "uploaded-files")
    private WebElement fileUploaded;

    public String getTextSucess() {
        return textSucess.getText();
    }

    public String getFileUploaded() {
        return fileUploaded.getText();
    }
}
