package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WysiwygEditorPage {
    private WebDriver driver;
    private String iFrameEditorID = "mce_0_ifr";
    private By textArea = By.id("tinymce");
    private By decreaseIndentButton = By.cssSelector("#mceu_12 button");
    public WysiwygEditorPage(WebDriver driver){
        this.driver = driver;
    }
    //Now we do not have the access to edit on this page but we will act as we can edit
    /**
     * first we need to switch to the IFrame which have the Edit Area
     */
    private void switchToEditArea(){
        driver.switchTo().frame(iFrameEditorID);
    }
    /**
     * we will clear what is written in the editor text area in the iframe
     */
    public void clearTextArea(){
        switchToEditArea();
        driver.findElement(textArea).clear();
        switchToTheMainArea();
    }
    public void writeTextArea(String text){
        switchToEditArea();
        driver.findElement(textArea).sendKeys(text);
        switchToTheMainArea();
    }
    public String getTextFromEditor(){
        switchToEditArea();
        String text = driver.findElement(textArea).getText();
        switchToTheMainArea();
        return text;
    }
    /**
     * after doing what i want in the iframe i should EXIT THE I FRAME
     */
    private void switchToTheMainArea(){
        driver.switchTo().parentFrame();
    }
    public void decreaseIndention(){
        driver.findElement(decreaseIndentButton).click();
    }
}
