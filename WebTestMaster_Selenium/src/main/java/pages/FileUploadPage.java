package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FileUploadPage {
    private WebDriver driver;
    private By inputFileField = By.id("file-upload");
    private By uploadButton = By.id("file-submit");
    private By uploadedFiles = By.id("uploaded-files");
    public FileUploadPage(WebDriver driver){
        this.driver=driver;
    }

    public void clickUploadButton(){
        driver.findElement(uploadButton).click();
    }

    /**
     * provides the path of the file in the device as an input then click upload button
     * @param absolutePathOfFile the complete path of the file to upload it
     */
    public void chooseFile(String absolutePathOfFile){
        driver.findElement(inputFileField).sendKeys(absolutePathOfFile);
        clickUploadButton();
    }
    public String getUploadedFiles(){
        return driver.findElement(uploadedFiles).getText();
    }
}
