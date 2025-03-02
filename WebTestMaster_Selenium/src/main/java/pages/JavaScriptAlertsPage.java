package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class JavaScriptAlertsPage {
    private WebDriver driver;
    private By buttonJSAlert = By.xpath(".//button[text()='Click for JS Alert']");
    private By buttonJSConfirm = By.xpath(".//button[text()='Click for JS Confirm']");
    private By buttonJSPrompt = By.xpath(".//button[text()='Click for JS Prompt']");
    //private By buttonJSPrompt = By.linkText("Click for JS Prompt");
    private By resultText = By.id("result");

    public JavaScriptAlertsPage(WebDriver driver){
        this.driver = driver;
    }

    public void clickJSAlert(){
        driver.findElement(buttonJSAlert).click();
    }
    public void alert_acceptAlert(){
        driver.switchTo().alert().accept();
    }
    public String getResult(){
        return driver.findElement(resultText).getText();
    }

    public void clickJSConfirm(){
        driver.findElement(buttonJSConfirm).click();
    }
    public void alert_clickCancelButton(){
        driver.switchTo().alert().dismiss();
    }
    public String alert_getText(){
        return driver.switchTo().alert().getText();
    }


    public void clickJSPrompt(){
        driver.findElement(buttonJSPrompt).click();
    }
    public void alert_enterJSPrompt(String text) {
        driver.switchTo().alert().sendKeys(text);
    }
}
