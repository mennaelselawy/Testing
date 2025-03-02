package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ForgetPasswordPage {
    private WebDriver driver;
    private By emailField =By.id("email");
    private By retrievePasswordButton = By.id("form_submit");

    //constructor
    ForgetPasswordPage(WebDriver driver){
        this.driver = driver;
    }

    public void writeEmail(String email){
        driver.findElement(emailField).sendKeys(email);
    }

    public RetrievePasswordPage clickRetrievePasswordButton(){
        driver.findElement(retrievePasswordButton).click();
        return new RetrievePasswordPage(driver);
    }
}
